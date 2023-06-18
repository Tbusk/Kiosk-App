package KioskApp.Accounts;

import java.util.Scanner;

/**
 * This is a class that makes it easy to create and store credentials using the console.
 * It will ask for a username, followed by a password, and will give you an option of continuing to create more or exiting.
 * "Enter a username: " + entered_username
 * "Enter a password: " + entered_password
 * "Do you want to continue?"
 * Enter "Yes", "yes", "Yeah", or "yeah" to keep entering making and storing credentials.
 * Anything else will exit the program.
 */
public class AccountCreationDriver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AccountCreation accountCreation = new AccountCreation();
        String username, password, userAnswer;
        boolean exitEntry= false;
        while(!exitEntry) {
            System.out.println("Enter a username: ");
            username = scnr.next();

            System.out.println("Enter a password: ");
            password = scnr.next();

            accountCreation.createAccount(username, password);

            System.out.println("Do you want to continue?");
            userAnswer = scnr.next();
            switch(userAnswer) {
                case "Yes", "yes", "Yeah", "yeah" -> exitEntry = false;
                default -> exitEntry = true;

            }
        }

    }
}
