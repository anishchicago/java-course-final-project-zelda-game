package _05dice.P11_22;
import javax.swing.*;


/*

Write a program that allows the user to specify a triangle with three mouse presses.
 After the first mouse press, draw a small dot. After the second mouse press,
 draw a line joining the first two points. After the third mouse press,
 draw the entire triangle. The fourth mouse press erases the old triangle and starts a new one.
 */




public class Driver {

    public static void main(String[] args) {
        JFrame frame = new TriangleFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
