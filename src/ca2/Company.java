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
        this.staff = new ArrayList<Employee>();
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
     * Uses a HashSet which prevents duplicates before adding to the staff
     * ArrayList.
     *
     * @param emp is the employee object being added
     * @throws IllegalArgumentException if a duplicate is detected
     */
    public void addNewStaff(Employee emp) {
        if (!staffSet.add(emp)) {
            throw new IllegalArgumentException(
                    "Employee with empNum"
                    + emp.getEmployeeNumber() + " already exists.");
        }
        staff.add(emp);
    }

    /**
     * Utility method for removing an employee object out of the staff array
     * list if the employee number matches the parameter given.
     *
     * Uses a lambda expression to filter through the staff array list and
     * remove the employee object if the employee numbers match.
     *
     * The lambda expression returns true or false. I assign the result of this
     * to staffExists and then conditionally remove it from staff array list
     * also.
     *
     * Outputs the result of trying to remove employee to the console depending
     * on the flow.
     *
     * @param empNum identifies the employee object to remove
     */
    public void removeStaff(int empNum) {
        boolean staffExists = staffSet.removeIf(
                emp -> emp.getEmployeeNumber() == empNum);

        if (staffExists) {
            staff.removeIf(emp -> emp.getEmployeeNumber() == empNum);
            System.out.println("Removing employee success");
        } else {
            System.out.println("Employee does not exist");
        }
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
