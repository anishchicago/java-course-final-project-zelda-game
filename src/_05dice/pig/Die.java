package _05dice.pig;

public class Die {

    public static int roll() {
        return (int)(Math.random() * 6 + 1);
    }

}
