package system.accounting.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by KAI on 4/22/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "coin")
public class Coin extends BaseEntity implements Serializable{

    @Id
    private String id;

    @JsonProperty("user_id")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "code_name")
    @JsonProperty("code_name")
    private String coinName;

    private BigDecimal amount;

    @Column(name = "price_buy")
    @JsonProperty("price_buy")
    private BigDecimal priceBuy;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
