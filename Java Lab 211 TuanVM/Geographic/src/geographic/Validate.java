/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geographic;

import static geographic.Geographic.asianCountries;
import java.util.ArrayList;


public class Validate {
       public static boolean checkDataIsExits(ArrayList<EastAsiaCountries> asianCountries) {
        // Check if user has entered data
        if (asianCountries.size() > 0) {
            return true;
        } else {
            System.out.println("No Data");
            return false;
        }
    }

    public static boolean checkCountryExits(String Exits) {
        for (EastAsiaCountries country : asianCountries) {
            // "\\s+" matches one or more white space
            // check id or name duplicate
            if (country.getCountryName().replaceAll("\\s+", "").
                    equalsIgnoreCase(Exits.replaceAll("\\s+", ""))
                    || country.getCountryCode().replaceAll("\\s+", "")
                            .equalsIgnoreCase(Exits.replaceAll("\\s+", ""))) {
                System.out.println("This country already exists");
                return false;
            }
        }
        return true;

    }
}
