package _05dice.P10_2;

/*
Enhance the ButtonViewer1 program in Section 10.2.1 so that it prints a message
“I was clicked n times!” whenever the button is clicked. The value n should be incremented with each click.
 */

import javax.swing.*;

public class ButtonViewer1 {

    public static void main(String[] args) {
        JFrame frame = new ButtonFrame1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
