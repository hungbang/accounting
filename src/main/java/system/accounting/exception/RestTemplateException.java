package system.accounting.exception;

/**
 * Created by KAI on 4/14/18.
 */
public class RestTemplateException extends Exception {
    public RestTemplateException(String s) {
        super(s);
    }

    public RestTemplateException() {
        super();
    }

    public RestTemplateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestTemplateException(Throwable cause) {
        super(cause);
    }

    protected RestTemplateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
