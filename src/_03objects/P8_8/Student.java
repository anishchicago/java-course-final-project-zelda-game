package _03objects.P8_8;

import java.util.ArrayList;

/*
Implement a class Student. For the purpose of this exercise, a student has a name and a total quiz score.
Supply an appropriate constructor and methods getName(), addQuiz(int­score), getTotalScore(), and getAverageScore().
To compute the latter, you also need to store the number of quizzes that the student took.
Modify the Student class of Exercise P8.7 to compute grade point averages
 Methods are needed to add a grade and get the current GPA.

*/
public class Student {

    private String name;
    private int totalScore = 0;
    private int numQuizzes = 0;
    private ArrayList<Grade> grades = new ArrayList<Grade>();

    public Student(String name) {
        this.name = name;
        System.out.println("Student with name " + name + " created." );
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public double getAverageScore() {

        if (numQuizzes == 0) {
            System.out.println("No quizzes taken!");
            return 0;
        }

        return totalScore / numQuizzes;
    }

    public void addQuiz(int score) {
        this.numQuizzes ++;
        this.totalScore += score;
    }

    public void addGrade(String gradeString) {
        Grade grade = new Grade(gradeString);
        grades.add(grade);
    }

    public double getGPA() {
        int numGrades = grades.size();
        if (numGrades == 0) {
            return 0;
        }

        double totalPoints = 0;
        for (Grade grade : grades) {
            totalPoints += grade.getGradePoint();
        }
        return totalPoints / numGrades;
    }

}
