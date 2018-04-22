package system.accounting.exception;

/**
 * Created by KAI on 4/21/18.
 */
public class WrapperErrorResponse {
    private String errorMessage;
    private String userMessage;

    public WrapperErrorResponse(String errorMessage, String userMessage) {
        this.errorMessage = errorMessage;
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
