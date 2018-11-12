package _04interfaces.R9_14;

import java.awt.*;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        Sandwich sub = new Sandwich();
        Rectangle cerealBox = new Rectangle(5,10,20,30);
        Edible e = new Edible();

        //e = sub;
        //sub = (Sandwich) e;
        //e = (Edible) cerealBox; // class cast exception

        String s = "Tea";
        s = "Coffee";

        int n = 7;
        Integer intMe = new Integer(7);
        if(n == intMe) System.out.println("TRUE");;

    }

}
