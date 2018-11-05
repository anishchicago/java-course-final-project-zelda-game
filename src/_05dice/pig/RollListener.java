package _05dice.pig;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollListener implements ActionListener {

    private Player player;
    private JButton button;

    public RollListener(Player player, JButton button) {
        this.player = player;
        this.button = button;
    }

    public void actionPerformed(ActionEvent event) {
        int rolled = Die.roll();
        if (rolled > 1)
            player.setCurrentRollScore(player.getCurrentRollScore() + rolled);
        else {
            player.setCurrentRollScore(0);
        }

        button.setVisible(false);
     }
}
