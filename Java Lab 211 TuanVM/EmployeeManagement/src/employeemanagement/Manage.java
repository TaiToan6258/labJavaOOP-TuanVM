/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.ArrayList;
import java.util.Date;

class Manage {

    // () Capturing Group
    // ^ asserts position at start of a line
    // A-Z matches a single character in the range between A , Z 
    // a-z matches a single character in the range between a , z
    // 0-9 matches a single character in the range between 0 , 9
    // + matches the previous token between one and unlimited times
    // {1,2} matches the previous token between 1 and 2 times
    // M|F matches a single character M or F
    static String regexEmail = "^([A-Za-z0-9]+)@([A-Za-z0-9]+)"
            + "(\\.([A-Za-z0-9]+)){1,2}$";
    static String regexPhone = "^[0-9]+$";
    static String regexSex = "[M|F]";

    static void addEmpoyee(ArrayList<Employee> listEmployee) {
        String id = GetData.getString(false, "", "ID: ");
        // Check duplicate the input data, if not add to listEmployee
        if (checkIDExits(id, listEmployee) == true) {
            System.out.println("----------------------");
            System.out.println("Duplicate !!!");
            return;
        } else {
            String firstName = GetData.getString(false, "", "First Name: ");
            String lastName = GetData.getString(false, "", "Last Name: ");
            String phone = GetData.getString(true, regexPhone, "Phone: ");
            String email = GetData.getString(true, regexEmail, "Email: ");
            String address = GetData.getString(false, "", "Address: ");
            String sex = GetData.getString(true, regexSex, "Sex(M|F): ");
            String agency = GetData.getString(false, "", "Agcency: ");
            int Salary = GetData.getInt("Salary: ");
            Date date = GetData.getDOB("D.O.B(dd/MM/yyyy): ");

            listEmployee.add(new Employee(id, firstName, lastName, phone,
                    email, address, sex, agency, Salary, date));
            System.out.println("----------------------");
            System.out.println("Add Successfully !!!");
        }
        display(listEmployee);
    }

    static void updateEmployess(ArrayList<Employee> listEmployee) {
        if (listEmployee.isEmpty()) {
            System.out.println("No Data !!!");
            return;
        }
        System.out.println("--------Update employees-------");
        String id = GetData.getString(false, "", "ID For Update: ");
        boolean flag = checkIDExits(id, listEmployee);
        // found the record to update
        if (flag == true) {
            String newid = GetData.getString(false, "", "New ID: ");
            if (checkIDExits(newid, listEmployee) == true) {
                System.out.println("----------------------");
                System.out.println("Duplicate !!!");
                return;
            } else {
                String firstName = GetData.getString(false, "", "New First Name: ");
                String lastName = GetData.getString(false, "", "New Last Name: ");
                String phone = GetData.getString(true, regexPhone, "New Phone: ");
                String email = GetData.getString(true, regexEmail, "New Email: ");
                String address = GetData.getString(false, "", "New Address: ");
                String sex = GetData.getString(true, regexSex, "New Sex: ");
                String agency = GetData.getString(false, "", "New Agcency: ");
                int Salary = GetData.getInt("New Salary: ");
                Date date = GetData.getDOB("New D.O.B: ");
                for (Employee employee : listEmployee) {
                    // found the id to update
                    if (employee.getID().equalsIgnoreCase(id)) {
                        employee.setID(newid);
                        employee.setFirstName(firstName);
                        employee.setLastName(lastName);
                        employee.setPhone(phone);
                        employee.setEmail(email);
                        employee.setAddress(address);
                        employee.setSex(sex);
                        employee.setAgency(agency);
                        employee.setSalary(Salary);
                        employee.setDob(date);
                        System.out.println("Update Succesfully !!!");
                    }
                }
            }
            display(listEmployee);
        } else {
            System.out.println("Unable to update because "
                    + "ID does not exist !!!");
        }
    }

    static void removeEmployees(ArrayList<Employee> listEmployee) {
        if (listEmployee.isEmpty()) {
            System.out.println("No Data !!!");
            return;
        }
        System.out.println("--------Remove employees-------");
        String id = GetData.getString(false, "", "ID: ");
        boolean flag = checkIDExits(id, listEmployee);
        // found the record to remove
        if (flag == true) {
            for (int i = 0; i < listEmployee.size(); i++) {
                // found the id to remove
                if (listEmployee.get(i).getID().equalsIgnoreCase(id)) {
                    listEmployee.remove(i);
                    System.out.println("Remove Succesfully !!!");
                }
            }
            display(listEmployee);
        } else {
            System.out.println("Unable to remove because "
                    + "ID does not exist !!!");
        }

    }

    static void searchEmployees(ArrayList<Employee> listEmployee) {
        if (listEmployee.isEmpty()) {
            System.out.println("No Data !!!");
            return;
        }
        ArrayList<Employee> listEmployeesFound = new ArrayList<>();
        int flag = 0;
        System.out.println("--------Search employees-------");
        String inputName = GetData.getString(false, "", "Enter the "
                + "name to search: ");
        for (Employee employee : listEmployee) {
            String name = employee.getFirstName()
                    + " " + employee.getLastName();
            // Compare input data with name
            if (name.toLowerCase().contains(inputName.toLowerCase())) {
                flag++;
                listEmployeesFound.add(employee);
            }
        }
        // this case for found employee
        if (flag != 0) {
            display(listEmployeesFound);
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("No employee found matching name to be found !!!");
        }
    }

    static void sortEmployeesBySalary(ArrayList<Employee> listEmployee) {
        if (listEmployee.isEmpty()) {
            System.out.println("No Data !!!");
            return;
        }
        Employee[] employee = listEmployee.
                toArray(new Employee[listEmployee.size()]);
        
        ArrayList<Employee> listEmployeesSorted = new ArrayList<>();
        System.out.println("--------Sort employees-------");
        //traverse elements from beginning to end
        for (int i = 0; i < employee.length; i++) {
            /* loop to iterate over each element from start 
            to last unsorted element */      
            for (int j = 1; j < employee.length - i; j++) {
                // check when the pre element greater than after element 
                if (employee[j - 1].Salary > employee[j].Salary) {
                    //swap 2 adjacent elements
                    Employee temp = employee[j - 1];
                    employee[j - 1] = employee[j];
                    employee[j] = temp;
                }
            }
        }
        for (Employee employee1 : employee) {
            listEmployeesSorted.add(employee1);
        }
        display(listEmployeesSorted);

    }

    private static boolean checkIDExits(String id,
            ArrayList<Employee> listEmployee) {
        /* loop to traverse each object Employee from fist obj to 
        last obj of listEmployee */
        for (int i = 0; i < listEmployee.size(); i++) {
            // check input id vs id in listEmployee is equal or not
            if (listEmployee.get(i).getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    static void display(ArrayList<Employee> listEmployee) {
        System.out.printf("%-8s%-16s%-16s%-15s%-25s%-25s%-8s%-25s%-16s%-16s",
                "ID", "FirstName", "LastName", "Phone", "Email", "Address",
                "Sex", "Agency", "Salary", "DOB");
        System.out.println("");
        for (Employee employee : listEmployee) {
            employee.toString();
            System.out.println(employee);
        }
    }
}
