package system.accounting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import system.accounting.exception.RestTemplateException;
import system.accounting.model.CoinsDataMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KAI on 4/14/18.
 */
@Service
public class SynCoinDataServiceImpl implements SynCoinDataService {

    @Value("${coinmarketcap.api.ticket}")
    private String ticketUrl;

    @Value("${coinmarketcap.api.dataPath.synNewest}")
    private String coinlistDataPath;

    @Value("${coinmarketcap.api.dataPath.original}")
    private String original;

    @Override
    public void synCoinsData() throws RestTemplateException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CoinsDataMapper[]> responseEntity = restTemplate.getForEntity(ticketUrl, CoinsDataMapper[].class);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK))
            throw new RestTemplateException("Could not get ticket collection.");

        List<CoinsDataMapper> coinsDataMappers = Arrays.asList(responseEntity.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(coinlistDataPath).getFile());
        objectMapper.writeValue(file, coinsDataMappers);
        //TODO: copy file syn data to original file
        File originalFile = new File(classLoader.getResource(original).getFile());
        com.google.common.io.Files.copy(file, originalFile);
    }
}
