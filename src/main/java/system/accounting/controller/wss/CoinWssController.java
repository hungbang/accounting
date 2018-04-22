package system.accounting.controller.wss;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by KAI on 4/21/18.
 */
@Controller
public class CoinWssController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String  greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new String("Hello, " + HtmlUtils.htmlEscape(message) + "!");
    }

}
