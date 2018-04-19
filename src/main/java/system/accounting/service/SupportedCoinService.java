package system.accounting.service;

import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.CoinsDataResponseWrapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by KAI on 4/14/18.
 */
public interface SupportedCoinService {

    <T> List<T> getCoinsSupported() throws IOException;

    CoinsDataMapper findCoinsByKeyword(String keyword) throws IOException, CoinsDataNotFoundException;

    CoinsDataResponseWrapper getPriceOfCoin(String keyword, BigDecimal amount) throws IOException, CoinsDataNotFoundException;


}
