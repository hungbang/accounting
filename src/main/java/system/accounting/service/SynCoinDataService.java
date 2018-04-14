package system.accounting.service;

import system.accounting.exception.RestTemplateException;

import java.io.IOException;

/**
 * Created by KAI on 4/14/18.
 */
public interface SynCoinDataService {

    void synCoinsData() throws RestTemplateException, IOException;

}
