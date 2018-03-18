package user_management.validation;

public class EmailNotAvailableException extends Exception {
    public EmailNotAvailableException() {
        this("Email is already in use");
    }

    public EmailNotAvailableException(String message) {

        super(message);
    }
}
