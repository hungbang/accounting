package system.accounting.model;

/**
 * Created by KAI on 4/14/18.
 */
public class ErrorResponseWrapper {

    private String userMassage;

    public String getUserMassage() {
        return userMassage;
    }

    public void setUserMassage(String userMassage) {
        this.userMassage = userMassage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public ErrorResponseWrapper(String userMassage, String errorMessage) {
        this.errorMessage = errorMessage;
        this.userMassage = userMassage;
    }
}
