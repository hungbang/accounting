package system.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by KAI on 4/18/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinList {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("BaseImageUrl")
    private String baseImageUrl;

    @JsonProperty("BaseLinkUrl")
    private String baseLinkUrl;

    @JsonProperty("Data")
    private Map<String, DataDetail> detailMap;

    public Map<String, DataDetail> getDetailMap() {
        return detailMap;
    }

    public void setDetailMap(Map<String, DataDetail> detailMap) {
        this.detailMap = detailMap;
    }



    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBaseImageUrl() {
        return baseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl) {
        this.baseImageUrl = baseImageUrl;
    }

    public String getBaseLinkUrl() {
        return baseLinkUrl;
    }

    public void setBaseLinkUrl(String baseLinkUrl) {
        this.baseLinkUrl = baseLinkUrl;
    }

}
