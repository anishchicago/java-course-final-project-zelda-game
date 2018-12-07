package _08final.mvc.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents Octorok enemy
 */
public class Octorok extends Fighter {

    private static final Map<Direction, FighterImageInfo> directionToImageOctorokStill= new HashMap<>();
    static {
        directionToImageOctorokStill.put(Direction.RIGHT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Still_Right.png").getImage()));
        directionToImageOctorokStill.put(Direction.LEFT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Still_Left.png").getImage()));
        directionToImageOctorokStill.put(Direction.UP, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Still_Up.png").getImage()));
        directionToImageOctorokStill.put(Direction.DOWN, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Still_Down.png").getImage()));
    }

    private static final Map<Direction, FighterImageInfo> directionToImageOctorokHurt= new HashMap<>();
    static {
        directionToImageOctorokHurt.put(Direction.RIGHT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Hurt_Right.png").getImage()));
        directionToImageOctorokHurt.put(Direction.LEFT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Hurt_Left.png").getImage()));
        directionToImageOctorokHurt.put(Direction.UP, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Hurt_Up.png").getImage()));
        directionToImageOctorokHurt.put(Direction.DOWN, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Still_Down.png").getImage()));
    }

    private static final Map<Direction, FighterImageInfo[]> directionToImageOctorokWalkList= new HashMap<>();
    static {
        directionToImageOctorokWalkList.put(Direction.RIGHT,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Right_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Right_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Right_2.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Right_2.png").getImage())});

        directionToImageOctorokWalkList.put(Direction.LEFT,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Left_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Left_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Left_2.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Left_2.png").getImage())});
        directionToImageOctorokWalkList.put(Direction.UP,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Up_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Up_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Up_2.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Up_2.png").getImage())});
        directionToImageOctorokWalkList.put(Direction.DOWN,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Down_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Down_1.png").getImage()),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Down_2.png").getImage()),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Octorok_Walk_Down_2.png").getImage())});
    }

        /*



        directionToImageOctorokAttackList.put(Direction.UP,
                new Image[]{new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_1.png",
                                                    new Rectangle(5,18,24,29),
                                                    new Rectangle(30,12,20,9)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_2.png",
                                new Rectangle(5,19,24,31),
                                new Rectangle(27,0,23,17)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_3.png",
                                new Rectangle(5,27,24,35),
                                new Rectangle(21,1,14,32)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_4.png",
                                new Rectangle(5,40,24,25),
                                new Rectangle(7,0,9,19)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_5.png",
                                new Rectangle(12,38,25,22),
                                new Rectangle(0,0,13,34)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_6.png",
                                new Rectangle(26,20,25,30),
                                new Rectangle(0,0,20,20)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Octorok_Slash_Up_7.png",
                                new Rectangle(34,19,25,25),
                                new Rectangle(0,16,25,14)).getImage()}); */



    public static final Image[] imgOctorokDeadList = new Image[]{new ImageIcon(Sprite.strImageDir + "Enemy_Dead_1.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Enemy_Dead_2.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Enemy_Dead_3.png").getImage()};



    //private int nDeltaY = -4; // Delta during Octorok Spawn to ensure Octorok comes out of pipe slowly
    public static final int DEFAULT_DESCEND_SPEED = +0; // Pixels per frame

    public static final int DEFAULT_SPEED = 1; // Pixels per step
    public static final int DEFAULT_STEPS = 4;
    public static final int DEFAULT_ATTACK_STEPS = 8;

    public static final int SCREEN_LEFT_LIMIT = 150;
    public static final int SCREEN_RIGHT_LIMIT = 700;

    public static final int MAX_HEALTH = 1;

    public Octorok(int nCenterX, int nCenterY, Direction facingDirection) {
        super(nCenterX,nCenterY,facingDirection,DEFAULT_SPEED,DEFAULT_STEPS,DEFAULT_ATTACK_STEPS,MAX_HEALTH,
                directionToImageOctorokStill, directionToImageOctorokHurt, directionToImageOctorokWalkList,directionToImageOctorokWalkList, imgOctorokDeadList);
        setTeam(Team.FOE);
        this.setbVulnerableZoneConstantSize(true);
        this.setbVulnerableZoneEqualsKillZone(true);
    }

    @Override
    public Shape getImgFighterDefaultVulnerableZone() {
        return new Ellipse2D.Double(this.getPos().x, this.getPos().y, 30, 30);
    }

    @Override
    public Shape getImgFighterDefaultKillZone() {
        return getImgFighterDefaultVulnerableZone();
    }

    public void justInflictedDamage() {
        this.paralyze(30);
    }

    public void attack() {

    }

}
