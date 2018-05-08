package system.accounting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by KAI on 4/22/18.
 */
@ConfigurationProperties(prefix = "coinmarketcap")
@PropertySource("classpath:accountant.properties")
@Configuration
public class CoinMarketCapProperties {

    public CoinMarketCapProperties() {
    }

    private final CoinMarketCapProperties.Api api = new CoinMarketCapProperties.Api();

    public CoinMarketCapProperties.Api getApi() {
        return this.api;
    }

    public static class Api {

        public Api() {
        }

        private String ticket;
        private final CoinMarketCapProperties.DataJson dataJson = new CoinMarketCapProperties.DataJson();

        public CoinMarketCapProperties.DataJson getDataJson(){
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
