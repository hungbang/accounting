package system.accounting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.accounting.exception.CoinNotFoundException;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinList;
import system.accounting.model.CoinRequestBody;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;
import system.accounting.properties.CoinCompareProperties;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by KAI on 4/19/18.
 */
@Service("coinCompareService")
public class CoinCompareService implements CoinService {


    @Autowired
    private CoinCompareProperties coinCompareProperties;

    @Override
    public Set getCoinsSupported() throws IOException, CoinsDataNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinCompareProperties.getApi().getDataJson().getCoins()).getFile());
        CoinList coinList = objectMapper.readValue(file, CoinList.class);
        if(Objects.isNull(coinList))
            throw new CoinsDataNotFoundException("Coin list is empty");
        Map map = coinList.getDetailMap();
        return map.keySet();
    }

    @Override
    public CoinsDataMapper findCoinsByKeyword(String keyword) throws IOException, CoinsDataNotFoundException {
        return null;
    }

    @Override
    public CoinsDataResponseWrapper getPriceOfCoin(String keyword, BigDecimal amount) throws IOException, CoinsDataNotFoundException {
        return null;
    }

    @Override
    public <T> T getAllCoins() throws CoinNotFoundException {
        return null;
    }

    @Override
    public <T> T saveAllCoins(CoinRequestBody coinRequestBody) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

}
