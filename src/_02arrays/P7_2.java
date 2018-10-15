package _02arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class P7_2 {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Enter name of input file: ");

        int counter = 0; // for adding line numbers

        try {
            Scanner fileIn = new Scanner(new File(scanInput.next()));

            Scanner scanOutput = new Scanner(System.in);
            System.out.print("Enter name of output file: ");

            PrintWriter fileOut = new PrintWriter(scanOutput.next());

            while (fileIn.hasNextLine()) {
                counter ++;
                fileOut.println("/* " + counter + " */ " + fileIn.nextLine());
            }

            fileIn.close();
            fileOut.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }


    }

}
