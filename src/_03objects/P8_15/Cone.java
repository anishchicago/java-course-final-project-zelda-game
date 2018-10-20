package _03objects.P8_15;

public class Cone {

    private double r;
    private double h;

    public Cone(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double getVolume(double r, double h) {
        return Math.PI * r * r * h / 3;
    }

    public double getSurface(double r, double h) {
        return 2 * Math.PI * r * (r + h);
    }

}
