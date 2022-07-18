package informationofperson;

import java.util.Scanner;

public class InfomationOfPerson {

    static Scanner enter = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Input Person information
        Person[] Person = new Person[3];
        Person = inputPersonInfo();
        // Sort person list by salary ascending 
        sortBySalary(Person);
        // Display Person Information
        displayPersonInfo(Person);
    }

    private static Person[] inputPersonInfo() {
        System.out.println("=====Management Person programer=====");
        Person[] Person = new Person[3];
        //Limit the list to only contain information of 3 people
        for (int i = 0; i < Person.length; i++) {
            System.out.println("Input Information of Person");
            System.out.print("Please input name:");
            String name = GetData.getString();
            System.out.print("Please input address:");
            String address = GetData.getString();
            System.out.print("Please input salary:");
            double salary = GetData.getSalary();
            Person[i] = new Person(name, address, salary);
        }
        return Person;
    }

    private static void sortBySalary(Person[] Person) {
        //traverse elements from beginning to end
        for (int i = 0; i < Person.length; i++) {
            // loop to iterate over each element from start to last unsorted element 
            for (int j = 1; j < Person.length - i; j++) {
                // check when the pre element greater than after element 
                if (Person[j - 1].salary > Person[j].salary) {
                    //swap 2 adjacent elements
                    Person temp = Person[j - 1];
                    Person[j - 1] = Person[j];
                    Person[j] = temp;
                }
            }
        }

    }

    private static void displayPersonInfo(Person[] Person) {
        System.out.println("");
        // Display person info after sort
        for (Person listPerson : Person) {
            System.out.println("Information of Person you have entered:");
            System.out.println(listPerson.toString());
            System.out.println("");
        }
    }

}
