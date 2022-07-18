/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


class GetData {

    public static Scanner input = new Scanner(System.in);

    static int getChoice() {
        int min = 1;
        int max = 6;
        String inputSelect = null;
        while (true) {
            try {
                inputSelect = input.nextLine().trim();
                int result = Integer.parseInt(inputSelect);
                if (result < min || result > max) {
                    System.out.println("Your selection is not on the menu!!!"
                            + " Re-select within [" + min + ", " + max + "]");
                    System.out.print("Enter again: ");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                if (inputSelect.isEmpty()) {
                    System.out.println("Emplty !!! "
                            + "Re-select within [" + min + ", " + max + "]");
                    System.out.print("Enter again: ");
                } else {
                    System.out.println("Wrong fomat !!!");
                    System.out.print("Enter again: ");
                }
            }
        }
    }

    static String getString(boolean check, String regex, String mgs) {
        String inputString;
        while (true) {
            System.out.print(mgs);
            inputString = input.nextLine().trim();
            if (inputString.isEmpty()) {
                continue;
                // Check whether input data needs to comply with the format? 
            } else if (check == false) {
                break;
            } else {
                // Check the input data is correct with the required format ?
                if (inputString.toUpperCase().matches(regex)) {
                    break;
                } else {
                    continue;
                }
            }
        }
        return inputString;
    }

    static int getInt(String mgs) {
        String inputInt;
        int value;
        while (true) {
            System.out.print(mgs);
            inputInt = input.nextLine().trim();
            try {
                value = Integer.parseInt(inputInt);
                // check if input by user <= 0 ?
                if (value <= 0) {
                    System.out.println("Slary must be > 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                if (inputInt.isEmpty()) {
                    System.out.println("Input is empty !!!");
                } else {
                    System.out.println("Wrong format !!!");
                }
            }
        }
        return value;
    }

    static Date getDOB(String mgs) {
        // ^ asserts position at start of a line
        // 0-9 matches a single character in the range between 0  and 9 
        // {2} matches the previous token 2 times, as many times as possible  
        // / matches a character /
        // {4} matches the previous token 2 times, as many times as possible  
        //$ asserts position at the end of a line
        String fomatDate = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        while (true) {
            String inputDate = GetData.getString(false, "", mgs);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            // check format date   
            if (!inputDate.matches(fomatDate)) {
                System.out.println("Wrong format !!!");
                continue;
            }
            try {
                Date date = sdf.parse(inputDate);
                Date now = new Date();
                // check user enter date in future
                if (date.after(now)) {
                    System.out.println("This day is in the future");
                    continue;
                }
                return date;
            } catch (ParseException ex) {
                System.out.println("Day doesn't extits");
            }

        }
    }

}
