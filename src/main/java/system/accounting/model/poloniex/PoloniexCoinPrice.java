package system.accounting.model.poloniex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by KAI on 4/19/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoloniexCoinPrice {

    private Map<String, PoloniexCoinPriceDetail> poloniexCoinPriceDetailMap;


    public Map<String, PoloniexCoinPriceDetail> getPoloniexCoinPriceDetailMap() {
        return poloniexCoinPriceDetailMap;
    }

    public void setPoloniexCoinPriceDetailMap(Map<String, PoloniexCoinPriceDetail> poloniexCoinPriceDetailMap) {
        this.poloniexCoinPriceDetailMap = poloniexCoinPriceDetailMap;
    }
}
