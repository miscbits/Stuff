package user_management;

import user_management.security.Password;

public class User {
    private int id;
    private String name;
    private String email;
    private Password password;

    public User(int id, String name, String email, String password) {
        this(id, name, email, new Password(password));
    }

    public User(int id, String name, String email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(String password) {
        setPassword(new Password(password));
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!User.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final User other = (User) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }

        return true;
    }
}
