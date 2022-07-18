/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geographic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Geographic {

    public static final Scanner input = new Scanner(System.in);
    public static ArrayList<EastAsiaCountries> asianCountries = new ArrayList<>();


    public static void main(String[] args) {
        int select;
        EastAsiaCountries country = new EastAsiaCountries();
        while (true) {
            // Manage East Asia Countries
            ManageEastAsiaCountries();
            select = GetInput.getChoice();
            switch (select) {
                case (1):
                    //Addtion Country Information 
                    addCountryInformation(country);
                    break;
                case (2):
                    //Get Recently Entered Information
                    country = getRecentlyEnteredInformation();
                    break;
                case (3):
                    //Search Information By Name
                    String name = null;
                    country = searchInformationByName(name);
                    break;
                case (4):
                    //Sort Information By Ascending Order
                    country = sortInformationByAscendingOrder();
                    break;
                case (5):
                    System.exit(0);
            }

        }
    }

    private static void ManageEastAsiaCountries() {
        System.out.println("\t\t\t    Menu\t\t\t\t");
        System.out.println("==============================================================");
        System.out.println("1. Enter the information for 11 "
                + "countries in Southeast Asia");
        System.out.println("2. Display already information");
        System.out.println("3. Search the country according "
                + "to the entered country's name");
        System.out.println("4. Display the information increasing "
                + "with the country name");
        System.out.println("5. Exit");
        System.out.println("==============================================================");
        System.out.println("Enter your choice :");

    }

    private static void addCountryInformation(EastAsiaCountries country) {
        //User input limit is 2 countries
        while (asianCountries.size() < 2) {
            System.out.println("Enter code of country :");
            String codeCountry = GetInput.getString();
            //check Duplicate ID 
            if (!Validate.checkCountryExits(codeCountry)) {
                return;
            }
            System.out.println("Enter name of country :");
            String nameCountry = GetInput.getString();
            //check Duplicate Name
            if (!Validate.checkCountryExits(nameCountry)) {
                return;
            }
            System.out.println("Enter total Area :");
            float totalArea = GetInput.getFloat();
            System.out.println("Enter terrain of country :");
            String terrainOfCountry = GetInput.getString();
            asianCountries.add(new EastAsiaCountries(terrainOfCountry,
                    codeCountry, nameCountry, totalArea));
            System.out.println("Add Done !");
        }
        /* Do not allow users to enter more 
        when the program has received enough data */
        if (asianCountries.size() == 2) {
            System.out.println("Enough data !");
        }
    }

    private static EastAsiaCountries getRecentlyEnteredInformation() {
        boolean isData = Validate.checkDataIsExits(asianCountries);
        // Check if user has entered data
        if (isData == true) {
            System.out.printf("%-12s%-12s%-25s%-12s\n",
                    "ID", "Name", "Total Area", "Terrain");
        }
        /*loop to traverse each object country from fist obj 
        to last obj of country arraylist */
        for (EastAsiaCountries country : asianCountries) {
            country.display();
            System.out.println("");
        }

        return null;

    }

    private static EastAsiaCountries searchInformationByName(String name) {
        boolean isData = Validate.checkDataIsExits(asianCountries);
        ArrayList<EastAsiaCountries> listOfCountriesFound = new ArrayList<>();
        int flag = 0;
        // Check if user has entered data
        if (isData == true) {
            System.out.println("Enter the name you want to search for:");
            name = input.nextLine().trim();
        }
        /* loop to traverse each object country from fist obj 
        to last obj of country arraylist */
        for (EastAsiaCountries country : asianCountries) {
            // compare input with available data
            if ((country.countryName).toLowerCase()
                    .contains(name.toLowerCase())) {
                flag++;
                listOfCountriesFound.add(country);
            }
        }
        // this case for had found name
        if (flag != 0) {
            System.out.printf("%-12s%-12s%-25s%-12s\n",
                    "ID", "Name", "Total Area", "Terrain");
            /* loop to traverse each object country from fist obj 
            to last obj of countryFound arraylist */
            for (EastAsiaCountries eastAsiaCountries : listOfCountriesFound) {
                eastAsiaCountries.display();
            }
        } else {
            System.out.println("Not found!!!");
        }
        return null;
    }

    private static EastAsiaCountries sortInformationByAscendingOrder() {
        boolean isData = Validate.checkDataIsExits(asianCountries);
        if (isData == true) {
            Collections.sort(asianCountries);
        }
        return getRecentlyEnteredInformation();
    }
}
