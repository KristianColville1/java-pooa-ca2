/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

/**
 *
 * @author kristian
 */
public class Manager extends Employee {

    // instance fields
    private String username;
    private String password;

    /**
     * Default Constructor for Manager.
     *
     * Calls the superclass default constructor and initializes the username and
     * password instance fields.
     */
    public Manager() {
        super();
        this.username = "defaultusername";
        this.password = "password";
    }

    /**
     * Overloaded Constructor for Manager.
     *
     * Calls the superclass overloaded constructor for the name and email
     * address. Also initializes subclass instance fields username and password.
     */
    public Manager(String name, String email, String username, String password) {
        super(name, email);
        this.username = username;
        this.password = password;
    }

    /**
     * ------------------------------------------------Getter Methods
     */
    /**
     * Getter method for retrieving manager username
     *
     * @return the username of the manager
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method for retrieving the manager password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * ------------------------------------------------Setter Methods
     */
    /**
     * Setter method for modifying the username of the manager
     *
     * @param username to be used as the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter method for modifying the password of the manager
     *
     * @param password to be used as the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
