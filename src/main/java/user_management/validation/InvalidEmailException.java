package user_management.validation;

public class InvalidEmailException extends Exception{
    public InvalidEmailException() {
        this("Email address is invalid");
    }

    public InvalidEmailException(String message) {
        super(message);
    }
}
