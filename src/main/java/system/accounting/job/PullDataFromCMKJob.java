package system.accounting.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import system.accounting.exception.CoinsDataNotFoundException;
import system.accounting.exception.RestTemplateException;
import system.accounting.service.PullDataService;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by KAI on 4/14/18.
 */
@Component
public class PullDataFromCMKJob {

    public final static Logger LOGGER = LoggerFactory.getLogger(PullDataFromCMKJob.class);

    @Autowired
    @Qualifier("synCoinDataServiceImpl")
    private PullDataService synCoinDataService;

    @Scheduled(cron = "0/30 * * ? * *")
    public void process(){
        long startTime = Calendar.getInstance().getTimeInMillis();

        LOGGER.info("BEGIN scheduling to syn data from coin market : "+ new Date(startTime));

        try {
            synCoinDataService.synDataFromCMK();
        } catch (RestTemplateException e) {
            LOGGER.error("Error occurs when call to coin market cap." + e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error("Got data from coin market successful but ...");
            LOGGER.error("Error occurs when write json to file." + e.getMessage(), e);
        } catch (CoinsDataNotFoundException e) {
            LOGGER.error("Error occurs when call to cryptocompare cap." + e.getMessage(), e);
        }

        long endTime = Calendar.getInstance().getTimeInMillis();
        LOGGER.info("Scheduling to syn data from coin market SUCCESSFUL : "+ new Date(endTime));
    }

}
