package system.accounting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by KAI on 4/22/18.
 */
@ConfigurationProperties(prefix = "coincompare", ignoreInvalidFields = false)
@PropertySource("classpath:accountant.properties")
@Component
public class CoinCompareProperties {

    public CoinCompareProperties() {
    }

    private final CoinCompareProperties.Api api = new CoinCompareProperties.Api();

    public CoinCompareProperties.Api getApi() {
        return this.api;
    }

    public static class Api {

        public Api() {
        }

        private String ticket;
        private final CoinCompareProperties.DataJson dataJson = new CoinCompareProperties.DataJson();

        public CoinCompareProperties.DataJson getDataJson(){
            return this.dataJson;
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }
    }

    public static class DataJson {
        private String coins;

        public String getCoins() {
            return coins;
        }

        public void setCoins(String coins) {
            this.coins = coins;
        }
    }
}
