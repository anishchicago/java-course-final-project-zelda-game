package _04interfaces.P9_23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        final String FILE_NAME = "appointments.txt";
        final String ONE_TIME_STRING = "OneTime";
        final String MONTHLY_STRING = "Monthly";
        final String DAILY_STRING = "Daily";


        LocalDate currentDate = LocalDate.now();
        final int DAY = currentDate.getDayOfMonth();
        final int MONTH = currentDate.getMonth().getValue();
        final int YEAR = currentDate.getYear();

        while (true) {

            Scanner scan0 = new Scanner(System.in);
            System.out.print("Enter an appointment type " +
                    "(OneTime, Daily or Monthly) or \"q\" when done inputting appointments: ");
            String appType = scan0.next();
            if(appType.equalsIgnoreCase("q"))
                break;

            if(!(appType.equalsIgnoreCase(ONE_TIME_STRING) ||
                    appType.equalsIgnoreCase(MONTHLY_STRING) ||
                    appType.equalsIgnoreCase(DAILY_STRING))) {
                System.out.println("Try again. Valid appointment types: OneTime, Daily, Monthly");
                continue;
            }

            Scanner scan1 = new Scanner(System.in);
            System.out.print("Enter a description: ");
            String description = scan1.nextLine();

            if (appType.equalsIgnoreCase(ONE_TIME_STRING)) {

                System.out.print("Enter a year: ");
                Scanner scan2 = new Scanner(System.in);
                int year = scan2.nextInt();
                System.out.print("Enter a month: ");
                Scanner scan3 = new Scanner(System.in);
                int month = scan3.nextInt();
                System.out.print("Enter a day: ");
                Scanner scan4 = new Scanner(System.in);
                int day = scan4.nextInt();

                Date date = new Date(year, month, day);

                OneTime oneTimeAppointment = new OneTime(description, date);
                oneTimeAppointment.save(FILE_NAME);

            } else if (appType.equalsIgnoreCase(MONTHLY_STRING)) {

                System.out.print("Enter a day: ");
                Scanner scan4 = new Scanner(System.in);
                int day = scan4.nextInt();

                Date date = new Date(YEAR, MONTH, day);

                Monthly monthlyAppointment = new Monthly(description, date);
                monthlyAppointment.save(FILE_NAME);

            } else if (appType.equalsIgnoreCase(DAILY_STRING)) {

                Date date = new Date(YEAR, MONTH, DAY);

                Daily dailyAppointment = new Daily(description, date);
                dailyAppointment.save(FILE_NAME);

            }

        }

        System.out.println();

        while (true) {
            Scanner scan0 = new Scanner(System.in);
            System.out.print("Check your appointments on a certain day. Enter a year (or 0 to quit): ");
            int year = scan0.nextInt();
            if (year == 0)
                break;
            System.out.print("Enter a month: ");
            Scanner scan1 = new Scanner(System.in);
            int month = scan1.nextInt();
            System.out.print("Enter a day: ");
            Scanner scan2 = new Scanner(System.in);
            int day = scan2.nextInt();

            ArrayList<Appointment> appointments =  load(FILE_NAME);

            System.out.println("The following appointments occur on that day:");

            for (Appointment appointment : appointments) {
                if (appointment.occursOn(year, month, day)) {
                    System.out.println(appointment.getDescription());
                }
            }

        }

    }

    public static ArrayList<Appointment> load(String fileName) {

        ArrayList<Appointment> appointments = new ArrayList<>();

        try {

            Scanner fileIn = new Scanner(new File(fileName));
            System.out.println("Reading from file " + fileName + "...");
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                String[] values = line.split(";");

                if (values.length != 3) {
                    System.out.println("Input file format incorrect.");
                    System.exit(0);
                }

                String description = values[1];
                String[] dateInts = values[2].split("/");
                Date date = new Date(Integer.parseInt(dateInts[2]),
                                    Integer.parseInt(dateInts[0]),
                                    Integer.parseInt(dateInts[1]));
                switch (values[0]) {
                    case "ONE_TIME":
                        appointments.add(new OneTime(description,date));
                        break;
                    case "MONTHLY":
                        appointments.add(new Monthly(description,date));
                        break;
                    case "DAILY":
                        appointments.add(new Daily(description,date));
                        break;
                }

            }

            fileIn.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        return appointments;
    }

}

