package system.accounting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by KAI on 5/5/18.
 */
@ConfigurationProperties
@PropertySource("classpath:accountant.properties")
@Component
public class AccountantAppProperties {
    private AccountantAppProperties.Accountant accountant = new AccountantAppProperties.Accountant();

    public AccountantAppProperties.Accountant getAccountant() {
        return this.accountant;
    }

    public static class Accountant {
        private AccountantAppProperties.Accountant.Wss wss = new AccountantAppProperties.Accountant.Wss();

        public AccountantAppProperties.Accountant.Wss getWss() {
            return this.wss;
        }

        ;

        public static class Wss {
            public String getSendTo() {
                return sendTo;
            }

            public void setSendTo(String sendTo) {
                this.sendTo = sendTo;
            }

            private String sendTo;
        }
    }
}
