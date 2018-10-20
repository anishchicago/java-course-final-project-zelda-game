package _03objects.P8_4;

public class Driver {

    public static void main(String[] args) {

        Address testAddressWithAptNumber = new Address(222, "N Columbus Dr",
                "Chicago", "IL", 60601, 310);

        Address testAddressWithNoAptNumber = new Address(151, "N Michigan Ave",
                "Chicago", "IL", 60602);

        System.out.println("testAddressWithAptNumber:");
        testAddressWithAptNumber.print();

        System.out.println("testAddressWithNoAptNumber:");
        testAddressWithNoAptNumber.print();

        System.out.println();

        if (testAddressWithAptNumber.comesBefore(testAddressWithNoAptNumber)) {
            testAddressWithAptNumber.print();
            System.out.println("comes before");
            testAddressWithNoAptNumber.print();
        }
    }

}
