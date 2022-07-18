/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculation;

import java.util.Scanner;

public class GetInput {

    public static Scanner input = new Scanner(System.in);

    static int getChoice() {
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

    static int[][] getMatrix(int nameOfMatrix, int choice,
            int row1, int col1) {
        int[][] matrix = null;
        int row2 = 0, col2 = 0;
        // check if user is entering matrix 2 or not 
        if (nameOfMatrix == 2) {
            // check (row 2,column 2) vs (row1,column1) for add or sub matrix
            if (choice == 1 || choice == 2) {
                row2 = getRow2AndCol2(row1, "Row",
                        "Two matrices of different degrees");
                col2 = getRow2AndCol2(col1, "Column",
                        "Two matrices of different degrees");
                // check row2 vs column1 for multiplication matrix
            } else {
                row2 = getRow2AndCol2(col1, "Row",
                        "Column of matrix1 must equal row of matrix2");
                col2 = getInteger("Column", nameOfMatrix);
            }
            matrix = getValueMatrix(row2, col2, nameOfMatrix);
            // for matrix 1
        } else {
            row2 = getInteger("Row", nameOfMatrix);
            col2 = getInteger("Column", nameOfMatrix);
            matrix = getValueMatrix(row2, col2, nameOfMatrix);
        }

        return matrix;
    }

    private static int getRow2AndCol2(int value , String name, String mgs) {
        int result;
        while (true) {
            result = getInteger(name, 2);
            // check row2 or column2 vs the corresponding value to be compared
            if (result != value ) {
                System.out.println(mgs);
            } else {
                break;
            }
        }
        return result;
    }


    private static int getInteger(String mgs, int nameOfMatrix) {
        int value = 0;
        String input;
        Scanner enter = new Scanner(System.in);
        while (true) {
            System.out.print("Enter " + mgs + " Matrix "
                    + nameOfMatrix + ":");
            input = enter.nextLine().trim();
            try {
                value = Integer.parseInt(input);
                // check if input by user <= 0 ?
                if (value <= 0) {
                    System.out.println(mgs + "must be > 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                if (input.isEmpty()) {
                    System.out.println("Input is empty !!!");
                } else {
                    System.out.println("Wrong format !!!");
                }
            }
        }
        return value;
    }

    private static int[][] getValueMatrix(int row, int column,
            int nameOfMatrix) {
        int[][] matrix = new int[row][column];
        //traverse  from first row to the last row
        for (int i = 0; i < matrix.length; i++) {
            //traverse  from first column to the last column
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = getElementOfMatrix(String.format("Enter "
                        + "Matrix%d[%d][%d]:",
                        nameOfMatrix, i + 1, j + 1));
            }
        }
        return matrix;
    }

    private static int getElementOfMatrix(String mgs) {
        while (true) {
            System.out.print(mgs);
            String elements = input.nextLine();
            try {
                float temp = Float.parseFloat(elements);
                int result = (int) temp;
                //if input float number
                if (temp - result > 0) {
                    System.out.println("Not input float number!");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                if (elements.isEmpty()) {
                    System.out.println("Not input empty!");
                } else {
                    System.out.println("Values of matrix must be the digit");
                }
            }
        }
    }

}
