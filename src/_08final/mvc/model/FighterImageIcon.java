package _08final.mvc.model;

import javax.swing.*;
import java.awt.*;

public class FighterImageIcon extends ImageIcon {

    public Shape shapeVulnerableZone;
    public Shape shapeKillZone;

    public FighterImageIcon(String filename) {
        super(filename);
        this.shapeVulnerableZone = new Rectangle(0, 0, super.getImage().getWidth(null), super.getImage().getHeight(null));
        this.shapeKillZone = new Rectangle(0, 0, super.getImage().getWidth(null), super.getImage().getHeight(null));

    }

    public FighterImageIcon(String filename, Shape shapeVulnerableZone, Shape shapeKillZone) {
        super(filename);
        this.shapeVulnerableZone = shapeVulnerableZone;
        this.shapeKillZone = shapeKillZone;
    }

    @Override
    public FighterImage getImage() {
        Image image = super.getImage();
        return new FighterImage(image, shapeVulnerableZone, shapeKillZone);
    }
}
