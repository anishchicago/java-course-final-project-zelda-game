package _02arrays;

import java.util.Scanner;

public class P5_25 {

    public static void main(String[] args) {
        int input;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a zipcode (-1 to quit): ");
            input = scan.nextInt();
            if (input == -1)
                break;
            printBarCode(input);
        }

    }

    public static void printDigit(int d) {
        String barDigit = "";
        switch (d) {
            case 1: barDigit = ":::||"; break;
            case 2: barDigit = "::|:|"; break;
            case 3: barDigit = "::||:"; break;
            case 4: barDigit = ":|::|"; break;
            case 5: barDigit = ":|:|:"; break;
            case 6: barDigit = ":||::"; break;
            case 7: barDigit = "|:::|"; break;
            case 8: barDigit = "|::|:"; break;
            case 9: barDigit = "|:|::"; break;
            case 0: barDigit = "||:::"; break;
        }

        System.out.print(barDigit);
    }

    public static void printBarCode(int zipCode) {

        // opening bar
        System.out.print("|");

        int sum = 0;

        String strZipCode = String.valueOf(zipCode);

        for (int i = 0; i <= strZipCode.length() - 1; i++) {
            int digit = Character.getNumericValue(strZipCode.charAt(i));
            printDigit(digit);
            sum += digit;
        }

        // check digit
        int checkDigit = 10 - (int) (sum % 10);
        printDigit(checkDigit);

        // closing bar
        System.out.println("|");
    }

}
