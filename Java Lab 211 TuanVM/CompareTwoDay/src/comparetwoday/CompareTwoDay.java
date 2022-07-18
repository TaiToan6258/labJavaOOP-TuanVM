package comparetwoday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class CompareTwoDay {

    public static void main(String[] args) {
        // Step 1: User enter the first date with [dd/mm/yyyy] format 
        String firstDate;
        firstDate = enterDate("Please enter the first date: ");
        // Step 2: User enter the second date with [dd/mm/yyyy] format
        String secondDate;
        secondDate = enterDate("Please enter the second date: ");
        // Step 3: Compare and display
        compareAndDisplay(firstDate, secondDate);
    }

    private static String enterDate(String message) {
        System.out.print(message);
        String inputDate = null;
        Scanner enter = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dateExits = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        // check when user input correctly
        while (true) {
            try {
                inputDate = enter.nextLine();
                dateFormat.parse(inputDate);
                dateExits.parse(inputDate);
                break; //true format [dd/mm/yyyy] --> end while loop
            } catch (ParseException e) {
                // User input is empty
                if (inputDate.isEmpty() == true) {
                    System.out.print("Empty !!! Re-input: ");
                } else {
                    System.out.print("Wrong Format!!! Re-input: ");
                }
            } catch (Exception e) {
                    System.out.print("Day does not exist!!! Re-input: ");
            }

        }
        return inputDate;
    }

    private static void compareAndDisplay(String firstDate, String secondDate) {
        LocalDate covertFirstString = LocalDate.parse(firstDate,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate covertSecondString = LocalDate.parse(secondDate,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (covertFirstString.equals(covertSecondString) == true) {
            System.out.println("Date1 and Date2 is the same");
        } else if (covertFirstString.isAfter(covertSecondString) == true) {
            System.out.println("Date2 is before Date1");
        } else if (covertFirstString.isBefore(covertSecondString) == true) {
            System.out.println("Date1 is before Date2");
        }

    }
}
