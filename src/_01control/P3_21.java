package _01control;

import java.util.Scanner;

/*
• 1 percent on the first $50,000.
• 2 percent on the amount over $50,000 up to $75,000.
• 3 percent on the amount over $75,000 up to $100,000.
• 4 percent on the amount over $100,000 up to $250,000.
• 5 percent on the amount over $250,000 up to $500,000.
• 6 percent on the amount over $500,000.
 */

public class P3_21 {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter income in dollars: ");
        double income = scan.nextDouble();

        // store rates and tiers in arrays
        final double[] RATES = {0.01,0.02,0.03,0.04,0.05,0.06};
        final double[] TIERS = {50000,75000,100000,250000,500000};

        double cumulativeTax;

        if (income <= TIERS[0])
            cumulativeTax = RATES[0] * income;
        else {
            cumulativeTax = RATES[0] * TIERS[0]; // everyone above the first bracket must pay at least this
            for (int i = 1; i < 5; i++) {
                if (income <= TIERS[i]) {
                    cumulativeTax += RATES[i] * (income - TIERS[i - 1]);
                    break;
                }
                else
                    cumulativeTax += RATES[i] * (TIERS[i] - TIERS[i-1]);
            }
        }

        System.out.print("Tax payable: " + cumulativeTax);

    }

}
