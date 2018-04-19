package system.accounting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import system.accounting.exception.RestTemplateException;
import system.accounting.model.CoinList;
import system.accounting.model.CoinsDataMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KAI on 4/14/18.
 */
@Service("synCoinDataServiceImpl")
public class SynCoinDataServiceImpl implements SynCoinDataService {

    @Value("${coinmarketcap.api.ticket}")
    private String ticketUrl;

    @Value("${coincompare.api.ticket}")
    private String ticketUrlCoinCompare;

    @Value("${coinmarketcap.api.dataPath.synNewest}")
    private String coinlistDataPath;

    @Value("${coincompare.api.dataPath.synNewest}")
    private String coinlistDataPathCoinCompare;

    @Value("${coinmarketcap.api.dataPath.original}")
    private String original;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void synCoinsData() throws RestTemplateException, IOException {
        ResponseEntity<CoinsDataMapper[]> responseEntity = restTemplate.getForEntity(ticketUrl, CoinsDataMapper[].class);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK))
            throw new RestTemplateException("Could not get ticket collection.");

        List<CoinsDataMapper> coinsDataMappers = Arrays.asList(responseEntity.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinlistDataPath).getFile());
        objectMapper.writeValue(file, coinsDataMappers);

    }

    @Override
    public void synCoinsDataFromCoinCompare() throws RestTemplateException, IOException {
        ResponseEntity<CoinList> responseEntity = restTemplate.getForEntity(ticketUrlCoinCompare, CoinList.class);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK))
            throw new RestTemplateException("Could not get ticket collection.");

        CoinList coinsDataMappers = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinlistDataPathCoinCompare).getFile());
        objectMapper.writeValue(file, coinsDataMappers);
    }

    @Override
    public void getPrices() {
    }
}
