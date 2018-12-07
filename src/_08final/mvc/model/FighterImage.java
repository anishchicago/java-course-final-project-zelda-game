package _08final.mvc.model;


import sun.awt.image.ToolkitImage;

import java.awt.*;

public class FighterImage extends ToolkitImage {


    public Shape shapeVulnerableZone;
    public Shape shapeKillZone;

    public FighterImage(Image image) {
        super(image.getSource());
        this.shapeVulnerableZone = new Rectangle(0, 0, image.getWidth(null), image.getHeight(null));
        this.shapeKillZone = new Rectangle(0, 0, image.getWidth(null), image.getHeight(null));
    }

    public FighterImage(Image image, Shape shapeVulnerableZone, Shape shapeKillZone) {
        super(image.getSource());
        this.shapeVulnerableZone = shapeVulnerableZone;
        this.shapeKillZone = shapeKillZone;
    }

    public Shape getShapeVulnerableZone() {
        return shapeVulnerableZone;
    }

    public void setShapeVulnerableZone(Shape shapeVulnerableZone) {
        this.shapeVulnerableZone = shapeVulnerableZone;
    }

    public Shape getShapeKillZone() {
        return shapeKillZone;
    }

    public void setRectKillZone(Shape shapeKillZone) {
        this.shapeKillZone = shapeKillZone;
    }

    /*

    public FighterImageIcon(Image image, int vulnerableZoneX1, int vulnerableZoneY1,
                            int vulnerableZoneX2, int vulnerableZoneY2) {
        super(image);
        this.rectVulnerableZone = new Rectangle(vulnerableZoneX1, vulnerableZoneY1,
                vulnerableZoneX2 - vulnerableZoneX1, vulnerableZoneY2 - vulnerableZoneY1);
        this.rectKillZone = null;
    }


    public FighterImageIcon(Image image, int vulnerableZoneX1, int vulnerableZoneY1,
                            int vulnerableZoneX2, int vulnerableZoneY2,
                            int killZoneX1, int killZoneY1, int killZoneX2, int killZoneY2) {
        super(image);
        this.rectVulnerableZone = new Rectangle(vulnerableZoneX1, vulnerableZoneY1,
                vulnerableZoneX2 - vulnerableZoneX1, vulnerableZoneY2 - vulnerableZoneY1);
        this.rectKillZone = new Rectangle(killZoneX1, killZoneY1,
                killZoneX2 - killZoneX1, killZoneY2 - killZoneY1);
        ImageIcon me = new ImageIcon();

    }

    */



}
