/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagerment;

import static doctormanagerment.DoctorHash.fileName;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class GetData {

    public static Scanner input = new Scanner(System.in);

    static int getChoice(int min, int max) {

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

    static Doctor getDoctorInformation() {
        LinkedHashMap<String, Doctor> doctorHashMap = ProcessFile.
                readDatabase(fileName);
        // for check database null or not
        if (doctorHashMap == null) {
            System.out.println("Database does not exist");
            return null;
        }
        System.out.println("---------------- Add Doctor ----------------");
        String code = getString("Enter Code: ", true);
        String name = getString("Enter Name: ", false);
        String specialization = getString("Enter Specialization: ", false);
        int availability = getInt("Enter Availability: ");
        if (code == null) {
            return null;
        }
        return new Doctor(code, name, specialization, availability);
    }

    static String getString(String mgs, boolean check) {
        while (true) {
            System.out.print(mgs);
            String inputString = input.nextLine().trim();
            // for null para
            if (check == true) {
                if (inputString.isEmpty()) {
                    return null;
                } else {
                    return inputString;
                }
            } else if (inputString.isEmpty()) {
                System.out.print("Input is empty!!!");
                System.out.print("Re-Input: ");
            } else {
                return inputString;
            }
        }

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
                    System.out.println("Availability must be > 0");
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

}
