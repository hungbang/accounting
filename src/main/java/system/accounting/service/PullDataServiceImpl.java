package system.accounting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.exception.RestTemplateException;
import system.accounting.model.CoinList;
import system.accounting.model.CoinsDataMapper;
import system.accounting.properties.CoinCompareProperties;
import system.accounting.properties.CoinMarketCapProperties;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KAI on 4/14/18.
 */
@Service("synCoinDataServiceImpl")
public class PullDataServiceImpl implements PullDataService {


    public static final Logger LOGGER = LoggerFactory.getLogger(PullDataServiceImpl.class);

    @Autowired
    private CoinMarketCapProperties coinMarketCapProperties;

    @Autowired
    private CoinCompareProperties coinCompareProperties;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FileIntenalHelper fileIntenalHelper;

    @Override
    public void synDataFromCMK() throws RestTemplateException, IOException, CoinsDataNotFoundException {

        int count = fileIntenalHelper.countOfAllCoins();

        LOGGER.info("count of coin : " + count);

        Map<String, Integer> params = new HashMap<>();
        params.put("limit", count);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(coinMarketCapProperties.getApi().getTicket()).queryParam("limit", count);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<CoinsDataMapper[]> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, CoinsDataMapper[].class);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK))
            throw new RestTemplateException("Could not get ticket collection.");

        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinMarketCapProperties.getApi().getDataJson().getCoins()).getFile());

        //clear file before save again
        if (file.exists() && file.isFile())
            file.delete();
        file.createNewFile();

        objectMapper.writeValue(file, responseEntity.getBody());

    }

    @Override
    public void synDataFromCCP() throws RestTemplateException, IOException {
        ResponseEntity<CoinList> responseEntity = restTemplate.getForEntity(coinCompareProperties.getApi().getTicket(), CoinList.class);
        if (!responseEntity.getStatusCode().equals(HttpStatus.OK))
            throw new RestTemplateException("Could not get ticket collection.");

        CoinList coinsDataMappers = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinCompareProperties.getApi().getDataJson().getCoins()).getFile());
        if (file.exists() && file.isFile())
            file.delete();
        file.createNewFile();
        objectMapper.writeValue(file, coinsDataMappers);
    }

    @Override
    public void getPrices() {
    }
}
