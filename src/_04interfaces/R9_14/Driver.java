package _04interfaces.R9_14;

import java.awt.*;

public class Driver {

    public static void main(String[] args) {
        Sandwich sub = new Sandwich();
        Rectangle cerealBox = new Rectangle(5,10,20,30);
        Edible e = null;

        //e = sub;
        //sub = (Sandwich) e;
        e = (Edible) cerealBox;

    }

}
