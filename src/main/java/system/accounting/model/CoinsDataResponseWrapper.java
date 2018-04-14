package system.accounting.model;

import java.math.BigDecimal;

/**
 * Created by KAI on 4/14/18.
 */
public class CoinsDataResponseWrapper {
    private CoinsDataMapper coinsDataMapper;
    private BigDecimal totalUsd;

    public void setCoinsDataMapper(CoinsDataMapper coinsDataMapper) {
        this.coinsDataMapper = coinsDataMapper;
    }

    public CoinsDataMapper getCoinsDataMapper() {
        return coinsDataMapper;
    }


    public BigDecimal getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(BigDecimal totalUsd) {
        this.totalUsd = totalUsd;
    }
}
