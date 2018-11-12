package _06design.P12_6;

import java.util.Scanner;

public class Game {

    private int points;
    private int level;
    private int tries;

    public Game() {
        this.points = 0;
        this.level = 1;
        this.tries = 0;
    }

    public void play() {

        System.out.println("Welcome to the game! Respond with 'q' at any time to quit");


        while(true) {
            Question question;
            switch (level) {
                case 1: question = new LevelOneQuestion(); break;
                case 2: question = new LevelTwoQuestion(); break;
                case 3: question = new LevelThreeQuestion(); break;
                default: question = new LevelOneQuestion(); break;
            }

            int firstInt = question.getFirstInt();
            int secondInt = question.getSecondInt();
            int answer = question.getAnswer();
            String operationString = question.getOperationString();

            System.out.print("New Question: ");
            System.out.println(firstInt + " " + operationString + " " + secondInt + " = ? ");

            while (true) {
                Scanner in = new Scanner(System.in);
                if (!in.hasNextInt()) {
                    if (in.next().equals("q")) {
                        System.out.println("Bye!");
                        System.exit(0);
                    } else {
                        System.out.println("Please enter a whole number.");
                        continue;
                    }
                }

                int response = in.nextInt();
                if (response == question.getAnswer()) {
                    this.points ++;
                    System.out.println("Correct answer! Points in this level: " + this.points);

                    if (this.points == 5 && this.level < 3) nextLevel();

                    break;

                } else {
                    this.tries ++;
                    System.out.print("Incorrect answer. ");
                    if (this.tries == 1) {
                        System.out.println("Try again.");
                        continue;
                    } else {
                        System.out.println("The answer is " + answer + ". Let's try a different question.");
                        this.tries = 0;
                        break;
                    }
                }

            }

        }

    }

    private void nextLevel() {
        this.level ++;
        this.points = 0;
        System.out.println("You got to level " + this.level + "!");
    }

}
