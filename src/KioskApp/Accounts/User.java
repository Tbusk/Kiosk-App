package KioskApp.Accounts;

/**
 * Class that makes up a user.
 * Contains private username and password as String variables.
 * Public methods: getUsername(), returns the username.
 */
public class User {
    private String username;
    private String password;

    /**
     * Constructor that initializes User objects.
     * usernames are initialized as "Empty"
     * passwords are initialized as "Empty"
     */
    public User() {
        username = "Empty";
        password = "Empty";
    }

    /**
     * Method that retrieves username of User
     * @return username, as String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Method that retrieves password of User
     * @return password, as String
     */
    protected String getPassword() {
        return this.password;
    }

    /**
     * Method that sets username of User
     * @param username updates username with this, as String
     */
    protected void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method that sets password of User
     * @param password updates username with this, as String
     */
    protected void setPassword(String password) {
        this.password = password;
    }
}


