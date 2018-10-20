package _03objects.P8_15;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // NOTE: computes sphere stats first using radius only,
        // then prompts user for height for the other shapes.

        Scanner scanR = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = scanR.nextDouble();

        Sphere mySphere = new Sphere(r);
        System.out.println("Sphere Volume: " +
                String.format("%.2f", mySphere.getVolume(r)));
        System.out.println("Sphere Surface Area: " +
                String.format("%.2f", mySphere.getSurface(r)));

        Scanner scanH = new Scanner(System.in);
        System.out.print("Enter height: ");
        double h = scanH.nextDouble();

        Cylinder myCylinder = new Cylinder(r, h);

        System.out.println("Cylinder Volume:  " +
                String.format("%.2f", myCylinder.getVolume(r, h)));
        System.out.println("Cylinder Surface Area:  " +
                String.format("%.2f", myCylinder.getSurface(r, h)));

        Cone myCone = new Cone(r, h);

        System.out.println("Cone Volume:  " +
                String.format("%.2f", myCone.getVolume(r, h)));
        System.out.println("Cone Surface Area:  " +
                String.format("%.2f", myCone.getSurface(r, h)));
    }

}
