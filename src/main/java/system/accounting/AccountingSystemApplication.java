package system.accounting;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class AccountingSystemApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AccountingSystemApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountingSystemApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }


    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
