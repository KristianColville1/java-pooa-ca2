package ca2;

import java.util.HashMap;
import java.util.List;

public class ConsoleMenu {

    // Static Fields
    private static Company company;
    private static boolean appRunning = true;
    private static HashMap<String, String> credentials = new HashMap<>();

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
     * @return
     */
    private static boolean isLoggedIn() {
        DisplayText.enterUsername();
        String username = InputUtils.getUserInput();
        DisplayText.enterPassword();
        String password = InputUtils.getUserInput();
        stopApplication();
        return false;
    }

    /**
     * Responsible for the application logic flow.
     */
    private static void runApplication() {
        DisplayText.getWelcomeMenu();
        boolean loggedIn = isLoggedIn();
    }

    /**
     * -----------------------------------------------Concurrency Methods
     */
    /**
     * For stopping the application by
     * setting appRunning to false.
     *
     * @return Runnable to stop the application
     */
    private static void stopApplication() {
        appRunning = false;
    }
}
