package _03objects.P8_14;

public class Geometry {

    public static double sphereVolume(double r) {
        return 4.0 / 3.0 * Math.PI * r * r * r;
    }

    public static double sphereSurface(double r) {
        return 4 * Math.PI * r * r;

    }

    public static double cylinderVolume(double r, double h) {
        return Math.PI * r * r * h;
    }

    public static double cylinderSurface(double r, double h) {
        return 2 * Math.PI * r * (r + h);
    }

    public static double coneVolume(double r, double h) {
        return Math.PI * r * r * h / 3;
    }

    public static double coneSurface(double r, double h) {
        return Math.PI * r * (r + Math.sqrt(h * h + r * r));
    }

}
