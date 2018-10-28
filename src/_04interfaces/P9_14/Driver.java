package _04interfaces.P9_14;

public class Driver {

    public static void main(String[] args) {

        SodaCan testCan1 = new SodaCan(2, 3);
        System.out.println("testCan1 has surface area " + String.format("%.2f",testCan1.getMeasure()));
        SodaCan testCan2 = new SodaCan(4, 5);
        System.out.println("testCan2 has surface area " + String.format("%.2f",testCan2.getMeasure()));
        SodaCan testCan3 = new SodaCan(6, 7);
        System.out.println("testCan3 has surface area " + String.format("%.2f",testCan3.getMeasure()));
        SodaCan[] arrayOfCans = new SodaCan[]{testCan1,testCan2,testCan3};
        System.out.println("Average surface area: " + String.format("%.2f",Measurable.average(arrayOfCans)));


    }

}
