package KioskApp.Accounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class checks credentials stored in UserCredentials.csv.
 * checkCreds method checks credentials as a whole in the file, line by line.
 * usernameChecker method checks the username in a line.
 * passwordChecker method checks the password in a line.
 * lineCounter method counts the number of lines in a file.
 */
public class CredentialChecker {

    /**
     * Text gathered from a file line in UserCredentials.csv.
     * Contains username,password,
     */
    private String lineTxt;

    /**
     * Text gathered from a file line in UserCredentials.csv.
     * Contains username
     */
    private String usernameTxt = "";

    /**
     * Text gathered from a file line in UserCredentials.csv.
     * Contains password
     */
    private String passwordTxt = "";

    /**
     * File input stream utilizing UserCredentials.csv.
     */
    private FileInputStream inputStream = new FileInputStream("src\\UserCredentials.csv");

    /**
     * Scanner utilizing file input stream from inputStream from UserCredentials.csv.
     */
    private Scanner inputStreamScanner = new Scanner(inputStream);

    public CredentialChecker() throws FileNotFoundException {
    }

    /**
     * Method that authenticates a user by reading line by line in the file with the stored usernames and passwords.
     * @param username username, as String
     * @param password password, as String
     * @return returns true if credentials are authenticated. Returns false if username and password combo are not correct.
     * @throws IOException gets thrown if there is something wrong with reading the file
     */
    public Boolean checkCreds(String username, String password) throws IOException {
        inputStreamScanner.nextLine();
        lineTxt = inputStreamScanner.nextLine();
        Boolean authenticated;

        for(int i = 1; i < lineCounter(); i++) {

            if(usernameChecker(lineTxt, username)) {
                authenticated = passwordChecker(lineTxt, password);
                if (authenticated) {
                    return true;
                } else {
                    usernameTxt = "";
                    passwordTxt = "";
                }
            } else {
                usernameTxt = "";
                passwordTxt = "";
            }

            if(inputStreamScanner.hasNext()) {
                lineTxt = inputStreamScanner.nextLine();
            } else {
                System.out.println("Username & password combo not found on file.");
            }
        }
        return false;
    }

    /**
     * Reads username from file on a specified line.
     * @param line the line in which is being read
     * @param username the username in which is being read
     * @return true if username is found, false if not.
     */
    public Boolean usernameChecker(String line, String username) {
        for (int i = 0; i < line.length(); ++i) {
            if (lineTxt.charAt(i) != ',') {
                usernameTxt += lineTxt.charAt(i);
            } else {
                break;
            }
        }

        if (usernameTxt.equals(username)) {
            System.out.println("Username is valid!");
            return true;
        }
        return false;
    }

    /**
     * Reads password from file on a specified line.
     * @param line the line in which is being read
     * @param password the password in which is being read
     * @return true if password is found, false if not.
     */
    public Boolean passwordChecker(String line, String password) {
        for (int i = usernameTxt.length() + 1; i < line.length(); ++i) {
            if (lineTxt.charAt(i) != ',') {
                passwordTxt += lineTxt.charAt(i);
            } else {
                break;
            }
        }

        if (passwordTxt.equals(password)) {
            System.out.println("Password validated!");
            return true;
        }
        return false;

    }

    /**
     * Counts the number of lines on the file, UserCredentials.csv
     * @return number of lines in the file, in Long format
     */
    public Long lineCounter(){
        long lines = 0L;
        try {
            Path path = Paths.get("src/UserCredentials.csv");
            lines = Files.lines(path).count();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
}