package system.accounting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service("coinMarketCapService")
public class SupportedCoinServiceImpl implements SupportedCoinService {

    @Value("${coinmarketcap.api.dataPath.original}")
    private String original;

    @Override
    public List<CoinsDataMapper> getCoinsSupported() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(original).getFile());
        List<CoinsDataMapper> coinsDataMapper = Arrays.asList(objectMapper.readValue(file, CoinsDataMapper[].class));
        return coinsDataMapper;
    }

    @Override
    public CoinsDataMapper findCoinsByKeyword(String keyword) throws IOException, CoinsDataNotFoundException {
        List<CoinsDataMapper> coinsDataMappers = this.getCoinsSupported();
        return coinsDataMappers.stream().filter(var0 -> var0.getId().equalsIgnoreCase(keyword) || var0.getSymbol().equalsIgnoreCase(keyword)).findFirst().orElseThrow(() ->new CoinsDataNotFoundException());
    }

    @Override
    public CoinsDataResponseWrapper getPriceOfCoin(String keyword, BigDecimal amount) throws IOException, CoinsDataNotFoundException {
        CoinsDataMapper coinsDataMapper = this.findCoinsByKeyword(keyword);
        BigDecimal price = new BigDecimal(coinsDataMapper.getPriceUsd());
        BigDecimal totalUsd = amount.multiply(price).setScale(2, BigDecimal.ROUND_HALF_UP);
        return parseCoinsDataResponseWrapper(coinsDataMapper, totalUsd);
    }

    private CoinsDataResponseWrapper parseCoinsDataResponseWrapper(CoinsDataMapper coinsDataMapper, BigDecimal total) {
        CoinsDataResponseWrapper coinsDataResponseWrapper = new CoinsDataResponseWrapper();
        coinsDataResponseWrapper.setCoinsDataMapper(coinsDataMapper);
        coinsDataResponseWrapper.setTotalUsd(total);
        return coinsDataResponseWrapper;
    }
}
