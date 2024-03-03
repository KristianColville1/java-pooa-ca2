package ca2;

import java.util.HashMap;
import java.util.List;

public class ConsoleMenu {

    // Static Fields
    private static final Company company = new Company("Business Gnómes Ltd.");
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
     */
    public static void start(List<Manager> allowedUsers) {
        addUsersCredentials(allowedUsers);
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
     * Returns a Runnable lambda expression for stopping the application by
     * setting appRunning to false.
     *
     * @return Runnable to stop the application
     */
    private static Runnable stopApplication() {
        return () -> appRunning = false;
    }
}
