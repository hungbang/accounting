package system.accounting.model;

import java.util.List;

/**
 * Created by KAI on 4/22/18.
 */
public class WrapperCoinResponseBody {
    public List<CoinsDataMapper> getCoinsDataMappers() {
        return coinsDataMappers;
    }

    public void setCoinsDataMappers(List<CoinsDataMapper> coinsDataMappers) {
        this.coinsDataMappers = coinsDataMappers;
    }

    List<CoinsDataMapper> coinsDataMappers;

    public WrapperCoinResponseBody(List<CoinsDataMapper> coinsDataMappers) {
        this.coinsDataMappers = coinsDataMappers;
    }
}
