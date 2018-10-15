package _02arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class P6_25 {

    public static void main(String[] args) {

        ArrayList<String> captions = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        double maxValue = 0;
        int maxCaptionLength = 0;

        while (true) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a caption and value separated by space (f to finish): ");
            String caption = scan.next();

            if(caption.equalsIgnoreCase("f"))
                break;

            captions.add(caption);

            // track max size of the caption strings for padding later
            if (caption.length() > maxCaptionLength) {
                maxCaptionLength = caption.length();
            }

            double value = scan.nextDouble();

            values.add(value);

            // track max values to be normalized later
            if (value > maxValue) {
                maxValue = value;
            }

        }

        // print to console
        for (int i = 0; i < captions.size(); i++) {

            int barSize = (int) Math.round(values.get(i) / maxValue * 40);

            // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java
            String bar = new String(new char[barSize]).replace("\0", "*");

            System.out.println(String.format("%1$" + maxCaptionLength + "s %2$1s", captions.get(i), bar));

        }

    }

}
