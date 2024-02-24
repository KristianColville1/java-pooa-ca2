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
    private static Boolean appRunning;
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
        appRunning = true; // set the app as on
        try {
            while (appRunning) {
                runApplication();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    /**
     * Static method addUsersCredentials adds the list of users credentials
     * to the credentials hash map.
     * 
     * @param users with credentials to check for using console menu.
     */
    private static void addUsersCredentials(List<Manager> users){
        for(Manager emp : users){
            credentials.put(emp.getUsername(), emp.getPassword());
        }
    }
    
    /**
     * Static method runApplication
     * 
     * Responsible for application logic flow.
     */
    private static void runApplication(){
        appRunning = false;
    }
}
