package system.accounting.exception;

/**
 * Created by KAI on 4/22/18.
 */
public class CoinNotFoundException extends Exception {

    public CoinNotFoundException() {
        super();
    }

    public CoinNotFoundException(String message) {
        super(message);
    }

    public CoinNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CoinNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
