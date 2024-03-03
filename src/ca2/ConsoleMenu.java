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
            int choice = getChoice(input);
            switch (choice) {
                case 1:
                    // list employees
                    listEmployees();
                    break;
                case 2:
                    // add employees
                    addEmployees();
                    break;
                case 3:
                    // remove employees
                    removeEmployees();
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
            appRunning = false;
        }
    }

    /**
     * Static method to handle listing the employees.
     *
     * Tries to get the users selection as integer and either lists the
     * employees by the empNum selected or returns to main menu.
     */
    private static void listEmployees() {
        try {
            System.out.println(
                    "Please select an employee number to start with:");
            int empNum = getChoice(InputUtils.getUserInput());
            System.out.println(
                    "\n\n-------------RESULTS-----------------");
            System.out.println(
                    "---Listed by employee number (asc)---\n\n");
            company.listEmployees(empNum);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid selection, please try again.");
            System.out.println("Returning to main menu...\n");
        }
    }

    /**
     * Static method allows user to enter an employee and continue adding them.
     *
     * Uses a while loop to decide if should keep adding.
     *
     */
    private static void addEmployees() {
        boolean adding = true;

        while (adding) {
            try {
                System.out.println(
                        "\nPlease enter the new employee name:");
                String name = InputUtils.getUserInput();
                System.out.println(
                        "\nPlease enter the employee email address:");
                String email = InputUtils.getUserInput();
                Employee emp = new Employee(name, email);
                company.addNewStaff(emp);
                System.out.println("Employee added successfully.");
            } catch (IllegalArgumentException e) {
                // do nothing, returns to main menu
            }

            // gives the option to continue adding employees
            System.out.println("\nDo you want to add another employee?");
            System.out.println("--------(1) Continue Adding Employees");
            System.out.println("--------Hit any other value to exit\n");
            int choice = getChoice(InputUtils.getUserInput());
            if (choice != 1) {
                adding = false; // exits loop for adding employees
            }
        }
    }

    /**
     * Static method removes employees.
     *
     * Uses a while loop to keep removing employees if the user decides to.
     */
    private static void removeEmployees() {
        boolean removing = true;

        while (removing) {
            try {
                System.out.println(
                        "\n\nPlease enter the employee number"
                        + " to remove that staff member:");
                int employeeToRemove = getChoice(InputUtils.getUserInput());
                company.removeStaff(employeeToRemove);
            } catch (Exception e) {
                System.out.println(
                        "Invalid input: "
                        + e.getMessage() + ". Please enter a valid employee number.");
            }

            System.out.println("\nDo you want to add remove employee?");
            System.out.println("--------(1) Continue removing Employees");
            System.out.println("--------Hit any other value to exit\n");
            int choice = getChoice(InputUtils.getUserInput());
            if (choice != 1) {
                removing = false;
            }
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
