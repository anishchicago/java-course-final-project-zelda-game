package _01control;

import java.util.Scanner;

/*
if input is 1, exit

for integer variable candidate 2 up to input in increments of 1
    create boolean variable isPrime and set to true
    for integer variable divisor 2 up to excluding candidate in increments of 1
        if divisor divides candidate
            set isPrime to false
            break inner loop
    if isPrime is true
        print candidate to console

 */

public class P4_18 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int input = scan.nextInt();

        if (input == 1)
            return;

        for (int candidate = 2; candidate <= input; candidate++) {

            boolean isPrime = true;

            for (int divisor = 2; divisor < candidate; divisor++) {
                if (candidate % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.println(candidate);

        }
    }

}
