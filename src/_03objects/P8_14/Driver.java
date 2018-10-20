package _03objects.P8_14;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        // NOTE: computes sphere stats first using radius only,
        // then prompts user for height for the other shapes.

        Scanner scanR = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = scanR.nextDouble();

        System.out.println("Sphere Volume: " +
                String.format("%.2f", Geometry.sphereVolume(r)));
        System.out.println("Sphere Surface Area: " +
                String.format("%.2f", Geometry.sphereSurface(r)));

        Scanner scanH = new Scanner(System.in);
        System.out.print("Enter height: ");
        double h = scanH.nextDouble();

        System.out.println("Cylinder Volume:  " +
                String.format("%.2f", Geometry.cylinderVolume(r, h)));
        System.out.println("Cylinder Surface Area:  " +
                String.format("%.2f", Geometry.cylinderSurface(r, h)));
        System.out.println("Cone Volume:  " +
                String.format("%.2f", Geometry.coneVolume(r, h)));
        System.out.println("Cone Surface Area:  " +
                String.format("%.2f", Geometry.coneSurface(r, h)));
    }

}
