package _05dice.P10_26;

import javax.swing.*;
import java.awt.*;

public class OlympicRingComponent extends JComponent {

    public void paintComponent(Graphics g)
    {
        drawRing(g, 0, 0, 100, Color.BLUE);
        drawRing(g, 100, 0, 100, Color.BLACK);
        drawRing(g, 200, 0, 100, Color.RED);
        drawRing(g, 50, 50, 100, Color.YELLOW);
        drawRing(g, 150, 50, 100, Color.GREEN);
    }

    void drawRing(Graphics g, int xLeft, int yTop, int width, Color ringColor)
    {
        g.setColor(ringColor);
        g.drawOval(xLeft, yTop, width, width);
    }

}
