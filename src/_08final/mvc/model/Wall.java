package _08final.mvc.model;

import java.awt.*;

public class Wall extends Sprite {

    //private final Image imgWall;

    public Wall(int nPosX, int nPosY, Image imgWall) {
        super(nPosX + imgWall.getWidth(null)/2,nPosY + imgWall.getHeight(null)/2);
        setTeam(Team.PLATFORM);
        //this.imgWall = imgWall;
        setWidth(imgWall.getWidth(null));
        setHeight(imgWall.getHeight(null));
    }

    public Wall(int nPosX, int nPosY, int width, int height) {
        super(nPosX ,nPosY );
        setTeam(Team.PLATFORM);
        setWidth(width);
        setHeight(height);
        //setWidth(imgWall.getWidth(null));
        //setHeight(imgWall.getHeight(null));
    }

    @Override
    public void draw(Graphics g) {

    }

}
