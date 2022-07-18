/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.ArrayList;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> listEmployee = new ArrayList<>();
        Employee e = new Employee(null, null, null, null, null, null, null, null, 0, null);
        System.out.println(e);
        while (true) {
            // Display Menu
            Display();
            int Choice = GetData.getChoice();
            switch (Choice) {
                case 1:
                    // Add employees 
                    Manage.addEmpoyee(listEmployee);
                    break;
                case 2:
                    // Update employees
                    Manage.updateEmployess(listEmployee);
                    break;
                case 3:
                    // Remove employees
                    Manage.removeEmployees(listEmployee);
                    break;
                case 4:
                    // Search employees
                    Manage.searchEmployees(listEmployee);
                    break;
                case 5:
                    // Sort employees by salary
                    Manage.sortEmployeesBySalary(listEmployee);
                    break;
                case 6:
                    return;
            }
        }

    }

    private static void Display() {
        System.out.println("Main menu:");
        System.out.format("%23s\n", "1. Add employees ");
        System.out.format("%26s\n", "2. Update employees ");
        System.out.format("%26s\n", "3. Remove employees ");
        System.out.format("%26s\n", "4. Search employees ");
        System.out.format("%34s\n", "5. Sort employees by salary ");
        System.out.format("%14s\n", "6. Exit ");
        System.out.print("Enter your choice: ");
    }

}
