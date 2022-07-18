package geographic;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GetInput {

    static final Scanner input = new Scanner(System.in);

    public static int getChoice() {
        int min = 1;
        int max = 5;
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

    public static String getString() {
        //^ asserts position at start of a line match a single character present in the list below [a-zA-Z0-9 ]
        // + matches the previous token between one and unlimited times, as many times as possible
        //a-z matches a single character in the range between a and z 
        //A-Z matches a single character in the range between A and Z 
        //$ asserts position at the end of a line
        Pattern notSpecialCharacters = Pattern.compile("^[a-zA-Z ]+$");
        // validate name and address is empty or not
        while (true) {
            String inputString = input.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Input is empty!!!");
                System.out.print("Re-Input: ");
            } else if (!notSpecialCharacters.matcher(inputString).find()) {
                System.out.println("input is Special Characters");
                System.out.print("Re-Input: ");
            } else {
                return inputString;
            }
        }
    }

    public static float getFloat() {
        while (true) {
            String inputSelect = null;
            try {
                inputSelect = input.nextLine();
                Float result = Float.parseFloat(inputSelect);
                // Check does the input area exceed the largest of the Southeast Asian countries?
                if (result <= 0) {
                    System.out.print("Area must be greater than 0!!!\n"
                            + "Re-input : ");
                } else {
                    return result;
                }

            } catch (NumberFormatException e) {
                if (inputSelect.trim().isEmpty()) {
                    System.out.println("Input is empty!!!");
                    System.out.print("Re-Input: ");
                } else {
                    System.out.print("Area must be a positive real number ");
                    System.out.print("Re-Input: ");
                }
            }
        }
    }

}
