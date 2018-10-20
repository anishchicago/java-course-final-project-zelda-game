package _03objects.P8_5;

public class Driver {

    public static void main(String[] args) {

        SodaCan testCan1 = new SodaCan(2, 3);

        SodaCan testCan2 = new SodaCan(5,6);

        System.out.println("testCan1 has height " + testCan1.getHeight()
                            + " and radius " + testCan1.getRadius());

        System.out.println("testCan1 has surface area " + String.format("%.2f",testCan1.getSurfaceArea())
                + " and volume " + String.format("%.2f",testCan1.getVolume()));
        System.out.println();

        System.out.println("testCan2 has height " + testCan2.getHeight()
                + " and radius " + testCan2.getRadius());

        System.out.println("testCan2 has surface area " + String.format("%.2f",testCan2.getSurfaceArea())
                + " and volume " + String.format("%.2f",testCan2.getVolume()));


    }
}
