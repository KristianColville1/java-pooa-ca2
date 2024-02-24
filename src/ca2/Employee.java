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
    public Employee(){
        this.name = "John Doe";
        this.email = "johndoe@gmail.com";
        this.empNum = this.nextEmpNum++;
    }
    
    /**
     * Overloaded constructor for Employee class object.
     * @param name of the employee
     * @param email of the employee
     */
    public Employee(String name, String email){
        this.name = name;
        this.email = email;
        this.empNum = this.nextEmpNum++;
    }
    
    /**
     * ------------------------------------------------Getter Methods
     */
    
    /**
     * Getter method for returning the name of the Employee
     * @return name of the employee
     */
    public String getEmployeeName(){
        return name;
    }
    
    /**
     * Getter method for returning the email of the Employee
     * @return email address of the employee
     */
    public String getEmployeeEmail(){
        return email;
    }
}
