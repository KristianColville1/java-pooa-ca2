/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

/**
 *
 * @author kristian
 */
public class Employee {

    // instance fields
    private String name;
    private String email;
    private int empNum;

    // static fields
    private static int nextEmpNum = 1;

    /**
     * Default constructor for Employee class object.
     */
    public Employee() {
        this.name = "John Doe";
        this.email = "johndoe@gmail.com";
        this.empNum = this.nextEmpNum++;
    }

    /**
     * Overloaded constructor for Employee class object.
     *
     * @param name of the employee
     * @param email of the employee
     */
    public Employee(String name, String email) {
        this.name = name;
        this.empNum = this.nextEmpNum++;
        this.email = checkEmailAddress(email);
    }

    /**
     * ------------------------------------------------Getter Methods
     */
    /**
     * Getter method for returning the name of the Employee
     *
     * @return name of the employee
     */
    public String getEmployeeName() {
        return name;
    }

    /**
     * Getter method for returning the email of the Employee
     *
     * @return email address of the employee
     */
    public String getEmployeeEmail() {
        return email;
    }

    /**
     * Getter method for returning the employee number of the Employee
     *
     * @return
     */
    public int getEmployeeNumber() {
        return empNum;
    }

    /**
     * ------------------------------------------------Setter Methods
     */
    /**
     * Setter method for modifying the employee email
     *
     * @param email address of the new value for the employee
     * @throws IllegalArgumentException if the email is 3 characters or less
     */
    public void setEmail(String email) throws IllegalArgumentException {
        if (email.length() <= 3) {
            throw new IllegalArgumentException(
                    "Email address must contain more than 3 characters");
        }
        this.email = checkEmailAddress(email);
    }

    /**
     * ------------------------------------------------Static Methods
     */
    /**
     * Getter method for returning the current value of the nextEmpNum
     *
     * @return the current value of nextEmpNum
     */
    public static int getNextEmpNum() {
        return nextEmpNum;
    }

    /**
     * ------------------------------------------------Business Logic Methods
     */
    /**
     * Checks email addresses using regex pattern.
     *
     * If the email matches the regex it returns it otherwise throws exception.
     *
     * Regex taken from:
     * https://emaillistvalidation.com/blog/the-power-of-regular-expressions-in-email-validation-a-comprehensive-guide/
     *
     * @param email the email address to validate
     * @return email if valid
     */
    private String checkEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid = email.matches(emailRegex);
        if (!isValid) {
            throw new IllegalArgumentException("Email address is invalid");
        }
        return email;
    }
}
