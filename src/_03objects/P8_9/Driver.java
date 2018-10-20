package _03objects.P8_9;

public class Driver {

    public static void main(String[] args) {

        ComboLock testLock1 = new ComboLock(39,1,39);

        testLock1.turnLeft(1 );
        testLock1.turnRight(2 );
        testLock1.turnLeft(2 );

        if (testLock1.open())
            System.out.println("Unlocked!");
        else
            System.out.println("Didn't open!");

        System.out.println();
        ComboLock testLock2 = new ComboLock(39,1,39);

        testLock2.turnLeft(1 );
        testLock2.turnRight(5 );
        testLock2.turnLeft(3 );

        if (testLock2.open())
            System.out.println("Unlocked!");
        else
            System.out.println("Didn't open!");

    }

}
