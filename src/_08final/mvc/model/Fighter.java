package _08final.mvc.model;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Map;

public abstract class Fighter extends Sprite {

    private final Map<Direction, FighterImageInfo> directionToImgFighterDetailsStill;
    private final Map<Direction, FighterImageInfo> directionToImgFighterDetailsHurt;
    private final Map<Direction, FighterImageInfo[]> directionToImgFighterDetailsWalkList;
    private final Map<Direction, FighterImageInfo[]> directionToImgFighterDetailsAttackList;
    private Image[] imgFighterDeadList;

    private Image imgFighter;

    private Shape imgFighterVulnerableZone;
    private Shape imgFighterKillZone;

    private Shape imgFighterTempVulnerableZone;
    private Shape imgFighterTempKillZone;

    private int nFighterDeadTimeLeft = 0;
    private int nFighterHurtTimeLeft = 0;
    private int nFighterParalyzedTimeLeft = 0;

    private int nMoveRightCount = 0;
    private int nMoveLeftCount = 0;
    private int nMoveUpCount = 0;
    private int nMoveDownCount = 0;

    private int nAttackIncrCount = 0;
    private int nDeadIncrCount = 0;

    private int nDeadImages;

    //private int nDeltaY = -4; // Delta during Link Spawn to ensure Link comes out of pipe slowly

    private int defaultSpeed; // Pixels per step
    private int defaultSteps; //

    private int defaultAttackSteps; //

    private boolean isHurt = false;
    private boolean isParalyzed = false;
    private boolean isTempDeflecting = false;
    private boolean isTempReversing = false;


    private int nTimeParalyzeAfterAttack = 0;


    private boolean bVulnerableZoneConstantSize = true;
    private boolean bVulnerableZoneEqualsKillZone = false;

    private enum FighterMode {STILL, MOVE, ATTACK}

    public Fighter(int nCenterX, int nCenterY, Direction initialDirection,
                   int defaultSpeed, int defaultSteps, int defaultAttackSteps, int maxHealth,
                   Map<Direction, FighterImageInfo> directionToImgFighterStill,
                   Map<Direction, FighterImageInfo> directionToImgFighterHurt,
                   Map<Direction, FighterImageInfo[]> directionToImgFighterWalkList,
                   Map<Direction, FighterImageInfo[]> directionToImgFighterAttackList,
                   Image[] imgFighterDeadList) {
        super(nCenterX,nCenterY);
        //setCenter(new Point(nCenterX, nCenterY));
        //setDeltaY(nDeltaY);
        setFacingDirection(initialDirection);
        this.setMaxHealth(maxHealth);
        this.setCurrHealth(maxHealth);
        this.defaultSpeed = defaultSpeed;
        this.defaultSteps = defaultSteps;
        this.defaultAttackSteps = defaultAttackSteps;
        this.directionToImgFighterDetailsStill = directionToImgFighterStill;
        this.directionToImgFighterDetailsHurt = directionToImgFighterHurt;
        this.directionToImgFighterDetailsWalkList = directionToImgFighterWalkList;
        this.directionToImgFighterDetailsAttackList = directionToImgFighterAttackList;
        this.imgFighterDeadList = imgFighterDeadList;
        this.imgFighter = directionToImgFighterStill.get(initialDirection).getImgFighter();
        this.setWidth(imgFighter.getWidth(null));
        this.setHeight(imgFighter.getHeight(null));
        this.imgFighterVulnerableZone = getImgFighterDefaultVulnerableZone();
        this.imgFighterKillZone = getImgFighterDefaultKillZone();
        nDeadImages = imgFighterDeadList.length;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(imgFighter, getPos().x,
                getPos().y,null);
    }


    public void moveLeft() {
        if (nMoveLeftCount <= 1 || isTempDeflecting) {
            nMoveLeftCount = defaultSteps;
            if (!cannotRespondToMoveRequest()) this.setLeftDirection();
            move();
        }
    }

    public void moveRight() {
        if (nMoveRightCount <= 1 || isTempDeflecting) {
            nMoveRightCount = defaultSteps;
            if (!cannotRespondToMoveRequest()) this.setRightDirection();
            move();
        }
    }


    public void moveUp() {
        if (nMoveUpCount <= 1 || isTempDeflecting) {
            nMoveUpCount = defaultSteps;
            if (!cannotRespondToMoveRequest()) this.setUpDirection();
            move();
        }
    }

    public void moveDown() {
        if (nMoveDownCount <= 1 || isTempDeflecting) {
            nMoveDownCount = defaultSteps;
            if (!cannotRespondToMoveRequest()) this.setDownDirection();
            move();
        }
    }

    public void attack() {
        if (nAttackIncrCount == 0) {
            this.nAttackIncrCount = defaultAttackSteps;
            if (!cannotRespondToMoveRequest()) move();
        }
    }

    public void setDead() {
        super.setDead();
        nDeadIncrCount = nDeadImages;
        nFighterDeadTimeLeft = 67;
    }


    public int getFighterDeadTimeLeft() {
        return nFighterDeadTimeLeft;
    }

    public int getFighterHurtTimeLeft() {
        return nFighterHurtTimeLeft;
    }


    public void setHurt() {
        this.deflect();
        this.isHurt = true;
        this.decrCurrHealth();
    }

    public void removeHurt() {
        this.isHurt = false;
    }

    public boolean isHurt() {
        return this.isHurt;
    }

    public boolean isTempDeflecting() {
        return this.isTempDeflecting;
    }

    public boolean isReversing() {
        return this.isTempReversing;
    }

    public boolean isParalyzed() {
        return this.isParalyzed;
    }


/*
    public void checkHurt() {
        nFighterHurtTimeLeft--;
        if (nFighterHurtTimeLeft <= 0) {

            this.removeHurt();
            if (this.getCurrHealth() <= 0) this.setDead();
        }
    }
   */

    public Image getImgFighter() {
        return imgFighter;
    }

    public Shape getImgFighterVulnerableZone() {
        return imgFighterVulnerableZone;
    }

    public Shape getImgFighterKillZone() {
        return imgFighterKillZone;
    }

    public abstract Shape getImgFighterDefaultVulnerableZone();

    public abstract Shape getImgFighterDefaultKillZone();

    @Override
    public void move() {

        if (isParalyzed) checkParalysis();


        // Call method to set Link's image
        setFighterImage();

        // Code to make Link come out of pipe


        if (nDeadIncrCount > 0) {
            nDeadIncrCount--;
        }

        if (nMoveRightCount > 0) {
            //setAdjustedPos(defaultSpeed, 0);
            this.setCenter(new Point(this.getCenter().x + defaultSpeed, this.getCenter().y));
            if (bVulnerableZoneConstantSize && imgFighterVulnerableZone != null) {
                moveZone(imgFighterVulnerableZone, defaultSpeed, 0);
                if (imgFighterKillZone != null)
                    moveZone(imgFighterKillZone, defaultSpeed, 0);
            }
            nMoveRightCount--;
            if (isTempDeflecting && nMoveRightCount == 0) doneDeflecting();
        } else if (nMoveLeftCount > 0) {
            //setAdjustedPos(-defaultSpeed, 0);
            this.setCenter(new Point(this.getCenter().x - defaultSpeed, this.getCenter().y));
            if (bVulnerableZoneConstantSize && imgFighterVulnerableZone != null) {
                moveZone(imgFighterVulnerableZone, - defaultSpeed, 0);
                if (imgFighterKillZone != null)
                    moveZone(imgFighterKillZone, - defaultSpeed, 0);
            }
            nMoveLeftCount--;
            if (isTempDeflecting && nMoveLeftCount == 0) doneDeflecting();
        }

        if (nMoveUpCount > 0) {
            //setAdjustedPos(0, -defaultSpeed);
            this.setCenter(new Point(this.getCenter().x, this.getCenter().y - defaultSpeed));
            if (bVulnerableZoneConstantSize && imgFighterVulnerableZone != null) {
                moveZone(imgFighterVulnerableZone, 0, -defaultSpeed);
                if (imgFighterKillZone != null)
                    moveZone(imgFighterKillZone, 0, -defaultSpeed);
            }
            nMoveUpCount--;
            if (isTempDeflecting && nMoveUpCount == 0) doneDeflecting();
        } else if (nMoveDownCount > 0) {
            //setAdjustedPos(0, defaultSpeed);
            this.setCenter(new Point(this.getCenter().x, this.getCenter().y + defaultSpeed));
            if (bVulnerableZoneConstantSize && imgFighterVulnerableZone != null) {
                moveZone(imgFighterVulnerableZone, 0, defaultSpeed);
                if (imgFighterKillZone != null)
                    moveZone(imgFighterKillZone, 0, defaultSpeed);
            }
            nMoveDownCount--;
            if (isTempDeflecting && nMoveDownCount == 0) doneDeflecting();
        }

        if (nAttackIncrCount > 0) {
            nAttackIncrCount--;
            if (nAttackIncrCount == 0 && nTimeParalyzeAfterAttack > 0) // done with attack sequence
                paralyze(nTimeParalyzeAfterAttack);
        }
    }

    // Logic to set Link's image based on which direction he is walking and if still, based on side
    private void setFighterImage() {

        int nMoveRightMicroCount = defaultSteps - nMoveRightCount;
        int nMoveLeftMicroCount = defaultSteps - nMoveLeftCount;
        int nMoveUpMicroCount = defaultSteps - nMoveUpCount;
        int nMoveDownMicroCount = defaultSteps - nMoveDownCount;
        int nAttackIncrMicroCount = defaultAttackSteps - nAttackIncrCount;
        int nDeadIncrMicroCount = nDeadImages - nDeadIncrCount;

        if (nDeadIncrCount > 0 || this.isDead() && nDeadIncrMicroCount < nDeadImages ) {
            imgFighter = imgFighterDeadList[nDeadIncrMicroCount];
            nFighterDeadTimeLeft--;
        } else if (this.isDead()) {
            nFighterDeadTimeLeft = 0;
        } else if (this.isHurt) {
            imgFighter = directionToImgFighterDetailsHurt.get(this.getFacingDirection()).getImgFighter();
        } else if (this.isTempDeflecting || this.isParalyzed) {
            imgFighter = directionToImgFighterDetailsStill.get(this.getFacingDirection()).getImgFighter();
        } else if (nMoveRightCount > 0) {
            if (nMoveRightMicroCount < defaultSteps) {
                imgFighter = directionToImgFighterDetailsWalkList.get(Direction.RIGHT)[nMoveRightMicroCount].getImgFighter();
                if (nMoveRightMicroCount == 0 || nMoveRightMicroCount == defaultSteps - 1) {
                    updateFighterZones(FighterMode.MOVE, Direction.RIGHT, nMoveRightMicroCount);
                }
            }
        } else if (nMoveLeftCount > 0) {
            if (nMoveLeftMicroCount < defaultSteps) {
                imgFighter = directionToImgFighterDetailsWalkList.get(Direction.LEFT)[nMoveLeftMicroCount].getImgFighter();
                if (nMoveLeftMicroCount == 0 || nMoveLeftMicroCount == defaultSteps - 1) {
                    updateFighterZones(FighterMode.MOVE, Direction.LEFT, nMoveLeftMicroCount);
                }
            }
        } else if (nMoveUpCount > 0) {
            if (nMoveUpMicroCount < defaultSteps) {
                imgFighter = directionToImgFighterDetailsWalkList.get(Direction.UP)[nMoveUpMicroCount].getImgFighter();
                if (nMoveUpMicroCount == defaultSteps - 1) {
                    updateFighterZones(FighterMode.MOVE, Direction.UP, nMoveUpMicroCount);
                }
            }
        } else if (nMoveDownCount > 0) {
            if (nMoveDownMicroCount < defaultSteps) {
                imgFighter = directionToImgFighterDetailsWalkList.get(Direction.DOWN)[nMoveDownMicroCount].getImgFighter();
                if (nMoveDownMicroCount == 0 || nMoveDownMicroCount == defaultSteps - 1) {
                    updateFighterZones(FighterMode.MOVE, Direction.DOWN, nMoveDownMicroCount);
                }
            }
        } else {
            if (nAttackIncrCount > 0) {


                if (nAttackIncrMicroCount < defaultAttackSteps) {
                    imgFighter = directionToImgFighterDetailsAttackList.get(this.getFacingDirection())[nAttackIncrMicroCount].getImgFighter();
                    updateFighterZones(FighterMode.ATTACK, this.getFacingDirection(), nAttackIncrMicroCount);
                 }

            } else {
                imgFighter = directionToImgFighterDetailsStill.get(this.getFacingDirection()).getImgFighter();
                if (!bVulnerableZoneConstantSize || !bVulnerableZoneEqualsKillZone)
                    this.updateFighterZones(FighterMode.STILL, this.getFacingDirection(), 0);

            }
        }

        this.setWidth(this.imgFighter.getWidth(null));
        this.setHeight(this.imgFighter.getHeight(null));

    }


    public int getDeltaPerMove() {
        return defaultSpeed * defaultSteps;
    }



    public void setbVulnerableZoneConstantSize(boolean bVulnerableZoneConstantSize) {
        this.bVulnerableZoneConstantSize = bVulnerableZoneConstantSize;
    }

    public void setbVulnerableZoneEqualsKillZone(boolean bVulnerableZoneEqualsKillZone) {
        this.bVulnerableZoneEqualsKillZone = bVulnerableZoneEqualsKillZone;
    }

    public void updateFighterZones(FighterMode fighterMode, Direction fighterDirection, int nMicroCount) {

        switch (fighterMode) {

            case STILL:
                imgFighterTempVulnerableZone = directionToImgFighterDetailsStill.get(fighterDirection).getShapeImgVulnerableZone();
                imgFighterTempKillZone = directionToImgFighterDetailsStill.get(fighterDirection).getShapeImgKillZone();
                break;
            case MOVE:
                imgFighterTempVulnerableZone = directionToImgFighterDetailsWalkList.get(fighterDirection)[nMicroCount].getShapeImgVulnerableZone();
                imgFighterTempKillZone = directionToImgFighterDetailsWalkList.get(fighterDirection)[nMicroCount].getShapeImgKillZone();
                break;
            case ATTACK:
                imgFighterTempVulnerableZone = directionToImgFighterDetailsAttackList.get(fighterDirection)[nMicroCount].getShapeImgVulnerableZone();
                imgFighterTempKillZone = directionToImgFighterDetailsAttackList.get(fighterDirection)[nMicroCount].getShapeImgKillZone();
                break;

        }
        if (!bVulnerableZoneConstantSize) {
            if (imgFighterTempVulnerableZone == null) imgFighterVulnerableZone = getImgFighterDefaultVulnerableZone();


            else if (imgFighterTempVulnerableZone instanceof Ellipse2D) {
                ((Ellipse2D.Double) imgFighterVulnerableZone).x =
                        (this.getPos().getX()) + ((Ellipse2D.Double) imgFighterVulnerableZone).getX();
                ((Ellipse2D.Double) imgFighterVulnerableZone).y =
                        (this.getPos().getY()) + ((Ellipse2D.Double) imgFighterVulnerableZone).getY();
            } else if (imgFighterTempVulnerableZone instanceof Rectangle) {
                this.imgFighterVulnerableZone = new Rectangle((Rectangle) imgFighterTempVulnerableZone);
                ((Rectangle) imgFighterVulnerableZone).setLocation(
                        (int) (this.getPos().getX() + ((Rectangle) imgFighterVulnerableZone).getX()),
                        (int) (this.getPos().getY() + ((Rectangle) imgFighterVulnerableZone).getY()));
            }
        }
        
        if (imgFighterTempKillZone == null) imgFighterKillZone = getImgFighterDefaultKillZone();


        else if (imgFighterTempKillZone instanceof Ellipse2D) {
            ((Ellipse2D.Double) imgFighterKillZone).x =
                    (this.getPos().getX()) + ((Ellipse2D.Double) imgFighterKillZone).getX();
            ((Ellipse2D.Double) imgFighterKillZone).y =
                    (this.getPos().getY()) + ((Ellipse2D.Double) imgFighterKillZone).getY();
        }

         else if (imgFighterTempKillZone instanceof Rectangle) {
            this.imgFighterKillZone = new Rectangle((Rectangle) imgFighterTempKillZone);
            ((Rectangle) imgFighterKillZone).setLocation(
                    (int) (this.getPos().getX()  + ((Rectangle) imgFighterKillZone).getX()),
                    (int) (this.getPos().getY()  + ((Rectangle) imgFighterKillZone).getY()));
        }

    }

    public void moveZone(Shape fighterZone, int x, int y) {
        if (fighterZone instanceof Ellipse2D.Double) {
            ((Ellipse2D.Double) fighterZone).x += x;
            ((Ellipse2D.Double) fighterZone).y += y;
        } else if (fighterZone instanceof Rectangle) {
            ((Rectangle) fighterZone).x += x;
            ((Rectangle) fighterZone).y += y;
        }
    }

    public void deflect() {

        this.isTempDeflecting = true;
        switch(this.getFacingDirection()) {
            case RIGHT: moveLeft(); break;
            case LEFT: moveRight(); break;
            case UP: moveDown(); break;
            case DOWN: moveUp(); break;
        }
    }

    public void doneDeflecting() {

        this.isTempDeflecting = false;
        paralyze();
    }

    public void paralyze() {
        this.nFighterParalyzedTimeLeft = 10;
        this.isParalyzed = true;
    }

    public void paralyze(int nFighterParalyzedTimeLeft) {
        this.nFighterParalyzedTimeLeft = nFighterParalyzedTimeLeft;
        this.isParalyzed = true;
    }


    public void checkParalysis() {
        nFighterParalyzedTimeLeft--;
        if (nFighterParalyzedTimeLeft <= 0) {
            if (isHurt) {
                removeHurt();
                if (this.getCurrHealth() <= 0) this.setDead();
            }
            if(!isDead()) this.isParalyzed = false;
        }

    }


    public void setTimeParalyzeAfterAttack(int nTimeParalyzeAfterAttack) {
        this.nTimeParalyzeAfterAttack = nTimeParalyzeAfterAttack;
    }


    public boolean cannotRespondToMoveRequest() {
        return (isTempDeflecting || isParalyzed || isDead());
    }

    public boolean isVulnerable() {
        return (!cannotRespondToMoveRequest());
    }

    public void justInflictedDamage() { };


    public void forceMoveInOppositeDirection() {
        switch(this.getFacingDirection()) {
            case RIGHT: moveLeft(); break;
            case LEFT: moveRight(); break;
            case UP: moveDown(); break;
            case DOWN: moveUp(); break;
        }
    }

    public void forceMoveInOppositeDirection(Direction direction) {
        switch(direction) {
            case RIGHT: moveLeft(); break;
            case LEFT: moveRight(); break;
            case UP: moveDown(); break;
            case DOWN: moveUp(); break;
        }
    }

    public void forceMoveInSameDirection() {
        switch(this.getFacingDirection()) {
            case RIGHT: moveRight(); break;
            case LEFT: moveLeft(); break;
            case UP: moveUp(); break;
            case DOWN: moveDown(); break;
        }
    }



}
