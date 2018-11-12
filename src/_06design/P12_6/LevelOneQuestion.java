package _06design.P12_6;

public class LevelOneQuestion extends Question {

    public LevelOneQuestion() {

        int firstInt = 10;
        int secondInt = 10;

        while (firstInt + secondInt >= 10) {
            firstInt = (int)(Math.random() * 8 + 1);
            secondInt = (int)(Math.random() * 8 + 1);
        }

        this.setFirstInt(firstInt);
        this.setSecondInt(secondInt);

    }

    @Override
    public Operation getOperation() {
        return Operation.ADDITION;
    }
}
