package _06design.P12_6;

public class LevelThreeQuestion extends Question {

    public LevelThreeQuestion() {


        int firstInt = (int)(Math.random() * 9 + 1);
        int secondInt = (int)(Math.random() * 9 + 1);

        if (firstInt >= secondInt) { this.setFirstInt(firstInt); this.setSecondInt(secondInt);}
        else { this.setFirstInt(secondInt); this.setSecondInt(firstInt);}

    }

    @Override
    public Operation getOperation() {
        return Operation.SUBTRACTION;
    }
}
