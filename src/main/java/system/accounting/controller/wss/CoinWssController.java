package system.accounting.controller.wss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by KAI on 4/21/18.
 */
@Controller
public class CoinWssController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CoinWssController.class);




    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String  greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new String("Hello, " + HtmlUtils.htmlEscape(message) + "!");
    }


    @MessageMapping("/getCryptoCurrencies")
    @SendTo("/topic/cryptoCurrencies")
    public String  getAllCryptoCurrenies(String userId) throws Exception {
        Thread.sleep(1000); // simulated delay
        LOGGER.info("===Get coin information of user id : "+ userId);



        return new String("Hello, " + HtmlUtils.htmlEscape(userId) + "!");
    }




}
