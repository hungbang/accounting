package system.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by KAI on 4/18/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDetail {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("Url")
    private String url;

    @JsonProperty("ImageUrl")
    private String imageUrl;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("CoinName")
    private String coinName;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("Algorithm")
    private String algorithm;

    @JsonProperty("ProofType")
    private String proofType;

    @JsonProperty("SortOrder")
    private String sortOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }



}
