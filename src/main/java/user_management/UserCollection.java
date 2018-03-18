package user_management;

import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.Iterator;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {
        Iterator<User> iterator = this.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getId() == id) {
                return u;
            }
        }
        return null;

    }

    public User findByEmail(String email) {
        Iterator<User> iterator = this.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        User user = findByEmail(email);

        if (user != null && user.getPassword().matches(password)) {
            return user;
        }

        throw new UserAuthenticationFailedException();
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {
        if (findByEmail(email) != null) {
            throw new EmailNotAvailableException();
        }

        if ( ! email.matches("\\w+?@\\w+?\\.[a-z.]{2,6}")) {
            throw new InvalidEmailException();
        }

        if (password.length() < 8 || ! password.matches(".*[A-Z].*") || ! password.matches(".*[a-z].*") || ! password.matches(".*[0-9].*") || ! password.matches(".*[!@#$%^&*()<>?].*")) {
            throw new PasswordTooSimpleException();
        }

        User user = new User(getNextId(), name, email, password);

        this.add(user);

        return user.getId();
    }

    private int getNextId() {
        User u;
        int id = 0;
        do {
            id++;
            u = findById(id);
        } while (u != null);
        return id;
    }
}
