package system.accounting.exception;

/**
 * Created by KAI on 4/14/18.
 */
public class CoinsDataNotFoundException extends Exception{
    public CoinsDataNotFoundException() {
        super();
    }

    public CoinsDataNotFoundException(String message) {
        super(message);
    }

    public CoinsDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinsDataNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CoinsDataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
