package system.accounting.controller.wss.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.model.CoinsDataMapper;
import system.accounting.properties.AccountantAppProperties;
import system.accounting.service.CoinService;

import java.io.IOException;
import java.util.List;

/**
 * Created by KAI on 5/5/18.
 */
@Component
public class QuoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteService.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    @Qualifier("coinMarketCapService")
    private CoinService coinService;

    @Autowired
    private AccountantAppProperties accountantAppProperties;

    @Scheduled(fixedRate = 2000)
    public void sendQuotes() {
        LOGGER.debug("Fixed rate task - " + System.currentTimeMillis() / 1000);
        try {
            List<CoinsDataMapper> coinsDataMappers = coinService.getCoinsSupported();
            simpMessagingTemplate.convertAndSend(accountantAppProperties.getAccountant().getWss().getSendTo(),coinsDataMappers);
        } catch (IOException e) {
            LOGGER.error("Error occurs when parse json data from cache. ", e);
        } catch (CoinsDataNotFoundException e) {
            LOGGER.error("Coins data not found ", e);
        }
    }

}
