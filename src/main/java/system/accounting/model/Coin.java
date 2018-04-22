package system.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by KAI on 4/22/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin implements Serializable{

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("code_name")
    private String coinName;

    private String amount;

    @JsonProperty("price_buy")
    private String priceBuy;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public String getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(String priceBuy) {
        this.priceBuy = priceBuy;
    }
}
