package _08final.mvc.model;

import javax.swing.*;
import java.awt.*;

public class Heart extends Sprite {

    public static Image fullHeart = new ImageIcon(Sprite.strImageDir + "Heart_Full.png").getImage();
    public static Image emptyHeart = new ImageIcon(Sprite.strImageDir + "Heart_Empty.png").getImage();

    private Image heartImage;

    public Heart(int nCenterX, int nCenterY, boolean isFull) {
        super(nCenterX, nCenterY);
        this.heartImage = (isFull ? fullHeart : emptyHeart);
    }
}
