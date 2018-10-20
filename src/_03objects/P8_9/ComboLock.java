package _03objects.P8_9;

public class ComboLock {

    private static int TOTAL_TICKS = 40;
    private int secret1;
    private int secret2;
    private int secret3;
    private boolean isCorrectSoFar = true;
    private int turnCount = 0;
    private int position = 0;

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        System.out.println("Created new combo: " + secret1 + " " + secret2 + " " + secret3);
    }

    public void reset() {
        this.position = 0;
        this.turnCount = 0;
        this.isCorrectSoFar = true;
    }

    public void turnLeft(int ticks) {
        turnCount ++;
        position += TOTAL_TICKS - ticks;
        if (position >= TOTAL_TICKS) position -= TOTAL_TICKS;
        System.out.println("Turned left " + ticks);
        System.out.println("Lock is now at position number " + position);
        if (!(this.turnCount == 1 && position == secret1) &&
            !(this.turnCount == 3 && position == secret3)) {
            isCorrectSoFar = false;
        }
    }

    public void turnRight(int ticks) {
        turnCount ++;
        position += ticks;
        if (position >= TOTAL_TICKS) position -= TOTAL_TICKS;
        System.out.println("Turned right " + ticks);
        System.out.println("Lock is now at position number " + position);
        if (!(this.turnCount == 2 && position == secret2)) {
            isCorrectSoFar = false;
        }

    }
    public boolean open() {

        if (isCorrectSoFar && turnCount == 3)
            return true;
        return false;
    }
}
