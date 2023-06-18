package KioskApp.Accounts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest extends User{

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting tests ...");
    }

    @DisplayName("Testing setUsername() and getUsername() with conditions")
    @Test
    void testUsername() {

        setUsername("Username1");
        assertEquals("Username1", getUsername(), "Error in setting and getting username!");

        setUsername("username");
        assertEquals("username", getUsername(), "Error in setting and getting username!");

        setUsername("USERNAME");
        assertEquals("USERNAME", getUsername(), "Error in setting and getting username!");

        setUsername("#@#$@#%@");
        assertEquals("#@#$@#%@", getUsername(), "Error in setting and getting username!");

        setUsername("0");
        assertEquals("0", getUsername(), "Error in setting and getting username!");

        setUsername("---------");
        assertEquals("---------", getUsername(), "Error in setting and getting username!");

        setUsername("-1");
        assertEquals("-1", getUsername(), "Error in setting and getting username!");

    }
    @Test
    @DisplayName("Testing setPassword() and getPassword() with conditions")
    void testPassword() {
        setPassword("Password1");
        assertEquals("Password1", getPassword(), "Error in setting and getting password!");

        setPassword("password");
        assertEquals("password", getPassword(), "Error in setting and getting password!");

        setPassword("PASSWORD");
        assertEquals("PASSWORD", getPassword(), "Error in setting and getting password!");

        setPassword("#@#$@#%@");
        assertEquals("#@#$@#%@", getPassword(), "Error in setting and getting password!");

        setPassword("0");
        assertEquals("0", getPassword(), "Error in setting and getting password!");

        setPassword("---------");
        assertEquals("---------", getPassword(), "Error in setting and getting password!");

        setPassword("-1");
        assertEquals("-1", getPassword(), "Error in setting and getting password!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests finished up on User class ...");
    }
}
