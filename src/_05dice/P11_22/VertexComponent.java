package _05dice.P11_22;


import javax.swing.*;
import java.awt.*;

public class VertexComponent extends JComponent
{

    private int x;
    private int y;

    public VertexComponent(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
    }

    public int getXCoord() {
        return this.x;
    }

    public int getYCoord() {
        return this.y;
    }

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, 2, 2);

    }

}