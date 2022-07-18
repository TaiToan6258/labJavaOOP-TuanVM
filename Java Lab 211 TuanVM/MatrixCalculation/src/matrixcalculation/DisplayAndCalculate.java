/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculation;

public class DisplayAndCalculate {

    static void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Additon Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }

    static void additionMatrix(int choice) {
        System.out.println("----------- Addition ----------");
        int[][] matrix1 = GetInput.getMatrix(1, choice, 0, 0);
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrix2 = GetInput.getMatrix(2, choice, row1, col1);

        int[][] Result = new int[matrix1.length][matrix1[0].length];
        //traverse  from first row to the last row
        for (int i = 0; i < matrix1.length; i++) {
            //traverse  from first column to the last column
            for (int j = 0; j < matrix1[0].length; j++) {
                Result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        displayResult(matrix1, matrix2, Result, "+");
    }

    static void subtractionMatrix(int choice) {
        System.out.println("----------- Subtraction ----------");
        int[][] matrix1 = GetInput.getMatrix(1, choice, 0, 0);
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrix2 = GetInput.getMatrix(2, choice, row1, col1);

        int[][] Result = new int[matrix1.length][matrix1[0].length];
        //traverse  from first column to last column
        for (int i = 0; i < matrix1.length; i++) {
            //traverse  from first row to last row
            for (int j = 0; j < matrix1[0].length; j++) {
                Result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        displayResult(matrix1, matrix2, Result, "-");
    }

    static void multiplicationMatrix(int choice) {
        System.out.println("----------- Multiplication ----------");
        int[][] matrix1 = GetInput.getMatrix(1, choice, 0, 0);
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrix2 = GetInput.getMatrix(2, choice, row1, col1);

        int[][] Result = new int[matrix1.length][matrix2[0].length];
        //traverse  from first column to last column of matrix 
        for (int i = 0; i < matrix1.length; i++) {
            //traverse  from first row to last row of matrix 
            for (int j = 0; j < matrix2[0].length; j++) {
                /* traverse  from first element to the last element of row in 
                matrix 1 and column in matrix 2 */
                for (int k = 0; k < matrix2.length; k++) {
                    Result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayResult(matrix1, matrix2, Result, "*");
    }

    private static void displayResult(int[][] matrix1, int[][] matrix2,
            int[][] Result, String operator) {
        System.out.println("---------- Result ---------");
        displayMatrix(matrix1);
        System.out.println(operator);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(Result);
    }

    private static void displayMatrix(int[][] matrix) {
        //traverse from first row to the last row
        for (int i = 0; i < matrix.length; i++) {
            //traverse from first column to the last column
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
