package _05dice.pig;

import javax.swing.*;

public class PlayFrame  extends JFrame {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;


    public PlayFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        Play();
    }

    public void Play() {

        Player player = new Player();
        Player computer = new Computer();

        JLabel interimStatus = new JLabel();
        JLabel bigStatus = new JLabel();

        add(interimStatus);
        add(bigStatus);

        while(true) {
            nextTurn(player);
            interimStatus.setText("PLAYER SCORE" + player.getScore() + '\n' +
                    "COMPUTER SCORE" + computer.getScore());

            if (player.getScore() >= 100) {
                bigStatus.setText("GAME OVER. PLAYER WINS!");
            }

            nextTurn(computer);

            if (computer.getScore() >= 100) {
                bigStatus.setText("GAME OVER. COMPUTER WINS!");

            }
        }


    }


    public void nextTurn(Player player) {
        if (!(player instanceof Computer)) {

            JButton rollButton = new JButton("Roll?");
            add(rollButton);
            rollButton.addActionListener(new RollListener(player, rollButton));


        } else {
            while(true) {
                if(((Computer) player).decideToHold()) {
                    break;
                } else {
                    int rolled = Die.roll();
                    if (rolled > 1)
                        player.setCurrentRollScore(player.getCurrentRollScore() + rolled);
                }
            }

        }
    }

}
