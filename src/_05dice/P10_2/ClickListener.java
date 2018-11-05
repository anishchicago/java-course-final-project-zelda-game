package _05dice.P10_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        ButtonFrame1.incrementNumClicks();
        System.out.println("I was clicked " + ButtonFrame1.getNumClicks() + " times."); }
}
