/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.Objects;

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
     * If the email address is 3 characters or less in length it fails. Sends
     * the email address to be checked by calling checkEmailAddress(email)
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
     * @throws IllegalArgumentException if the email address fails the regex
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

    /**
     * ------------------------------------------------Object Contract Methods
     */
    /**
     * Object Contract method overrides the equals method to compare employee
     * objects based on the employee number 'empNum'. Must be overridden with
     * hashCode() method below.
     *
     * Implements default behaviour and check if the same instance, if so then
     * true. Then we check for null and type behaviour in the second condition
     * which is false. Finally we check the state of the object which is the
     * employee number.
     *
     * If the employee objects being compared share the same employee number
     * they are the same object.
     *
     * We ensure that if our employee is part of a hash based collection that no
     * duplicates will be added.
     *
     * @param obj to compare instance with
     * @return true if the object is an Employee with the same employee number
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // same instance
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // null & type
        }
        Employee employee = (Employee) obj; // cast and compare
        return empNum == employee.empNum; // the sate to check -> 'empNum'
    }

    /**
     * Object Contract method overrides the hashCode method to generate a hash
     * code based on the employee number 'empNum'.
     *
     * This method is crucial for hash based collections like a hash set. We can
     * ensure that the employee objects are identified as duplicates in hash
     * based collections if they have the same employee number.
     *
     * To be used with the above overridden method 'equals'.
     *
     * @return a hash code for the employee object
     */
    @Override
    public int hashCode() {
        return Objects.hash(empNum);
    }
}
