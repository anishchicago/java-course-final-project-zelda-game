package _02arrays;

import java.util.Scanner;

public class P5_8 {

    public static void main(String[] args) {
        String input;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a word (type qqq to quit): ");
            input = scan.next();
            if(input.equalsIgnoreCase("qqq"))
                break;
            System.out.println(scramble(input));
        }

    }


    static String scramble (String word) {

        int length = word.length();

        if (length <= 3)    {
            // swapping can't change words 3 letters or less
            return word;
        }

        // e.g. for an 8 letter word
        // I want a random number from 0 to 6, then add 1 to offset
        // remember that we will call substring and charAt which are zero-indexed

        int pos1 = (int)(Math.random() * ((length - 2))) + 1;
        int pos2 = (int)(Math.random() * ((length - 2))) + 1;
        if (pos2 == pos1) {
            return word;
        }
        int firstPos = pos1;
        int secondPos = pos2;
        if (pos2 < pos1) {
            firstPos = pos2;
            secondPos = pos1;
        }
        String prefix = word.substring(0,firstPos);
        String middle = word.substring(firstPos+1,secondPos);
        String suffix = word.substring(secondPos+1);

        return prefix + word.charAt(secondPos) + middle + word.charAt(firstPos) + suffix;


    }

}
