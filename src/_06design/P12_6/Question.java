package _06design.P12_6;

public abstract class Question {

    private int firstInt;
    private int secondInt;
    enum Operation { ADDITION, SUBTRACTION};


    public abstract Operation getOperation();

    public int getAnswer() {

        if (this.getOperation() == Operation.ADDITION) return firstInt + secondInt;
        else if (this.getOperation() == Operation.SUBTRACTION) return firstInt - secondInt;
        else return -1;

    }

    public int getFirstInt() {
        return firstInt;
    }

    public void setFirstInt(int firstInt) {
        this.firstInt = firstInt;
    }

    public int getSecondInt() {
        return secondInt;
    }

    public void setSecondInt(int secondInt) {
        this.secondInt = secondInt;
    }

    public String getOperationString() {
        if (this.getOperation() == Operation.ADDITION) return "+";
        else if (this.getOperation() == Operation.SUBTRACTION) return "-";
        else return "";

    }

}
