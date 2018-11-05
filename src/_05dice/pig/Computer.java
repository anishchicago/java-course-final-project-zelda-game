package _05dice.pig;

public class Computer extends Player {

    public boolean decideToHold() {
        if (Math.random() < 1/3) return true; else return false;
    }

}
