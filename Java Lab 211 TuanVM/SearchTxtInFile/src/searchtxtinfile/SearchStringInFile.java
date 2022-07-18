/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtxtinfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchStringInFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Step 1: User input directory of file
        File inputFile = new File("myfile.txt");
        inputFile = inputDirectoryFile();
        // Step 2: User input string to search
        String inputString;
        inputString = inputStringToSearch();
        // Step3: Find string or letter words that contain the input string
        findString(inputString, inputFile);
    }

    private static File inputDirectoryFile() {
        String userEnter;
        File inputFile;
        Scanner enter = new Scanner(System.in);
        // validate input directory of file
        while (true) {
            System.out.print("Please enter directory of file:  ");
            userEnter = enter.nextLine();
            inputFile = new File(userEnter);
            String readFile = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                readFile = br.readLine();
            } catch (IOException ex) {
            }
            // Check if the user has entered data ?
            if (userEnter.isEmpty() == true) {
                System.out.println("Input Empty !!! Re-Input");
                // Check file existence
            } else if (inputFile.exists()) {
                    // check if the file has data ?
                if (readFile.isEmpty() == true) {
                    System.out.println("File Empty !!! Re-Input");
                    continue; //file exists but no data --> User must re-enter
                }
                break; // file exits --> end while(true) loop
            } else {
                System.out.println("File does not exist");
            }
        }
        return inputFile;
    }

    private static String inputStringToSearch() {
        String inputString;
        Scanner enter = new Scanner(System.in);
        // validate input string to search
        while (true) {
            System.out.print("Please enter string to search: ");
            inputString = enter.nextLine();
            //check input not null
            if (!inputString.isEmpty()) {
                break; //End the loop
            } else {
                System.out.println("Input Empty !!! Re-Input");
            }
        }
        return inputString;
    }

    private static void findString(String inputString, File inputFile) {
        String[] words = new String[50];
        int flag = 0;
        int i = 0;
        try {
            Scanner enter = new Scanner(inputFile);
            // check and write every word in the file to Array
            while (enter.hasNext()) {
                String file = enter.next();
                words[i] = file;
                i++;
            }
            System.out.println("");
            System.out.println("Search results:");
            // read data in Array words and compare with InputSting
            for (String elements : words) {
                // no more words in array => end of for loop
                if (elements == null) {
                    break; // end loop
                    // compare with InputSting
                } else if (elements.contains(inputString) == true) {
                    flag++;
                    System.out.println("     " + elements);
                }
            }
            // no find any word in file contain input string
            if (flag == 0) {
                System.out.println("Can't find");
            }
        } catch (FileNotFoundException ex) {
        }
        System.out.println("     …");
    }

}
