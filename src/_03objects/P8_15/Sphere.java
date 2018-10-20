package _03objects.P8_15;

// Obviously this approach is more "object-oriented" than 8.14

public class Sphere {

    private double r;

    public Sphere(double r) {
        this.r = r;
    }

    public double getVolume(double r) { return 4.0 / 3.0 * Math.PI * r * r * r; }

    public double getSurface(double r) {
        return 4 * Math.PI * r * r;
    }

}
