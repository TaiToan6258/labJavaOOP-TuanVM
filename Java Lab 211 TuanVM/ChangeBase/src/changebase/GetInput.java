/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebase;

import java.util.Scanner;


public class GetInput {

    public static Scanner input = new Scanner(System.in);

    public static int getBase(String msg) {
        System.out.print(msg);
        // convert user choice to the corresponding base 
        while (true) {
            int choice = GetInput.getChoice();
            switch (choice) {
                case 1:
                    choice = 2;
                    break;
                case 2:
                    choice = 10;
                    break;
                case 3:
                    choice = 16;
                    break;
                case 4:
                    System.exit(0);
            }
            return choice;
        }
    }

    public static int getChoice() {
        int min = 1;
        int max = 4;
        String inputSelect = null;
        // validate user choice
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

    public static String getInputValue(int frombase) {
        /*  ^ asserts position at start of a line match a single character 
         present in the list below [] */
        //  + matches the previous token between one and unlimited times //
        //a-f matches a single character in the range between a and z 
        //A-F matches a single character in the range between A and Z 
        //0-1 matches a single character between 0 and 1
        //0-9 matches a single character in the range between 0 and 9 
        //$ asserts position at the end of a line
        // "\\s+" matches one or more white space
        System.out.print("Input number to convert: ");
        String baseDigits = null;
        String inputNumber;
        switch (frombase) {
            case 2:
                baseDigits = "^[0-1]+$";
                break;
            case 10:
                baseDigits = "^[0-9]+$";
                break;
            case 16:
                baseDigits = "^[a-fA-F0-9]+$";
        }
        // check input value
        while (true) {
            inputNumber = input.nextLine();
            if (inputNumber.isEmpty()) {
                System.out.print("Empty !!!\nEnter again: ");
                // check that the user entered the correct format previously selected
            } else if (inputNumber.replaceAll("\\s+", "").
                    matches(baseDigits) == false) {
                System.out.println("Wrong format base digits !!!");
                System.out.print("Enter again: ");
            } else {
                return inputNumber.toUpperCase().replaceAll("\\s+", "");
            }
        }

    }

}
