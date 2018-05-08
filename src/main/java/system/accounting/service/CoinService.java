package system.accounting.service;

import system.accounting.exception.CoinNotFoundException;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinRequestBody;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by KAI on 4/14/18.
 */
public interface CoinService {

    <T> T getCoinsSupported() throws IOException, CoinsDataNotFoundException;

    CoinsDataMapper findCoinsByKeyword(String keyword) throws IOException, CoinsDataNotFoundException;

    CoinsDataResponseWrapper getPriceOfCoin(String keyword, BigDecimal amount) throws IOException, CoinsDataNotFoundException;

    <T> T getAllCoins() throws CoinNotFoundException;

    <T> T saveAllCoins(CoinRequestBody coinRequestBody);

    void  delete(String id);
}
