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
    public Company(){
        this.companyName = "CompanyName";
        this.staff = new ArrayList<Employee>();
    }
}
