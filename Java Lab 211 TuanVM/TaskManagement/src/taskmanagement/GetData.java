/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class GetData {

    public static Scanner input = new Scanner(System.in);

    static int getChoice() {
        int min = 1;
        int max = 5;
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

    static String getString() {
        while (true) {
            String inputString = input.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Input is empty!!!");
                System.out.print("Re-Input: ");
            } else {
                return inputString;
            }
        }
    }

    static String getTaskType() {
        while (true) {
            int select;
            select = GetData.getChoice();
            String taskType = null;
            switch (select) {
                case 1:
                    taskType = "Code";
                    break;
                case 2:
                    taskType = "Test";
                    break;
                case 3:
                    taskType = "Design";
                    break;
                case 4:
                    taskType = "Review";
                    break;
            }
            return taskType;
        }
    }

    static String getDate() {
        // ^ asserts position at start of a line
        // 0-9 matches a single character in the range between 0  and 9 
        // {2} matches the previous token 2 times, as many times as possible  
        // - matches a character -
        // {4} matches the previous token 2 times, as many times as possible  
        //$ asserts position at the end of a line
        String fomatDate = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
        while (true) {
            String inputDate = GetData.getString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            // check format date
            if (!inputDate.matches(fomatDate)) {
                System.out.println("Wrong format !!!");
                System.out.print("Re-input Date :");
                continue;
            }
            try {
                Date date = sdf.parse(inputDate);
                Date now = new Date();
                // check user enter date in future
                if (date.before(now)) {
                    System.out.println("This day is in the past");
                    System.out.print("Re-input Date :");
                    continue;
                }
                return inputDate;
            } catch (ParseException ex) {
                System.out.println("Day doesn't extits");
                System.out.print("Re-input Date :");
            }

        }

    }

    static String getPlan() {
        // ^ asserts position at start of a line
        // 0-9 matches a single character in the range between 0  and 9 
        // {1,2} matches the previous token between 1 and 2 times, as many times as possible   
        // | matches or
        // \\.5 (\\.0) matches after [0-9] must be .5 or .0
        //$ asserts position at the end of a line
        String formatTime = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";
        while (true) {
            String inputTime = GetData.getString();
            // check input is true format working time
            if (inputTime.matches(formatTime)) {
                // check the input is within the allowed time
                if (Double.parseDouble(inputTime) < 8.0
                        || Double.parseDouble(inputTime) > 17.5) {
                    System.out.println("Working time should be from 8:00am to 5:30pm");
                    System.out.print("Re-input time:");
                } else {
                    return inputTime;
                }
            } else {
                System.out.println("Wrong format !!!");
                System.out.print("Re-input time :");
            }
        }
    }
}
