/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

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
        // 3 employee objects created
        Employee emp1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee emp2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee emp3 = new Employee("Tom Thumb", "tt@gmail.com");

        /**
         * Declares and initializes the projectGroup array 
         * with the employee objects above.
         */
        Employee[] projectGroup = {emp1, emp2, emp3};
        
        /**
         * Prints out the value of the nextEmpNum for each employee in
         * the projectGroup array
         */ 
        for(Employee emp : projectGroup){
            System.out.println(emp.getNextEmpNum());
        }
        
        /**
         * Displays the name of the employee in projectGroup array if the 
         * employee number is above 'm'
         */
        int m = 0;
        for(Employee emp : projectGroup){
            if(emp.getEmployeeNumber() > m){
                System.out.println(emp.getEmployeeName());
            }
        }
    }

}
