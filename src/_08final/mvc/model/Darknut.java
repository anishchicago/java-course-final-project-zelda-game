package _08final.mvc.model;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents Darknut
 */
public class Darknut extends Fighter {

    private static final Map<Direction, FighterImageInfo> directionToImageDarknutStill= new HashMap<>();
    static {
        directionToImageDarknutStill.put(Direction.RIGHT, 
                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Still_Right.png").getImage()));
        directionToImageDarknutStill.put(Direction.LEFT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Still_Left.png").getImage()));
        directionToImageDarknutStill.put(Direction.UP, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Still_Up.png").getImage()));
        directionToImageDarknutStill.put(Direction.DOWN, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Still_Down.png").getImage()));
    }

    private static final Map<Direction, FighterImageInfo> directionToImageDarknutHurt= new HashMap<>();
    static {
        directionToImageDarknutHurt.put(Direction.RIGHT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Hurt_Right.png").getImage()));
        directionToImageDarknutHurt.put(Direction.LEFT, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Hurt_Left.png").getImage()));
        directionToImageDarknutHurt.put(Direction.UP, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Hurt_Up.png").getImage()));
        directionToImageDarknutHurt.put(Direction.DOWN, new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Hurt_Down.png").getImage()));
    }

    private static final Map<Direction, FighterImageInfo[]> directionToImageDarknutWalkList= new HashMap<>();
    static {
        directionToImageDarknutWalkList.put(Direction.RIGHT,
                new FighterImageInfo[]{
                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_1.png").getImage(),
                        null, new Ellipse2D.Double(54,37,71,28)),
                    new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_1.png").getImage(),
                            null, new Ellipse2D.Double(54,37,71,28)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_1.png").getImage(),
                                null, new Ellipse2D.Double(54,37,71,28)),
                                new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_1.png").getImage(),
                                        null, new Ellipse2D.Double(54,37,71,28)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_2.png").getImage(),
                                null, new Ellipse2D.Double(54,37,71,28)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_2.png").getImage(),
                                null, new Ellipse2D.Double(54,37,71,28)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_2.png").getImage(),
                                null, new Ellipse2D.Double(54,37,71,28)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Right_2.png").getImage(),
                                null, new Ellipse2D.Double(54,37,71,28))});

        directionToImageDarknutWalkList.put(Direction.LEFT,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Left_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45))});

        directionToImageDarknutWalkList.put(Direction.UP,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 )),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Up_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 ))});

        directionToImageDarknutWalkList.put(Direction.DOWN,
                new FighterImageInfo[]{
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_1.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),

                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo( new ImageIcon(Sprite.strImageDir + "Darknut_Walk_Down_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60))});
    }

    private static final Map<Direction, FighterImageInfo[]> directionToImageDarknutAttackList= new HashMap<>();
    static {directionToImageDarknutAttackList.put(Direction.RIGHT,
            new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Right_1.png").getImage(),
                    null,
                    null),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Right_2.png").getImage(),
                            null,
                            null),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Right_3.png").getImage(),
                            null,
                            new Ellipse2D.Double(72,0,38,55)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Right_4.png").getImage(),
                            null,
                            new Ellipse2D.Double(46,44,56,31)),
                    new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Right_5.png").getImage(),
                            null,
                            new Ellipse2D.Double(54,37,71,28))});
        directionToImageDarknutAttackList.put(Direction.LEFT,
                new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Left_1.png").getImage(),
                        null,
                        null),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Left_2.png").getImage(),
                                null,
                                null),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Left_3.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,13,43,55)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Left_4.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Left_5.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,30,65,45))});

        directionToImageDarknutAttackList.put(Direction.UP,
                new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Up_1.png").getImage(),
                        null,
                        null),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Up_2.png").getImage(),
                                null,
                                null),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Up_3.png").getImage(),
                                null,
                                new Ellipse2D.Double(51,-9,47,69)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Up_4.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Up_5.png").getImage(),
                                null,
                                new Ellipse2D.Double(40,0,26,68 ))});


        directionToImageDarknutAttackList.put(Direction.DOWN,
                new FighterImageInfo[]{new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Down_1.png").getImage(),
                        null,
                        null),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Down_2.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,9,32,47)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Down_3.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,51,35,39)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Down_4.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60)),
                        new FighterImageInfo(new ImageIcon(Sprite.strImageDir + "Darknut_Attack_Down_5.png").getImage(),
                                null,
                                new Ellipse2D.Double(0,50,29,60))});

    }

    public static final Image[] imgDarknutDeadList = new Image[]{new ImageIcon(Sprite.strImageDir + "Enemy_Dead_1.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Enemy_Dead_2.png").getImage(),
            new ImageIcon(Sprite.strImageDir + "Enemy_Dead_3.png").getImage()};
    

    public static final int DEFAULT_SPEED = 1; // Pixels per step
    public static final int DEFAULT_STEPS = 8;
    public static final int DEFAULT_ATTACK_STEPS = 5;

    public static final int SCREEN_LEFT_LIMIT = 150;
    public static final int SCREEN_RIGHT_LIMIT = 700;

    public static final int MAX_HEALTH = 3;


    public Darknut(int nPosX, int nPosY, Direction facingDirection) {
            super(nPosX,nPosY,facingDirection,DEFAULT_SPEED,DEFAULT_STEPS,DEFAULT_ATTACK_STEPS,MAX_HEALTH,
                directionToImageDarknutStill, directionToImageDarknutHurt, directionToImageDarknutWalkList,directionToImageDarknutAttackList, imgDarknutDeadList);
        setTeam(Team.FOE);
        setTimeParalyzeAfterAttack(15);
        this.setbVulnerableZoneConstantSize(true);
        this.setbVulnerableZoneEqualsKillZone(false);
    }

    @Override
    public Shape getImgFighterDefaultVulnerableZone() {
        return new Ellipse2D.Double(this.getPos().x + 11, this.getPos().y + 42, 45, 45);
    }

    @Override
    public Shape getImgFighterDefaultKillZone() {
        return null;
    }

    public void justInflictedDamage() {
        this.paralyze(30);
    }
    
}
