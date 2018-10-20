package _03objects.P8_11;

public class Driver {

    public static void main(String[] args) {
        Letter maryToJohn = new Letter("Mary", "John");
        maryToJohn.addLine("I am sorry we must part.");
        maryToJohn.addLine("I wish you all the best.");
        System.out.println(maryToJohn.getText());
    }
}
