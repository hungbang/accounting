package system.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.dozer.Mapping;

import java.util.List;

/**
 * Created by KAI on 4/22/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinRequestBody {

    public List<CoinData> getCoinDatas() {
        return coinDatas;
    }

    public void setCoinDatas(List<CoinData> coinDatas) {
        this.coinDatas = coinDatas;
    }

    private List<CoinData> coinDatas;

    public static class CoinData {

        @Mapping("id")
        private String id;


        @Mapping("amount")
        private String amount;


        @Mapping("coinName")
        private String coinName;


        @Mapping("priceBuy")
        private String priceBuy;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCoinName() {
            return coinName;
        }

        public void setCoinName(String coinName) {
            this.coinName = coinName;
        }

        public String getPriceBuy() {
            return priceBuy;
        }

        public void setPriceBuy(String priceBuy) {
            this.priceBuy = priceBuy;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
