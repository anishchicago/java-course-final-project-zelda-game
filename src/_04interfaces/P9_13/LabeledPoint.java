package _04interfaces.P9_13;

import java.awt.*;

public class LabeledPoint {

    private Point p;
    private String label;

    public LabeledPoint(int x, int y, String label) {
        this.p = new Point(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "p=" + p +
                ", label='" + label + '\'' +
                '}';
    }
}
