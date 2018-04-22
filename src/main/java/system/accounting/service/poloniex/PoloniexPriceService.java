package system.accounting.service.poloniex;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import system.accounting.exception.CoinPriceNotFoundException;
import system.accounting.exception.RestTemplateException;
import system.accounting.service.PullDataService;

import java.io.IOException;

/**
 * Created by KAI on 4/19/18.
 */

@Service("poloniexPriceService")
public class PoloniexPriceService implements PullDataService {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void synDataFromCMK() throws RestTemplateException, IOException {

    }

    @Override
    public void synDataFromCCP() throws RestTemplateException, IOException {

    }

    @Override
    public void getPrices() throws CoinPriceNotFoundException, IOException {

    }
}
