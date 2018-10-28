package _04interfaces.P9_16;

public class Driver {

    public static void main(String[] args) {
        // using example countries from Big Java p 451

        Measurable[] countries = new Measurable[3];
        countries[0] = new Country("Uruguay", 176220);
        System.out.println("Added to the array: " + countries[0]);
        countries[1] = new Country("Thailand", 514000);
        System.out.println("Added to the array: " + countries[1]);
        countries[2] = new Country("Belgium", 30510);
        System.out.println("Added to the array: " + countries[2]);

        System.out.println();

        System.out.println("Max area belongs to: " +
                Measurable.maximum(countries));

    }


}
