package system.accounting.controller.wss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import system.accounting.model.CoinsDataMapper;
import system.accounting.model.WrapperCoinResponseBody;
import system.accounting.properties.AccountantAppProperties;
import system.accounting.service.CoinService;

import java.util.List;

/**
 * Created by KAI on 4/21/18.
 */
@Controller
public class CoinWssController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CoinWssController.class);

    @Autowired
    @Qualifier("coinMarketCapService")
    private CoinService coinService;


    @Autowired
    private AccountantAppProperties accountantAppProperties;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String  greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new String("Hello, " + HtmlUtils.htmlEscape(message) + "!");
    }


    @MessageMapping("/pullPrice")
    @SendTo("/stock/price")
    public WrapperCoinResponseBody getAllCryptoCurrenies() throws Exception {
        Thread.sleep(1000); // simulated delay
        List<CoinsDataMapper> coinsDataMappers = coinService.getCoinsSupported();
        return new WrapperCoinResponseBody(coinsDataMappers);
    }




}
