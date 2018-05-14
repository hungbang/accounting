package system.accounting;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import system.accounting.domain.mongo.CoinCollection;
import system.accounting.model.CoinRequestBody;
import system.accounting.repository.CoinCollectionMongoRepository;
import system.accounting.service.CoinService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class AccountingSystemApplication extends SpringBootServletInitializer implements CommandLineRunner {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AccountingSystemApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountingSystemApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }


    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Autowired
    private CoinCollectionMongoRepository coinCollectionMongoRepository;

    @Bean
    public DozerBeanMapper dozerBeanMapper(){
        return new DozerBeanMapper();
    }

    @Autowired
    @Qualifier("coinCollectionServiceImpl")
    private CoinService coinService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("We could init st at here when start project.");
    }

    private CoinRequestBody prepareCoinRequest() {
        CoinRequestBody coinRequestBody = new CoinRequestBody();
        List<CoinRequestBody.CoinData> coinDatas = new ArrayList<>();
        for(int i =0 ; i< 3; i++){
            CoinRequestBody.CoinData coinData = new CoinRequestBody.CoinData();
            coinData.setAmount("1234"+i);
            coinData.setCoinName("ripple"+i);
            coinData.setPriceBuy("456"+i);
            coinDatas.add(coinData);
        }
        coinRequestBody.setCoinDatas(coinDatas);
        return coinRequestBody;
    }

    private CoinCollection prepareCoinCollection() {
        CoinCollection coinCollection = new CoinCollection();
        coinCollection.setAmount(new BigDecimal(233));
        coinCollection.setCoinName("ripple");
        coinCollection.setPriceBuy(BigDecimal.TEN);
        coinCollection.setUserId(UUID.randomUUID().toString());
        return coinCollection;
    }
}
