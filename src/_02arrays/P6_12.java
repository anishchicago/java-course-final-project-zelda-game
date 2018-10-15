package _02arrays;

public class P6_12 {
    public static void main(String[] args) {

        int values[] = new int[20];

        for (int j = 0; j < values.length; j++) {
            values[j] = (int) (Math.random() * 6) + 1;
        }

        /*
        Set a boolean variable inRun to false.
        For each valid index i in the array
            If inRun
                If values[i] is different from the preceding value
                    Print ).
                    inRun = false.
            If not inRun
                If values[i] is the same as the following value Print (.
                    inRun = true.
            Print values[i].
        If inRun, print ).
         */

        boolean inRun = false;
        for (int i = 0; i < values.length; i++) {
            if (inRun) {
                if (values[i] != values[i - 1]) {
                    System.out.print(") ");
                    inRun = false;
                }
            }
            if (!inRun) {
                if (i < values.length - 1) {
                    if (values[i] == values[i + 1]) {
                        System.out.print(" (");
                        inRun = true;
                    }
                }
            }
            System.out.print(" " + values[i] + " ");
        }

        if (inRun)
            System.out.print(")");
    }
}
