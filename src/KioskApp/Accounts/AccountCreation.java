package KioskApp.Accounts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/**
 * Provides methods for creating accounts and storing the created credentials in a file.
 * The stored credentials are username and password, stored in csv file format.
 * The file in which the credentials are stored in is UserCredentials.csv
 */
public class AccountCreation extends User{

    /**
     * Method that allows a user to create accounts with a provided username and password.
     * @param username username, in String
     * @param password password, in String
     */
    public void createAccount(String username, String password) {
        setUsername(username);
        setPassword(password);

        try {
            storeCredentials();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    /**
     * Method that stores credentials in UserCredentials.csv.
     * Credentials are appended to the current file.
     * Username,Password, followed by a new line is what is written to the file.
     * @throws FileNotFoundException This exception is thrown when the file is not located in its original location (the src folder).
     */
    protected void storeCredentials() throws FileNotFoundException {
        FileOutputStream fileStream = new FileOutputStream("src\\UserCredentials.csv", true);
        PrintWriter outputFS = new PrintWriter(fileStream);
        outputFS.append(getUsername());
        outputFS.append(",");
        outputFS.append(getPassword());
        outputFS.append(",");
        outputFS.append("\n");

        outputFS.close();
    }

}
