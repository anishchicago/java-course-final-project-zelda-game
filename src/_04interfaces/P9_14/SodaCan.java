package _04interfaces.P9_14;

public class SodaCan implements Measurable {

    // Implement a class SodaCan with methods getSurfaceArea() and get-­ Volume().
    // In the constructor, supply the height and radius of the can.

    private double height;
    private double radius;

    public SodaCan(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public double getMeasure() {
        return 2 * Math.PI * radius * radius + Math.PI * radius * 2 * height;
    }

    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

}
