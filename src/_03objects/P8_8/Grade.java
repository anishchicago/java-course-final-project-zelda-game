package _03objects.P8_8;

/*
 Specify grades as elements of a class Grade. Supply a constructor that constructs a grade from a string,
 such as "B+". You will also need a method that translates grades into their numeric values (for example, "B+" becomes 3.3).
 */

import java.util.HashMap;
import java.util.Map;

public class Grade {

    private static final Map<String, Double> GRADE_INFO;
    static {
        GRADE_INFO = new HashMap<String, Double>() {{
            put("A", 4.0);
            put("A-", 3.7);
            put("B+", 3.3);
            put("B", 3.0);
            put("B-", 2.7);
            put("C+", 2.3);
            put("C", 2.0);
            put("C-", 1.7);
            put("D+", 1.3);
            put("D", 1.0);
            put("F", 0.0);
        }};
    }

    private String gradeString;
    private double gradePoint;

    public Grade(String gradeString) {
        if (GRADE_INFO.containsKey(gradeString)) {
            this.gradeString = gradeString;
            this.gradePoint = GRADE_INFO.get(gradeString);
            System.out.println("Added grade " + gradeString);
        } else {
            System.out.println("Invalid grade!");
        }
    }

    public String getGradeString() {
        return this.gradeString;
    }

    public double getGradePoint() {
        return this.gradePoint;
    }
}
