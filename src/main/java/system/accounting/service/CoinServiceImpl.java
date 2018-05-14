package system.accounting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.accounting.domain.Coin;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.manager.CoinManager;
import system.accounting.model.CoinRequestBody;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;
import system.accounting.properties.CoinMarketCapProperties;
import system.accounting.repository.CoinRepository;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Component("coinMarketCapService")
public class CoinServiceImpl implements CoinService {


    @Autowired
    private CoinMarketCapProperties coinMarketCapProperties;

    @Autowired
    private CoinManager coinManager;

    @Autowired
    private CoinRepository coinRepository;

    @Override
    public List<CoinsDataMapper> getCoinsSupported() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinMarketCapProperties.getApi().getDataJson().getCoins()).getFile());
        List<CoinsDataMapper> coinsDataMapper = Arrays.asList(objectMapper.readValue(file, CoinsDataMapper[].class));
        return coinsDataMapper;
    }

    @Override
    public CoinsDataMapper findCoinsByKeyword(String keyword) throws IOException, CoinsDataNotFoundException {
        List<CoinsDataMapper> coinsDataMappers = this.getCoinsSupported();
        return coinsDataMappers.stream().filter(var0 -> var0.getId().equalsIgnoreCase(keyword) || var0.getSymbol().equalsIgnoreCase(keyword)).findFirst().orElseThrow(() -> new CoinsDataNotFoundException());
    }

    @Override
    public CoinsDataResponseWrapper getPriceOfCoin(String keyword, BigDecimal amount) throws IOException, CoinsDataNotFoundException {
        CoinsDataMapper coinsDataMapper = this.findCoinsByKeyword(keyword);
        BigDecimal price = new BigDecimal(coinsDataMapper.getPriceUsd());
        BigDecimal totalUsd = amount.multiply(price).setScale(8, BigDecimal.ROUND_HALF_UP);
        return parseCoinsDataResponseWrapper(coinsDataMapper, totalUsd);
    }

    @Override
    public <T> T getAllCoins() throws CoinNotFoundException {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Coin> coins = coinManager.getAllCoins(username);
        return (T) coins;
    }

    @Override
    public <T> T saveAllCoins(CoinRequestBody coinRequestBody) {
        return (T) saveCoins(coinRequestBody);
    }

    @Override
    public void delete(String id) {
        Optional<Coin> coinOptional = coinRepository.findById(id);
        if(coinOptional.isPresent())
            coinRepository.delete(coinOptional.get());
    }


    private List<Coin> saveCoins(CoinRequestBody coinRequestBody) {
        List<Coin> coins = new ArrayList<>();
        List<CoinRequestBody.CoinData> coinDatas = coinRequestBody.getCoinDatas();
        if(coinDatas.isEmpty())
            return null;

        coinDatas.stream().forEach(coinData -> {
            Coin coin = new Coin();
            coin.setAmount(NumberUtils.createBigDecimal(coinData.getAmount()));
            coin.setCoinName(coinData.getCoinName());
            coin.setPriceBuy(NumberUtils.createBigDecimal(coinData.getPriceBuy()));
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            coin.setUserId(username);
            coin.setId(coinData.getId());
            Coin coinSaved = coinManager.bulkSaveOrUpdate(coin);
            coins.add(coinSaved);
        });
        return coins;
    }

    private CoinsDataResponseWrapper parseCoinsDataResponseWrapper(CoinsDataMapper coinsDataMapper, BigDecimal total) {
        CoinsDataResponseWrapper coinsDataResponseWrapper = new CoinsDataResponseWrapper();
        coinsDataResponseWrapper.setCoinsDataMapper(coinsDataMapper);
        coinsDataResponseWrapper.setTotalUsd(total);
        return coinsDataResponseWrapper;
    }


}
