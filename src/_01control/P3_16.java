package _01control;

import java.util.Scanner;

public class P3_16 {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter three strings: ");
        String input = scan.nextLine();
        String[] splitInput = input.split(" "); // split on space character

        // check that there are three strings separated by a space
        int myCounter = 0;
        for (int j = 0; j < splitInput.length; j++) {
            if (splitInput[j] != null) {
                myCounter ++;
            }
        }

        if (myCounter != 3) {
            System.out.println("Must input 3 strings each separated by a single space");
            return;
        }

        String [] sorted = new String[3];

        // first only consider first two strings, and sort them in the array "sorted"
        if (splitInput[0].compareTo(splitInput[1]) < 0) {
            sorted[0] = splitInput[0];
            sorted[1] = splitInput[1];
        } else {
            sorted[0] = splitInput[1];
            sorted[1] = splitInput[0];
        }

        // now consider the third string and shuffle around as needed
        if (splitInput[2].compareTo(sorted[0]) < 0) {
            sorted[2] = sorted[1];
            sorted[1] = sorted[0];
            sorted[0] = splitInput[2];
        } else if (splitInput[2].compareTo(sorted[1]) < 0) {
            sorted[2] = sorted[1];
            sorted[1] = splitInput[2];
        } else {
            sorted[2] = splitInput[2];
        }

        // they are now in order; print to console
        System.out.println(sorted[0]);
        System.out.println(sorted[1]);
        System.out.println(sorted[2]);

    }

}
