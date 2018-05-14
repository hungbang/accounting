package system.accounting.domain.mongo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

/**
 * Created by KAI on 5/12/18.
 */
@Document(collection = "coins")
public class CoinCollection implements Serializable{

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(BigDecimal priceBuy) {
        this.priceBuy = priceBuy;
    }

    @Id
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("code_name")
    private String coinName;

    private BigDecimal amount;

    @JsonProperty("price_buy")
    private BigDecimal priceBuy;

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("amount = " + amount)
                .add("coinName = " + coinName)
                .add("id = " + id)
                .add("priceBuy = " + priceBuy)
                .add("userId = " + userId)
                .toString();
    }
}
