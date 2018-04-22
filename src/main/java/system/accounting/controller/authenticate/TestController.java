package system.accounting.controller.authenticate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KAI on 4/22/18.
 */

@RestController
@RequestMapping("/protected")
public class TestController {


    @GetMapping("/test")
    public String getSomething(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("authentication.getPrincipal(): "+ authentication.getPrincipal());
        System.out.println("authentication.getName(): "+ authentication.getName());
        System.out.println("authentication.getCredentials(): "+ authentication.getCredentials());
        return "Welcome you to join our system!!!";
    }

}
