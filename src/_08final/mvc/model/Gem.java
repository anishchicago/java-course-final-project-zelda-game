package _08final.mvc.model;

import java.awt.*;

/**
 * Created by John on 5/24/2016.
 */
public abstract class Gem extends Sprite {

    private final Image imgGem;

    private int value;

    public Gem(int nCenterX, int nCenterY, Image imgGem, int value){
        super(nCenterX,nCenterY);
        setTeam(Team.FRIEND);
        this.imgGem = imgGem;
        this.value = value;
        setWidth(imgGem.getWidth(null));
        setHeight(imgGem.getHeight(null));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(imgGem, getPos().x, getPos().y,null);
    }


}
