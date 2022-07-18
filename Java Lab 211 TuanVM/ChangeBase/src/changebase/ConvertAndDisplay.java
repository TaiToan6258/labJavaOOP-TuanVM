/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebase;

import java.math.BigInteger;


public class ConvertAndDisplay {

    public static void convertValueAndDisplay(String inputNumber, 
            int baseInput, int baseOutput) {
        // check the same base number
        if (baseInput == baseOutput) {
            System.out.print("The same base !!!\n");
            return;
        }
        BigInteger valueDecimal = convertToDecimail(inputNumber, baseInput);
        // convert from decimal to (binary || hexa) 
        if (baseOutput == 2 || baseOutput == 16) {
            System.out.print("Result: ");
            convertToBase(valueDecimal, baseOutput);
            System.out.println("");
            // convert from (binary || hexa) to decimal
        } else {
            System.out.print("Result: " + valueDecimal);
            System.out.println("");
        }
    }

    public static BigInteger convertToDecimail(String inputNumber, int baseInput) 
    {
        char[] value = inputNumber.toCharArray();
        BigInteger base = new BigInteger("" + baseInput);
        BigInteger draft = new BigInteger("0");
        BigInteger result = new BigInteger("0");
        // traverse characters from beginning to end
        for (int i = 0; i < value.length; i++) {
            int indexNumber = value.length - i - 1;
            // convert characters (48-57) to (0-9) in ASCCI
            if (value[i] < 65) {
                draft = new BigInteger("" + (value[i] - 48)).
                        multiply(base.pow(indexNumber));
                // convert characters (A-F) to (10-15) in ASCCI
            } else {
                draft = new BigInteger("" + (value[i] - 55)).
                        multiply(base.pow(indexNumber));
            }
            result = result.add(draft);
        }
        return result;
    }

    public static void convertToBase(BigInteger decimalValue, int baseOutput) {
        BigInteger base = new BigInteger("" + baseOutput);
        BigInteger remainder = decimalValue.mod(base);
        /* divide DecimalValue by Base until DecimalValue < Base 
        (quotient is 0) by recursion */
        if (decimalValue.compareTo(base) >= 0) {
            convertToBase(decimalValue.divide(base), baseOutput);
        }
        // covert remainder to [A - F] in ASCII and display corresponding char 
        if (remainder.compareTo(new BigInteger("9")) > 0) {
            System.out.printf("%c", remainder.intValue() + 55);
        } else {
            System.out.print(remainder.intValue());
        }

    }

}
