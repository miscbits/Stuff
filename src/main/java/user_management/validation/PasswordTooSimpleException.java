package user_management.validation;

public class PasswordTooSimpleException extends Exception{
    public PasswordTooSimpleException() {
        this("Password must be at least 8 characters and contain at least one capital, one lowercase, and one special symbol");
    }

    public PasswordTooSimpleException(String message) {
        super(message);
    }
}
