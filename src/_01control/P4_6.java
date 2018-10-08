package _01control;

import java.util.Scanner;

// the problem with this program is that the scanner keeps looking for new input
// frankly this problem is true in the book examples also (page 203)

public class P4_6 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Input integers separated by spaces: ");

        int minimum = 0;
        boolean first = true;
        int nextInt;

        while (scan.hasNextLine()) {
            nextInt = scan.nextInt();
            if (first) {
                minimum = nextInt;
                first = false;
            } else if (nextInt < minimum) {
                minimum = nextInt;
            }

        }
        System.out.println(minimum);

    }

}
