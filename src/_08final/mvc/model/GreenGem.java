package _08final.mvc.model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by John on 5/24/2016.
 */
public class GreenGem extends Gem {

    private static final Image imgGreenGem = new ImageIcon(Sprite.strImageDir + "Green_Gem.png").getImage();
    public static final int GEM_WORTH = 100;

    public GreenGem(int nCenterX, int nCenterY){
        super(nCenterX,nCenterY, imgGreenGem, GEM_WORTH);
        setTeam(Team.FRIEND);
    }

}
