package system.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
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
        
        private String id;
        private BigDecimal amount;
        private String coinName;
        private BigDecimal priceBuy;

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getCoinName() {
            return coinName;
        }

        public void setCoinName(String coinName) {
            this.coinName = coinName;
        }

        public BigDecimal getPriceBuy() {
            return priceBuy;
        }

        public void setPriceBuy(BigDecimal priceBuy) {
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
