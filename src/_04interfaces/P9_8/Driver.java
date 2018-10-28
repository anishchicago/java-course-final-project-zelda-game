package _04interfaces.P9_8;

public class Driver {

    public static void main(String[] args) {

        Person testPerson = new Person("Anish", 1991);
        System.out.println(testPerson.toString());

        Student testStudent = new Student("Bob", 1992, "Economics");
        System.out.println(testStudent.toString());

        Instructor testInstructor = new Instructor("Mary", 1980, 100000);
        System.out.println(testInstructor.toString());

    }

}
