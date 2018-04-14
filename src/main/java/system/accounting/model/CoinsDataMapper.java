package system.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Created by KAI on 4/14/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinsDataMapper implements Serializable{

    private String id;
    private String name;
    private String symbol;
    private String rank;
    @JsonProperty("price_usd")
    private String priceUsd;

    @JsonProperty("24h_volume_usd")
    private String dailyVolumeUsd;

    @JsonProperty("market_cap_usd")
    private String marketCapUsd;

    @JsonProperty("available_supply")
    private String availableSupply;

    @JsonProperty("total_supply")
    private String totalSupply;

    @JsonProperty("max_supply")
    private String maxSupply;

    @JsonProperty("percent_change_1h")
    private String percentChangeOneHour;

    @JsonProperty("percent_change_7d")
    private String percentChangeSevenDays;
    @JsonProperty("last_updated")
    private Date lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getDailyVolumeUsd() {
        return dailyVolumeUsd;
    }

    public void setDailyVolumeUsd(String dailyVolumeUsd) {
        this.dailyVolumeUsd = dailyVolumeUsd;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public String getPercentChangeOneHour() {
        return percentChangeOneHour;
    }

    public void setPercentChangeOneHour(String percentChangeOneHour) {
        this.percentChangeOneHour = percentChangeOneHour;
    }

    public String getPercentChangeSevenDays() {
        return percentChangeSevenDays;
    }

    public void setPercentChangeSevenDays(String percentChangeSevenDays) {
        this.percentChangeSevenDays = percentChangeSevenDays;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("availableSupply = " + availableSupply)
                .add("dailyVolumeUsd = " + dailyVolumeUsd)
                .add("id = " + id)
                .add("lastUpdated = " + lastUpdated)
                .add("marketCapUsd = " + marketCapUsd)
                .add("maxSupply = " + maxSupply)
                .add("name = " + name)
                .add("percentChangeOneHour = " + percentChangeOneHour)
                .add("percentChangeSevenDays = " + percentChangeSevenDays)
                .add("priceUsd = " + priceUsd)
                .add("rank = " + rank)
                .add("symbol = " + symbol)
                .add("totalSupply = " + totalSupply)
                .toString();
    }
}
