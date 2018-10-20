package _03objects.P8_6;

public class Driver {

    public static void main(String[] args) {

        Car testCar1 = new Car(50);
        Car testCar2 = new Car(25);

        System.out.println("testCar1: " + testCar1.toString());
        System.out.println("testCar2: " + testCar2.toString());

        testCar1.addGas(10);
        testCar2.addGas(10);

        System.out.println("testCar1: " + testCar1.toString());
        System.out.println("testCar2: " + testCar2.toString());

        testCar1.drive(500);
        testCar2.drive(500);

        System.out.println("testCar1: " + testCar1.toString());
        System.out.println("testCar2: " + testCar2.toString());

    }


}
