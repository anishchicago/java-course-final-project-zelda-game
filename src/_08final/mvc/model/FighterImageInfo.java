package _08final.mvc.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class FighterImageInfo {

    private Image imgFighter;
    private Shape shapeImgVulnerableZone;
    private Shape shapeImgKillZone;

    public FighterImageInfo(Image imgFighter) {
        this.imgFighter = imgFighter;
        this.shapeImgVulnerableZone = new Ellipse2D.Double(0, 0, imgFighter.getWidth(null),
                imgFighter.getHeight(null));
        this.shapeImgKillZone = null;
    }

    public FighterImageInfo(Image imgFighter,
                            Shape shapeImgVulnerableZone, Shape shapeImgKillZone) {
        this.imgFighter = imgFighter;
        this.shapeImgVulnerableZone = shapeImgVulnerableZone;
        this.shapeImgKillZone = shapeImgKillZone;
    }

    public FighterImageInfo(Image imgFighter,
                            boolean defaultFoeConfig) {
        this.imgFighter = imgFighter;
        if (defaultFoeConfig) {
            this.shapeImgVulnerableZone = new Ellipse2D.Double(0, 0,
                    imgFighter.getWidth(null), imgFighter.getHeight(null));
            this.shapeImgKillZone = shapeImgVulnerableZone;
        }
    }



    public Image getImgFighter() {
        return imgFighter;
    }

    public Shape getShapeImgVulnerableZone() {
        if (shapeImgVulnerableZone == null) return null;
        else return shapeImgVulnerableZone.getBounds();
    }

    public Shape getShapeImgKillZone() {
        if (shapeImgKillZone == null) return null;
        else return shapeImgKillZone.getBounds();
    }

}
