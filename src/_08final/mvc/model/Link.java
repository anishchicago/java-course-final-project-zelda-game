package _08final.mvc.model;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents Link
 */
public class Link extends Fighter {

    private static final Map<Direction, FighterImageInfo> directionToImageLinkStill= new HashMap<>();
    static {
        directionToImageLinkStill.put(Direction.RIGHT, 
                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Still_Right.png").getImage()));
        directionToImageLinkStill.put(Direction.LEFT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Still_Left.png").getImage()));
        directionToImageLinkStill.put(Direction.UP, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Still_Up.png").getImage()));
        directionToImageLinkStill.put(Direction.DOWN, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Still_Down.png").getImage()));
    }

    private static final Map<Direction, FighterImageInfo> directionToImageLinkHurt= new HashMap<>();
    static {
        directionToImageLinkHurt.put(Direction.RIGHT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Hurt_Right.png").getImage()));
        directionToImageLinkHurt.put(Direction.LEFT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Hurt_Left.png").getImage()));
        directionToImageLinkHurt.put(Direction.UP, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Hurt_Up.png").getImage()));
        directionToImageLinkHurt.put(Direction.DOWN, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Hurt_Down.png").getImage()));
    }

    private static final Map<Direction, FighterImageInfo[]> directionToImageLinkWalkList= new HashMap<>();
    static {
        directionToImageLinkWalkList.put(Direction.RIGHT,
                new FighterImageInfo[]{
                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Right_6.png").getImage()),
                    new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Right_2.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Right_1.png").getImage()),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Right_3.png").getImage()),
                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Right_5.png").getImage()),
                                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Right_4.png").getImage())});

        directionToImageLinkWalkList.put(Direction.LEFT,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Left_1.png").getImage()),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Left_2.png").getImage()),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Left_3.png").getImage()),
                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Left_4.png").getImage()),
                                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Left_5.png").getImage()),
                                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Left_6.png").getImage())});
        directionToImageLinkWalkList.put(Direction.UP,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Up_1.png").getImage()),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Up_2.png").getImage()),
                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Up_3.png").getImage()),
                                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Up_4.png").getImage()),
                                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Up_5.png").getImage()),
                                                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Up_6.png").getImage())});
        directionToImageLinkWalkList.put(Direction.DOWN,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Down_1.png").getImage()),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Down_2.png").getImage()),
                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Down_3.png").getImage()),
                                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Down_4.png").getImage()),
                                                    new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Down_5.png").getImage()),
                                                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Link_Walk_Down_6.png").getImage())});
        }

    private static final Map<Direction, FighterImageInfo[]> directionToImageLinkAttackList= new HashMap<>();
    static {directionToImageLinkAttackList.put(Direction.RIGHT,
            new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_1.png").getImage(),
                    null,
                    new Ellipse2D.Double(26,0,8,25)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_2.png").getImage(),
                            null,
                            new Ellipse2D.Double(24,0,30,25)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_3.png").getImage(),
                            null,
                            new Ellipse2D.Double(40,10,26,13)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_4.png").getImage(),
                            null,
                            new Ellipse2D.Double(39,23,31,10)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_5.png").getImage(),
                            null,
                            new Ellipse2D.Double(38,33,30,15)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_6.png").getImage(),
                            null,
                            new Ellipse2D.Double(38,33,30,15)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Right_7.png").getImage(),
                            null,
                            new Ellipse2D.Double(2,38,14,26))});
        directionToImageLinkAttackList.put(Direction.LEFT,
                new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_1.png").getImage(),
                        null,
                        new Ellipse2D.Double(0,0,14,25)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,0,23,25)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_3.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,10,27,13)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_4.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,23,27,13)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_5.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,33,24,15)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_6.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,39,21,21)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Left_7.png").getImage(),
                                null,
                                new Ellipse2D.Double(5,39,15,23))});

        directionToImageLinkAttackList.put(Direction.UP,
                new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_1.png").getImage(),
                        null,
                        new Ellipse2D.Double(30,12,20,9)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(27,0,23,22)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_3.png").getImage(),
                                null,
                                new Ellipse2D.Double(21,1,14,32)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_4.png").getImage(),
                                null,
                                new Ellipse2D.Double(7,0,9,35)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_5.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,0,13,34)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_6.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,0,20,20)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_7.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,16,25,14))});
        
        
        
        /*

        directionToImageLinkAttackList.put(Direction.UP,
                new Image[]{new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_1.png",
                                                    new Rectangle(5,18,24,29),
                                                    new Rectangle(30,12,20,9)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_2.png",
                                new Rectangle(5,19,24,31),
                                new Rectangle(27,0,23,17)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_3.png",
                                new Rectangle(5,27,24,35),
                                new Rectangle(21,1,14,32)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_4.png",
                                new Rectangle(5,40,24,25),
                                new Rectangle(7,0,9,19)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_5.png",
                                new Rectangle(12,38,25,22),
                                new Rectangle(0,0,13,34)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_6.png",
                                new Rectangle(26,20,25,30),
                                new Rectangle(0,0,20,20)).getImage(),
                        new ImageIcon(Sprite.strImageDir + "Link_Slash_Up_7.png",
                                new Rectangle(34,19,25,25),
                                new Rectangle(0,16,25,14)).getImage()}); */

        directionToImageLinkAttackList.put(Direction.DOWN,
                new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_1.png").getImage(),
                        null,
                        new Ellipse2D.Double(0,30,24,10)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,41,22,21)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_3.png").getImage(),
                                null,
                                new Ellipse2D.Double(9,53,17,23)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_4.png").getImage(),
                                null,
                                new Ellipse2D.Double(21,55,10,27)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_5.png").getImage(),
                                null,
                                new Ellipse2D.Double(32,46,13,28)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_6.png").getImage(),
                                null,
                                new Ellipse2D.Double(38,41,15,20)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Link_Slash_Down_7.png").getImage(),
                                null,
                                new Ellipse2D.Double(37,28,27,17))});

    }

    public static final Image[] imgLinkDeadList = new Image[]{new ImageIcon(Sprite.strImageDir + "Link_Dead_1.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Link_Dead_2.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Link_Dead_3.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Link_Dead_4.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Link_Dead_5.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Link_Dead_6.png").getImage()};


    public static final int DEFAULT_SPEED = 3; // Pixels per step
    public static final int DEFAULT_STEPS = 6;
    public static final int DEFAULT_ATTACK_STEPS = 7;


    public static final int MAX_HEALTH = 5;



    public Link(int nPosX, int nPosY, Direction facingDirection) {
            super(nPosX,nPosY,facingDirection,DEFAULT_SPEED,DEFAULT_STEPS,DEFAULT_ATTACK_STEPS,MAX_HEALTH,
                directionToImageLinkStill, directionToImageLinkHurt, directionToImageLinkWalkList,directionToImageLinkAttackList, imgLinkDeadList);
        setTeam(Team.FRIEND);
        this.setbVulnerableZoneConstantSize(true);
        this.setbVulnerableZoneEqualsKillZone(false);
    }

    @Override
    public Shape getImgFighterDefaultVulnerableZone() {
        return new Ellipse2D.Double(this.getPos().x + 5, this.getPos().y + 15, 30, 30);
    }

    @Override
    public Shape getImgFighterDefaultKillZone() { return null;
    }


}
