package system.accounting.service;

import system.accounting.exception.CoinPriceNotFoundException;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.exception.RestTemplateException;

import java.io.IOException;

/**
 * Created by KAI on 4/14/18.
 */
public interface PullDataService {

    void synDataFromCMK() throws RestTemplateException, IOException, CoinsDataNotFoundException;
    void synDataFromCCP() throws RestTemplateException, IOException;
    void getPrices() throws CoinPriceNotFoundException, IOException;

}
