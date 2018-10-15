package _02arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class P7_17 {

    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);
        System.out.print("Enter name of input file: ");

        try {

            Scanner fileIn = new Scanner(new File(scanInput.next()));
            ArrayList<String> categories = new ArrayList<>(); // for tracking categories

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                String[] values = line.split(";");

                if (values.length != 4) {
                    System.out.println("Input file format incorrect.");
                    System.exit(0);
                }

                FileWriter fileOut = new FileWriter(values[1] + ".txt", true);
                fileOut.append(line + "\n");
                fileOut.close();

                // add to running list of categories if not already there
                if (!categories.contains(values[1])) {
                    categories.add(values[1]);
                }
            }

            fileIn.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }


    }

}
