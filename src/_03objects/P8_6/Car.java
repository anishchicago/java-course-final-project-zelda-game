package _03objects.P8_6;

// Implement a class Car with the following properties.
// A car has a certain fuel efficiency (measured in miles/gallon) and a certain amount of fuel in the gas tank.
// The efficiency is specified in the constructor, and the initial fuel level is 0.
// Supply a method drive that simulates driving the
// car for a certain distance, reducing the fuel level in the gas tank, and methods getGas-Level,
// to return the current fuel level, and addGas, to tank up.
//


public class Car {

    private double efficiency;
    private double gasLevel = 0;

    public Car(double efficiency) {
        this.efficiency = efficiency;
        this.gasLevel = 0;
    }

    public void drive(double distance) {

        double gasNeeded = distance / this.efficiency;

        if (gasNeeded > this.gasLevel) {
            System.out.println("Not enough gas in tank!");
        } else {
            this.gasLevel -= gasNeeded;
        }

    }

    public double getGasLevel() {
        return gasLevel;
    }

    public void addGas(double gasToAdd) {
        this.gasLevel += gasToAdd;
    }

    public String toString() {
        return "Efficiency: " + String.format("%.2f",this.efficiency) +
                "; Gas Level: " + String.format("%.2f",this.gasLevel);
    }

}
