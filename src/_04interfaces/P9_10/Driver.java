package _04interfaces.P9_10;

public class Driver {

    public static void main(String[] args) {
        BetterRectangle testBetterRectangle = new BetterRectangle(0, 0, 3, 4);
        System.out.println("Created testBetterRectangle with width 3, height 4");
        System.out.println("Expected perimeter: " + 2 * (3 + 4));
        System.out.println("Get perimeter method returns " + testBetterRectangle.getPerimeter());
        System.out.println("Expected area: " + 3 * 4);
        System.out.println("Get area method returns " + testBetterRectangle.getArea());

    }

}
