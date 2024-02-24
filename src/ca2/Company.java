/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.ArrayList;

/**
 *
 * @author kristian
 */
public class Company {

    // instance fields
    private String companyName;
    private ArrayList<Employee> staff;

    /**
     * Default Constructor for Company
     */
    public Company() {
        this.companyName = "CompanyName";
        this.staff = new ArrayList<Employee>();
    }

    /**
     * Overloaded Constructor for Company
     *
     * @param name of the company
     */
    public Company(String name) {
        this.companyName = name;
        this.staff = new ArrayList<Employee>();
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
        return staff.size();
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
        staff.add(emp);
    }

    /**
     * Utility method for removing an employee object out of the staff array list
     * if the employee number matches the parameter given.
     * 
     * Uses a lambda expression to filter through the staff array list and
     * remove the employee object if the employee numbers match.
     * @param empNum identifies the employee object to remove
     */
    public void removeStaff(int empNum) {
        staff.removeIf(emp -> emp.getEmployeeNumber() == empNum);
    }

    /**
     * Utility method for iterating over the staff of employees and printing the
     * names of the employees who's employee number is greater than the
     * parameter employeeNumber
     *
     * @param employeeNumber to check above when iterating
     */
    public void listEmployees(int employeeNumber) {
        for (Employee emp : staff) {
            if (emp.getEmployeeNumber() > employeeNumber) {
                System.out.println(emp.getEmployeeName());
            }
        }
    }
}
