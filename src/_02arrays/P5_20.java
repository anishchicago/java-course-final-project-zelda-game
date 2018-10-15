package _02arrays;

import java.util.Scanner;

public class P5_20 {

    public static void main(String[] args) {
        int input;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a year (-1 to quit): ");
            input = scan.nextInt();
            if (input == -1)
                break;
            System.out.println(isLeapYear(input));
        }

    }


    public static boolean isLeapYear(int year) {

        if (year % 4 == 0) {

            // pre-gregorian
            if (year <= 1582) {
                return true;
            }

            // gregorian
            if (year % 400 == 0)
                return true;
            if (year % 100 == 0)
                return false;
            return true;

        }

        // not divisible by 4

        return false;

    }
}

