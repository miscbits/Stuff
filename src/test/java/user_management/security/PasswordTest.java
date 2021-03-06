package user_management.security;

import org.junit.Test;
import user_management.security.Password;

import static org.junit.Assert.*;

public class PasswordTest {

    @Test
    public void hashPassword() {
        Password p = new Password("password");
        String hash = p.getHash();

        assertTrue(hash.startsWith("$2a$"));
    }

    @Test
    public void matches() {
        Password p = new Password("password");

        assertTrue(p.matches("password"));
    }
}