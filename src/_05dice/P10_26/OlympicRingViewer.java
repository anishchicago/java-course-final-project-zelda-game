package _05dice.P10_26;

import javax.swing.*;

public class OlympicRingViewer {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400, 400); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent component = new OlympicRingComponent();
        frame.add(component);
        frame.setVisible(true);
    }

}
