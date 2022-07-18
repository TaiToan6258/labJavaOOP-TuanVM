/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculation;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            // Display Menu For User Choice
            DisplayAndCalculate.displayMenu();
            int choice = GetInput.getChoice();
            switch (choice) {
                case 1:
                    // Addition Matrix
                    DisplayAndCalculate.additionMatrix(choice);
                    break;
                case 2:
                    // Subtraction Matrix
                    DisplayAndCalculate.subtractionMatrix(choice);
                    break;
                case 3:
                    // Multiplication Matrix
                    DisplayAndCalculate.multiplicationMatrix(choice);
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

}
