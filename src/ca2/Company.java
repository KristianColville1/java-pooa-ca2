/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author kristian
 */
public class Company {

    // instance fields
    private String companyName;
    private ArrayList<Employee> staff;
    private HashSet<Employee> staffSet;

    /**
     * Default Constructor for Company
     */
    public Company() {
        this.companyName = "CompanyName";
        this.staff = new ArrayList<Employee>();
        this.staffSet = new HashSet<Employee>();
    }

    /**
     * Overloaded Constructor for Company
     *
     * @param name of the company
     */
    public Company(String name) {
        this.companyName = name;
        this.staffSet = new HashSet<Employee>();
    }

    /**
     * ------------------------------------------------Getter Methods
     */
    /**
     * Getter method for retrieving the number of employees in the staff array
     * list
     *
     * @return the number of staff members
     */
    public int getStaffNumber() {
        return staffSet.size();
    }

    /**
     * ------------------------------------------------Utility Methods
     */
    /**
     * Utility method for adding a new employee object to the staff array list.
     *
     * @param emp is the employee object being added
     */
    public void addNewStaff(Employee emp) {
        staffSet.add(emp);
    }

    /**
     * Utility method for removing an employee object out of the staff array
     * list if the employee number matches the parameter given.
     *
     * Uses a lambda expression to filter through the staff array list and
     * remove the employee object if the employee numbers match.
     * 
     * The lambda expression returns true or false so we can use it in a ternary 
     * operator to provide feedback to manager.
     * 
     * Assigns the value to message and outputs it to the console.
     *
     * @param empNum identifies the employee object to remove
     */
    public void removeStaff(int empNum) {
        String message = staffSet.removeIf(
                emp -> emp.getEmployeeNumber() == empNum) ?
                "Removing employee success" : "Employee does not exist";
        System.out.println(message);
    }

    /**
     * Utility method for iterating over the staff of employees and printing the
     * names of the employees who's employee number is greater than the
     * parameter employeeNumber
     *
     * @param employeeNumber to check above when iterating
     */
    public void listEmployees(int employeeNumber) {
        for (Employee emp : staffSet) {
            if (emp.getEmployeeNumber() > employeeNumber) {
                System.out.println(emp.getEmployeeName());
            }
        }
    }
}
