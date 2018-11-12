package _06design.P12_6;

public class LevelTwoQuestion extends Question {

    public LevelTwoQuestion() {


        int firstInt = (int)(Math.random() * 9 + 1);
        int secondInt = (int)(Math.random() * 9 + 1);

        this.setFirstInt(firstInt);
        this.setSecondInt(secondInt);

    }

    @Override
    public Operation getOperation() {
        return Operation.ADDITION;
    }
}

