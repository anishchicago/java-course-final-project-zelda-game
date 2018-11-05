package _05dice.pig;

public class Player {

    private int totalScore;
    private int currentRollScore;

    public Player() {
        this.totalScore = 0;
    }

    public int getScore() {
        return this.totalScore;
    };

    public void addToScore(int points) {
        this.totalScore += points;
    }

    public int getCurrentRollScore() {
        return currentRollScore;
    }

    public void setCurrentRollScore(int currentRollScore) {
        this.currentRollScore = currentRollScore;
    }




}
