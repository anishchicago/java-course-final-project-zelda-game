package _01control;

import java.util.Scanner;

public class P3_14 {

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the card notation: ");
        String input = scan.next();

        boolean rankIsTen = false; // true if the first two letters make "10"

        if (input.length() != 2) {
            if(input.length() == 3 && input.substring(0,2).equals("10")) {
                rankIsTen = true;
            } else {

                System.out.print("Must enter a two-letter string or three-letter string" +
                        "beginning with 10");
            }
        }

        String rank;
        String suit;

        if (rankIsTen) {
            rank = input.substring(0, 2);
            suit = input.substring(2);
        } else {
            rank = input.substring(0, 1);
            suit = input.substring(1);
        }

        String fullRank = "other";
        String fullSuit = "other";

        switch(rank) {
            case "A": fullRank = "Ace"; break;
            case "K": fullRank = "King"; break;
            case "Q": fullRank = "Queen"; break;
            case "J": fullRank = "Jack"; break;
            case "2": fullRank = "Two"; break;
            case "3": fullRank = "Three"; break;
            case "4": fullRank = "Four"; break;
            case "5": fullRank = "Five"; break;
            case "6": fullRank = "Six"; break;
            case "7": fullRank = "Seven"; break;
            case "8": fullRank = "Eight"; break;
            case "9": fullRank = "Nine"; break;
            case "10": fullRank = "Ten"; break;
        }

        if (fullRank.equals("other")) {
            System.out.println("Must enter a valid rank.");
            return;
        }

        switch(suit) {
            case "D": fullSuit = "Diamonds"; break;
            case "H": fullSuit = "Hearts"; break;
            case "S": fullSuit = "Spades"; break;
            case "C": fullSuit = "Clubs"; break;
        }

        if (fullSuit.equals("other")) {
            System.out.println("Must enter a valid suit.");
            return;
        }

        System.out.println(fullRank + " of " + fullSuit);

    }

}
