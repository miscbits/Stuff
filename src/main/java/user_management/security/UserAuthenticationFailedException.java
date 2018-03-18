package user_management.security;

public class UserAuthenticationFailedException extends Exception{
    public UserAuthenticationFailedException() {
        this("Username or Password is inccorect");
    }

    public UserAuthenticationFailedException(String message) {
        super(message);
    }
}
