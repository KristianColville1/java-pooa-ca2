/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

/**
 *
 * @author kristian
 */
public class ConsoleMenu {

    // static fields
    static Boolean appRunning = false;

    /**
     * Static method start is the entry point using the console menu system.
     *
     * Responsible for calling console menu application initialization logic.
     * 
     * Turns the application on and wraps the application loop in a try catch.
     */
    public static void start() {
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
     * Static method runApplication
     * 
     * Responsible for application logic flow.
     */
    public static void runApplication(){
        appRunning = false;
    }
}
