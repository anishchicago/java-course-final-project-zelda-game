package _03objects.P8_8;

public class Driver {
    public static void main(String[] args) {


        Student test1 = new Student("Bob");

        System.out.println("GPA " + String.format("%.2f",test1.getGPA()));
        test1.addGrade("A");
        System.out.println("GPA " + String.format("%.2f",test1.getGPA()));

        test1.addGrade("B+");
        System.out.println("GPA " + String.format("%.2f",test1.getGPA()));

        test1.addGrade("C");
        System.out.println("GPA " + String.format("%.2f",test1.getGPA()));

    }

}
