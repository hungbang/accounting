package system.accounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import system.accounting.exception.CoinsDataNotFoundException;

import java.io.IOException;
import java.util.Set;

/**
 * Created by KAI on 4/22/18.
 */
@Service
public class FileIntenalHelper {

    @Autowired
    @Qualifier("coinCompareService")
    private CoinService coinService;

    public int countOfAllCoins() throws IOException, CoinsDataNotFoundException {
        Set<String> coinNames = coinService.getCoinsSupported();

        return coinNames.size();

    }
}
