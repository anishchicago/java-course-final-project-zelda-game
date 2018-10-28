package _04interfaces.P9_10;

import java.awt.*;

public class BetterRectangle extends Rectangle {

    public BetterRectangle(int x, int y, int width, int height) {
        super.setLocation(x, y);
        super.setSize(width, height);
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    public double getArea() {
        return this.width * this.height;
    }

}
