/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebase;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            // Display Menu
            displayMenu();
            // Get base nuber input
            int baseInput = GetInput.getBase("Please select base number input :");
            // Input Value To Covert
            String inputValue;
            inputValue = GetInput.getInputValue(baseInput);
            // Get base nuber output
            int baseOutput = GetInput.getBase("Please select base number output :");
            // Convert the value from baseInput to baseOutput and Display
            ConvertAndDisplay.convertValueAndDisplay(inputValue, baseInput, baseOutput);
        }
    }

    private static void displayMenu() {
        System.out.println("1. Binary ");
        System.out.println("2. Decimal ");
        System.out.println("3. Hexadecimal ");
        System.out.println("4. Exit ");
    }

}
