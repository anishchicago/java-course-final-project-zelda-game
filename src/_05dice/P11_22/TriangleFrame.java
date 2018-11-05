package _05dice.P11_22;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TriangleFrame extends JFrame {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private static int clickNumber = 0;

    private int xOrigin;
    private int yOrigin;

    private static ArrayList<VertexComponent> dotSet = new ArrayList<>();
    private static ArrayList<JComponent> lineSet = new ArrayList<>();

    public TriangleFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.addMouseListener(new MouseClickListener());
    }

    class MouseClickListener implements MouseListener {

        public void mousePressed(MouseEvent event) {}
        public void mouseReleased(MouseEvent event) {}

        public void mouseClicked (MouseEvent event) {

            incrementClickNumber();

            int x = event.getX();
            int y = event.getY();

            int clickNumber = getClickNumber();


            switch (clickNumber) {
                case 1:
                    VertexComponent vertex1 = new VertexComponent(x, y);
                    add(vertex1);
                    vertex1.revalidate();
                    vertex1.repaint();
                    dotSet.add(vertex1);
                    xOrigin = x;
                    yOrigin = y;
                    break;

                case 2:
                    VertexComponent vertex2 = new VertexComponent(x, y);
                    add(vertex2);
                    vertex2.revalidate();
                    vertex2.repaint();
                    dotSet.add(vertex2);

                    LineComponent line1 = new LineComponent(dotSet.get(0).getXCoord(), dotSet.get(0).getYCoord(), x, y);
                    add(line1);
                    line1.revalidate();
                    line1.repaint();
                    lineSet.add(line1);
                    break;

                case 3:

                    VertexComponent vertex3 = new VertexComponent(x, y);
                    add(vertex3);
                    vertex3.revalidate();
                    vertex3.repaint();
                    dotSet.add(vertex3);



                    LineComponent line2 = new LineComponent(dotSet.get(1).getXCoord(), dotSet.get(1).getYCoord(), x, y);
                    add(line2);
                    line2.revalidate();
                    line2.repaint();
                    lineSet.add(line2);

                    LineComponent line3 = new LineComponent(x, y, xOrigin, yOrigin);
                    add(line3);
                    line3.revalidate();
                    line3.repaint();
                    lineSet.add(line3);

                    break;

                case 4:

                    for (int counter = 0; counter < 3; counter ++) {

                        remove(dotSet.get(counter));
                        remove(lineSet.get(counter));
                    }

                    resetClickNumber();


                    dotSet.clear();
                    lineSet.clear();

                    VertexComponent vertexNew = new VertexComponent(x, y);
                    add(vertexNew);
                    vertexNew.revalidate();
                    vertexNew.repaint();
                    dotSet.add(vertexNew);

                    break;
            }


        }

        public void mouseEntered (MouseEvent event){        }
        public void mouseExited (MouseEvent event){        }

        }


    public static int getClickNumber() {
        return clickNumber;
    }

    public static void incrementClickNumber() {
        clickNumber ++;
    }

    public static void resetClickNumber() {
        clickNumber = 1;
    }

}

