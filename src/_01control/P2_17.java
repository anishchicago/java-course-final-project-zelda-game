package _01control;

import java.util.Scanner;

public class P2_17 {

    public static void main(String args[]) {

    /*
    first time = first input
    second time = second input

    first hours = first two letters in first time, cast to integer
    first minutes = last two letters in first time, cast to integer
    second hours = first two letters in second time, cast to integer
    second minutes = last two letters in second time, cast to integer

    if second minutes  > first minutes
        total minutes = second minutes - first minutes
        hours to add = 0
    else if first minutes  > second minutes
        total minutes = second minutes + (60 - first minutes)
        hours to add = -1

    total hours = hours to add + second hours - first hours

    if int (first time) > int (second time)
        total hours += 24

    print total hours and total minutes to console

    */

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the first time: ");
        String firstTime = scan.next();

        System.out.print("Please enter the second time: ");
        String secondTime = scan.next();

        int firstHours = Integer.parseInt(firstTime.substring(0, 2));
        int firstMinutes = Integer.parseInt(firstTime.substring(2));
        int secondHours = Integer.parseInt(secondTime.substring(0, 2));
        int secondMinutes = Integer.parseInt(secondTime.substring(2));

        int totalMinutes = 0;
        int hoursToAdd = 0;

        if (secondMinutes > firstMinutes) {
            totalMinutes = secondMinutes - firstMinutes;
            hoursToAdd = 0;
        } else if (secondMinutes < firstMinutes) {
            totalMinutes = secondMinutes + (60 - firstMinutes);
            hoursToAdd = -1;
        }

        int totalHours = secondHours - firstHours + hoursToAdd;

        if (Integer.parseInt(firstTime) > Integer.parseInt(secondTime)) {
            totalHours += 24;
        }

        System.out.print(totalHours + " hours and " + totalMinutes + " minutes");

    }

}
