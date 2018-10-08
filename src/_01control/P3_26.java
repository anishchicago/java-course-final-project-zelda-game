package _01control;

import java.util.Scanner;

public class P3_26 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Input integer: ");
        int input = scan.nextInt();

        if (input < 1 || input > 3999) {
            System.out.println("Must input an integer between 1 and 3999.");
            return;
        }

        int digit; // next digit, starting from left
        int counter = 0; // number of positions from decimal

        String romanNumerals = ""; // keep track of numerals

        String oneNumeral = ""; // e.g. I
        String fiveNumeral = ""; // e.g. V
        String tenNumeral = ""; // e.g. X
        String thisNumeral = ""; // numeral to express current digit

        while (input > 0) {

            counter ++;

            // pull the last digit to the right that we haven't considered yet
            digit = (int)(input % 10);


            switch (counter) {
                case 1:
                    oneNumeral = "I";
                    fiveNumeral = "V";
                    tenNumeral = "X";
                    break;
                case 2:
                    oneNumeral = "X";
                    fiveNumeral = "L";
                    tenNumeral = "C";
                    break;
                case 3:
                    oneNumeral = "C";
                    fiveNumeral = "D";
                    tenNumeral = "M";
                    break;
                case 4:
                    oneNumeral = "M";
                    break;
            }

            // encode how each digit is constructed using the relevant numerals
            switch (digit) {
                case 0:
                    thisNumeral = ""; break;
                case 1:
                    thisNumeral = oneNumeral; break;
                case 2:
                    thisNumeral = oneNumeral + oneNumeral; break;
                case 3:
                    thisNumeral = oneNumeral + oneNumeral + oneNumeral; break;
                case 4:
                    thisNumeral = oneNumeral + fiveNumeral; break;
                case 5:
                    thisNumeral = fiveNumeral; break;
                case 6:
                    thisNumeral = fiveNumeral + oneNumeral; break;
                case 7:
                    thisNumeral = fiveNumeral + oneNumeral + oneNumeral; break;
                case 8:
                    thisNumeral = fiveNumeral + oneNumeral + oneNumeral + oneNumeral; break;
                case 9:
                    thisNumeral = oneNumeral + tenNumeral; break;
            }

            // add to the 'running total' of numerals
            romanNumerals = thisNumeral + romanNumerals;

            // now that we have encoded the relevant digit, ignore it
            // by doing integer division by 10

            input = input / 10;

        }

        System.out.println(romanNumerals);
    }
}


