package _08final.mvc.model;

import java.awt.*;
import java.io.File;

public abstract class Sprite implements Movable {

	//the center-point of this sprite
	private Point pntCenter;
    private int nInitCenterX, nInitCenterY;

	//this causes movement; change in x and change in y
	private int nDeltaX, nDeltaY;

	//we need to know what team we're on
	private Team mTeam;
	public enum Direction {UP, DOWN, RIGHT, LEFT};
    private Direction facingDirection;

    // Height and width of the sprite
	private int nHeight;
	private int nWidth;


    // Expiry team for this sprite
    private int nDeadTimeLeft = 0;
    private  boolean bDead;

    private int maxHealth;
    private int currHealth;

    // top left corner coordinates
    private Point pntPos;

    // project directory with images
    public static String strImageDir  = System.getProperty("user.dir") + File.separator + "src"
                                        + File.separator + "_08final" + File.separator + "images" + File.separator;

    // project directory with fonts
    public static String strFontDir  = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "_08final" + File.separator + "fonts" + File.separator;



    public Sprite(int nCenterX, int nCenterY) {
        nInitCenterX = nCenterX;
        nInitCenterY = nCenterY;
        setCenter(new Point(nCenterX,nCenterY));
        bDead = false;
    }


	@Override
	public Team getTeam() {
	  return mTeam;
	}

	public void setTeam(Team team){
		mTeam = team;
	}

    public Direction getFacingDirection() {
        return facingDirection;
    }

    // This move method is primarily used by non-moving objects like platform when the screen moves
    // Other moving objects override to implement their own logic but also call this method
    public void move(){
        if (CommandCenter.getInstance().getMoveCountX() != 0) {
            pntCenter.x+= CommandCenter.getInstance().getDeltaX();
        }
        if (CommandCenter.getInstance().getMoveCountY() != 0) {
            pntCenter.y+= CommandCenter.getInstance().getDeltaY();
        }
    }

    // Set initial position for this sprite to be used when Link is respawned in the current level
    public void initCenter() {
        pntCenter.x = nInitCenterX;
        pntCenter.y = nInitCenterY;
    }


	public void setDeltaX(int nSet) {
		nDeltaX = nSet;
	}

	public void setDeltaY(int nSet) {
		nDeltaY = nSet;
	}

	public int getDeltaX() {
		return nDeltaX;
	}

    public int getDeltaY() {
        return nDeltaY;
    }


	public Point getCenter() {
		return pntCenter;
	}

	public void setCenter(Point pntParam) {
		pntCenter = pntParam;
	}

	public Point getPos() {
        return new Point(pntCenter.x - getWidth() / 2, pntCenter.y - getHeight() / 2);
    }

	@Override
    public void draw(Graphics g) {
    }

    public void setHeight(int nHeight) {
        this.nHeight = nHeight;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public int getHeight() {
        return nHeight;
    }

    public int getWidth() {
        return nWidth;
    }

	public void setLeftDirection() {
        facingDirection = Direction.LEFT;
	};
	public void setRightDirection() {
        facingDirection = Direction.RIGHT;
	};

    public void setUpDirection() {
        facingDirection = Direction.UP;
    };

    public void setDownDirection() {
        facingDirection = Direction.DOWN;
    };

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }


    public void setDead() {
        this.bDead = true;
    };

    public boolean isDead() {
        return bDead;
    }


    public int getDeadTimeLeft() {
        return nDeadTimeLeft;
    }


    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(int health) {
        this.currHealth = health;
    }

    public void decrCurrHealth() {
        this.currHealth--;
    }

}
