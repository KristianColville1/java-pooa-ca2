/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

/**
 * Utility class DisplayText.
 *
 * Displays text to the terminal in a static context.
 *
 * @author kristian
 */
public class DisplayText {

    /**
     * Outputs the welcome menu to the terminal
     */
    public static void getWelcomeMenu() {
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        System.out.println("        Employee Management System");
        System.out.println("-------------------------------------------");
        System.out.println("         Please login to continue\n");
    }

    /**
     * Outputs enter your username
     */
    public static void enterUsername() {
        System.out.println("\nPlease Enter Username (+ hit Enter):");
    }

    /**
     * Outputs enter your password
     */
    public static void enterPassword() {
        System.out.println("\nPlease Enter Password (+ hit Enter):");
    }

    /**
     * Outputs options to user after successful login
     */
    public static void showLoggedInUserMenuOptions() {
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        System.out.println("---Please Select an Option below:----------\n");
        System.out.println("        (1) List Employees");
        System.out.println("        (2) Add a New Employee");
        System.out.println("        (3) Logout and exit");
        System.out.println("-------------------------------------------\n");
    }
}
