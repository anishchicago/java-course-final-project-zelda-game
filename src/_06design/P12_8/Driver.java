package _06design.P12_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/11/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {

    private static Scanner sScanner = new Scanner(System.in);


    public static void main(String[] args) {
        VendMachine vndMachine = new VendMachine();
        standardRestock(vndMachine);

        outer:
        while (true) {

            System.out.println("Type 'i' for insert coins or 's' for select product or type 'exit' to quit");
            System.out.println("Or, type 'o' if you are an operator");
            String strInitial = sScanner.nextLine();
            strInitial = strInitial.toUpperCase();
            String strMoney, strSelect;
            switch (strInitial){
                case "O":
                    System.out.println("Type 'e' to empty coins or 'r' to restock");
                    Scanner adminInput = new Scanner(System.in);
                    String adminCommand = adminInput.nextLine().toUpperCase();
                    switch (adminCommand)   {
                        case "E":
                            List<Coin> conCashOuts = vndMachine.cashOut();
                            System.out.println("Jackpot!");
                            for (Coin conCashOut : conCashOuts) {
                                System.out.println(conCashOut);
                            }
                            break;
                        case "R":
                            standardRestock(vndMachine);
                            break;
                    }
                    break;
                case "I":
                    strMoney = addMoney();
                    if (strMoney.equals("X")) break;
                    vndMachine.insertCoins(strMoney);
                    System.out.println("Credits : " + vndMachine.howMuchInserted());
                  break;
                case "S":
                    System.out.println(vndMachine.showSelection());
                    strSelect = makeSelection();
                    strMoney = addMoney();
                    if (!strMoney.equals("X")) {
                        vndMachine.insertCoins(strMoney);
                        System.out.println("Credits : " + vndMachine.howMuchInserted());
                    }
                    Product prdProduct = vndMachine.vend(strSelect);
                    if (prdProduct != null)
                        System.out.println("Thank you and Enjoy: " + prdProduct);
                    else {
                        System.out.print("You inserted " + vndMachine.howMuchInserted() + " : Insufficient coins or out of stock");
                        List<Coin> conReturns = vndMachine.returnCoins();
                        System.out.println(", here is your money back: ");
                        for (Coin conReturn : conReturns) {
                            System.out.println(conReturn);
                        }

                    }
                  break;
                case "EXIT":
                    break outer;
                default:
                  break;
            }

        }
        System.out.println("Thank you for vending");

    }

    private static String addMoney(){

        System.out.println("Insert Coins like so: q q d d n, or x to skip");
        return sScanner.nextLine().toUpperCase();

    }

    private static String makeSelection(){
        System.out.println("Please choose a product such as 'A2'");
        return sScanner.nextLine().toUpperCase();

    }

    private static void standardRestock(VendMachine vndMachine){
        List<Product> prdProducts = new ArrayList<>();
        prdProducts.add(new Product("Heath", 0.75, 5));
        prdProducts.add(new Product("PayDay", 0.75, 5));
        prdProducts.add(new Product("Reces", 0.75, 5));
        prdProducts.add(new Product("Pop Tart", 1.25, 5));
        prdProducts.add(new Product("Marathon", 0.75, 5));
        prdProducts.add(new Product("Almond Joy", 0.75, 5));
        prdProducts.add(new Product("Hersheys", 0.75, 5));
        prdProducts.add(new Product("Hersheys Dark", 0.75, 5));
        prdProducts.add(new Product("Twizzlers", 0.50, 5));
        vndMachine.stockMe(prdProducts);
        System.out.println("Restocked!");
    }


}
