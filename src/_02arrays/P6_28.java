package _02arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class P6_28 {

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        Scanner scanA = new Scanner(System.in);
        System.out.print("ArrayList a (integers separated by spaces, terminated with 'q'): ");
        while (scanA.hasNextInt()) {
            a.add(scanA.nextInt());
        }

        Scanner scanB = new Scanner(System.in);
        System.out.print("ArrayList b (integers separated by spaces, terminated with 'q'): ");
        while (scanB.hasNextInt()) {
            b.add(scanB.nextInt());
        }

        System.out.println(mergeSorted(a, b));

    }


    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> merged = new ArrayList<>();

        // need to append large sentinel values for this to work
        a.add(Integer.MAX_VALUE);
        b.add(Integer.MAX_VALUE);

        // counters for a and b indices respectively
        int i = 0;
        int j = 0;

        // we will be done when num iterations equals the sum of the two original sizes
        for (int m = 0; m < a.size() + b.size() - 2; m++) {

            int aVal = a.get(i);
            int bVal = b.get(j);

            if (aVal <= bVal) {
                merged.add(aVal);
                i++;
            } else {
                merged.add(bVal);
                j++;
            }
        }

        return merged;

    }

}
