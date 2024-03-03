package ca2;

import java.util.HashMap;
import java.util.List;

public class ConsoleMenu {

    // Static Fields
    private static Company company;
    private static boolean appRunning = true;
    private static HashMap<String, String> credentials = new HashMap<>();
    private static String user;

    /**
     * -----------------------------------------------Initialization Methods
     */
    /**
     * Static method start is the entry point using the console menu system.
     * Responsible for calling console menu application initialization logic.
     * Turns the application on and wraps the application loop in a try catch.
     *
     * @param allowedUsers list of users allowed to use console menu
     * @param company is the company object to use in the console
     */
    public static void start(List<Manager> allowedUsers, Company companyToUse) {
        addUsersCredentials(allowedUsers);
        company = companyToUse;
        try {
            while (appRunning) {
                runApplication();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Responsible for the application logic flow.
     */
    private static void runApplication() {
        DisplayText.getWelcomeMenu();
        authenticateUser(); // handles authentication flow
        boolean usingApp = true;
        while (usingApp) {
            DisplayText.showLoggedInUserMenuOptions();
            String input = InputUtils.getUserInput();
            int choice = 0;
            switch (choice) {
                case 1:
                    // list users
                    break;
                case 2:
                    // add new employee
                    break;
                case 3:
                    // remove an employee
                    break;
                case 4:
                    // logout and exit
                    usingApp = false;
                    break;
                default:
                    // not a valid option
                    break;
            }
        }
        stopApplication();

    }

    /**
     * Converts the users string input to an integer.
     *
     * @param input given by the user
     * @return the selection made by the user
     */
    private static int getChoice(String input) {
        int selection = 0;
        try {
            selection = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(
                    "Thats not a valid option, please try again");
        }
        return selection;
    }

    /**
     * Adds the list of users credentials to the credentials hash map.
     *
     * @param users list of users with access
     */
    private static void addUsersCredentials(List<Manager> users) {
        for (Manager emp : users) {
            credentials.put(emp.getUsername(), emp.getPassword());
        }
    }

    /**
     * -----------------------------------------------Utility Methods
     */
    /**
     * Displays login information to user for entering details and validates
     * them.
     *
     * @return true or false if user logged in
     */
    private static boolean isLoggedIn() {
        // get user credentials
        DisplayText.enterUsername();
        String username = InputUtils.getUserInput();
        DisplayText.enterPassword();
        String password = InputUtils.getUserInput();

        // check they can log in
        boolean loggedIn = InputUtils.validateCredentials(
                username, password, credentials);
        if (loggedIn) {
            user = username; // this is the user logged in
            return true;
        }
        return false;
    }

    /**
     * Static utility method authenticates the user. Outputs login success to
     * the user. If the login fails it will close the application.
     */
    private static void authenticateUser() {
        if (isLoggedIn()) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Login Fail");
            System.out.println("Closing application...");
            stopApplication();
        }
    }

    /**
     * -----------------------------------------------Concurrency Methods
     */
    /**
     * For stopping the application by setting appRunning to false.
     */
    private static void stopApplication() {
        appRunning = false;
    }
}
