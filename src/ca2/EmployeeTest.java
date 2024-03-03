/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kristian colville
 * @student sba23246
 * @github https://github.com/KristianColville1/java-pooa-ca2
 */
public class EmployeeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // 3 employee objects created
            Employee emp1 = new Employee("Joe Bloggs", "jb@gmail.com");
            Employee emp2 = new Employee("Ann Banana", "ab@gmail.com");
            Employee emp3 = new Employee("Tom Thumb", "tt@gmail.com");

            /**
             * Declares and initializes the projectGroup array with the employee
             * objects above.
             */
            Employee[] projectGroup = {emp1, emp2, emp3};

            /**
             * Prints out the current value of nextEmpNum
             */
            System.out.println(Employee.getNextEmpNum());

            /**
             * Displays the name of the employee in projectGroup array if the
             * employee number is above 'm'
             */
            int m = 0;
            for (Employee emp : projectGroup) {
                if (emp.getEmployeeNumber() > m) {
                    System.out.println(emp.getEmployeeName());
                }
            }
//            Test duplicates failing success
//            Company company = new Company();
//            company.addNewStaff(emp2);
//            company.addNewStaff(emp2); // fails with IllegalArgumentException

            // Creates the company and adds our employees to it.
            Company company = new Company("Business Gnómes Ltd.");
            company.addNewStaff(emp1);
            company.addNewStaff(emp2);
            company.addNewStaff(emp3);
            
            // creates a manager with username and password
            Manager manager = new Manager(
                    "Kristian Colville", 
                    "kristiancolville96@gmail.com", 
                    "Gnomeo", 
                    "smurf");
            
            // add manager to the company
            company.addNewStaff(manager);
            
            
            // creates list of managers
            List<Manager> managers = new ArrayList<>();
            managers.add(manager);
            
            // passes in list of users to console menu
            ConsoleMenu.start(managers, company);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
