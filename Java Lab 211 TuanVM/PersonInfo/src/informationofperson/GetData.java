/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationofperson;

import static informationofperson.InfomationOfPerson.enter;
import java.util.regex.Pattern;

public class GetData {
        public static String getString() {
        //^ asserts position at start of a line match a single character present in the list below [a-zA-Z0-9 ]
        // + matches the previous token between one and unlimited times, as many times as possible
        //a-z matches a single character in the range between a and z 
        //A-Z matches a single character in the range between A and Z
        //0-9 matches a single character in the range between 0 and 9 
        //$ asserts position at the end of a line
        Pattern notSpecialCharacters = Pattern.compile("^[a-zA-Z0-9 ]+$");
        // validate name and address is empty or not
        while (true) {
            String inputString = enter.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Input is empty!!!");
                System.out.print("Re-Input: ");
            } else if (!notSpecialCharacters.matcher(inputString).find()) {
                System.out.println("Your input is Special Characters");
                System.out.print("Re-Input: ");
            } else {
                return inputString;
            }
        }
    }

    public static double getSalary() {
        Pattern checkNotDigit = Pattern.compile("^[0-9.-]+$");
        // check salary validity
        while (true) {
            String sSalary = enter.nextLine().trim();
            try {
                if (sSalary.isEmpty()) {
                    System.out.println("You must input Salary");
                    System.out.print("Please input salary:");
                    // Salary cannot be negative
                } else if (Double.parseDouble(sSalary) < 0) {
                    System.out.println("Salary is greater than zero");
                    System.out.print("Please input salary:");
                } else {
                    return Double.parseDouble(sSalary);
                }
            } catch (NumberFormatException e) {
                System.out.println("You must input digit");
                System.out.print("Please input salary:");
            }
        }
    }
}
