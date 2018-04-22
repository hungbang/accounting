package system.accounting.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import system.accounting.exception.RestTemplateException;
import system.accounting.service.PullDataService;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by KAI on 4/14/18.
 */
@Component
public class PullDataFromCCPJob {

    public final static Logger LOGGER = LoggerFactory.getLogger(PullDataFromCCPJob.class);

    @Autowired
    @Qualifier("synCoinDataServiceImpl")
    private PullDataService synCoinDataService;

    @Autowired
    @Qualifier("poloniexPriceService")
    private PullDataService poloniexPriceService;

    @Scheduled(cron = "0/20 * * ? * *")
    public void process(){
        long startTime = Calendar.getInstance().getTimeInMillis();

        LOGGER.info("BEGIN scheduling to syn data from coin compare : "+ new Date(startTime));

        try {
            synCoinDataService.synDataFromCCP();
//            LOGGER.info("BEGIN GET COIN PRICE : "+ new Date(startTime));
//            poloniexPriceService.getPrices();
//            LOGGER.info("GET COIN PRICE SUCCESS: "+ new Date(startTime));
        } catch (RestTemplateException e) {
            LOGGER.error("Error occurs when call to coin compare cap." + e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error("Got data from coin compare successful but ...");
            LOGGER.error("Error occurs when write json to file." + e.getMessage(), e);
        }
//        catch (CoinPriceNotFoundException e) {
//            LOGGER.error("CoinPriceNotFoundException...." + e.getMessage(), e);
//        }

        long endTime = Calendar.getInstance().getTimeInMillis();
        LOGGER.info("Scheduling to syn data from coin compare SUCCESSFUL : "+ new Date(endTime));
    }

}
