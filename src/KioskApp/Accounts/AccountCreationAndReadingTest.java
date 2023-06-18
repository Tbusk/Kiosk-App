package KioskApp.Accounts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountCreationAndReadingTest extends AccountCreation{

    public AccountCreationAndReadingTest() {
    }

    @DisplayName("Testing createAccount() with checkCreds() from CredentialChecker")
    @Test
    void testCreateAndReadAccount() {

        /* Tested creating accounts with the following:
        createAccount("BillyJones", "abcdefg");
        createAccount("JillSmith", "-1");
        createAccount("jamesmoore", "__________");
        */

        try { // Tested reading credentials
            CredentialChecker credentialChecker = new CredentialChecker();
            assertTrue(credentialChecker.checkCreds("BillyJones", "abcdefg"), "Not found!");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }

        try { // Tested reading credentials
            CredentialChecker credentialChecker = new CredentialChecker();
            assertTrue(credentialChecker.checkCreds("JillSmith", "-1"), "Not found!");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }

        try { // Tested reading credentials
            CredentialChecker credentialChecker = new CredentialChecker();
            assertTrue(credentialChecker.checkCreds("jamesmoore", "__________"), "Not found!");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
