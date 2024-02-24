/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kristian
 */
public class ConsoleMenu {

    // static fields
    private static final Company company = new Company("Business Gnómes Ltd.");
    private static boolean appRunning = true;
    private static HashMap<String, String> credentials;

    /**
     * Static method start is the entry point using the console menu system.
     *
     * Responsible for calling console menu application initialization logic.
     *
     * Turns the application on and wraps the application loop in a try catch.
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
     * Static method addUsersCredentials adds the list of users credentials to
     * the credentials hash map.
     *
     * @param users with credentials to check for using console menu.
     */
    private static void addUsersCredentials(List<Manager> users) {
        for (Manager emp : users) {
            credentials.put(emp.getUsername(), emp.getPassword());
        }
    }

    /**
     * Static method runApplication
     *
     * Responsible for application logic flow.
     */
    private static void runApplication() {
        getWelcomeMenu();
        boolean loggedIn = isLoggedIn();
    }

    /**
     * Static getter method for outputting welcome menu
     */
    private static void getWelcomeMenu() {
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        System.out.println("        Employee Management System");
        System.out.println("-------------------------------------------");
    }
    
        
    /**
     * Static Runnable method for stopping the application
     * @return Runnable to switch off app
     */
    private static Runnable stopApplication(){
        return () -> appRunning = false;
    }
}
