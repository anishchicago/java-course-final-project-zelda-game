package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CommandCenter {

	private  int nNumLink;
	private  int nLevel;
	private  long lScore;
	private  int nCoins;
	private Link link;
    private Flag flag;
	private  boolean bPlaying;
	private  boolean bPaused;
    private int nSecondsLeft;
    private long lSysTimeSeconds;
    private boolean bInitPosFlag = false;
    private boolean bLevelClear = false;
    private Point pntFlagCenterTracker;
	
	// These ArrayLists with capacities set
	private List<Movable> movPlatform = new ArrayList<Movable>(300);
	private List<Movable> movFriends = new ArrayList<Movable>(100);
	private List<Movable> movFoes = new ArrayList<>(200);
	private List<Movable> movBackground = new ArrayList<>(50);

	private GameOpsList opsList = new GameOpsList();

	private static CommandCenter instance = null;

    private int nMoveCountX = 0;
    private int nMoveCountY = 0;
    private int nDeltaX = 0;
    private int nDeltaY = 0;

	// Constructor made private - static Utility class only
	private CommandCenter() {}

	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}

	public  void initGame(){
		setLevel(1);
		setScore(0);
        setCoins(0);
		setNumLinks(5);
        nSecondsLeft = Integer.MAX_VALUE;
        lSysTimeSeconds = System.currentTimeMillis()/1000;
	}

    public void setTimeLeft(int nSecondsLeft) {
        this.nSecondsLeft = nSecondsLeft;
    }

	
	// The parameter is true if this is for the beginning of the game, otherwise false
	public  void spawnLink(boolean bFirst) {
		if (getNumLinks() != 0) {
			link = new Link(508,720, Sprite.Direction.UP);
			opsList.enqueue(link, CollisionOp.Operation.ADD);
			if (!bFirst) {
                setInitPosFlag(true);
                setNumLinks(getNumLinks() - 1);
            }
            link.moveUp();

		}
	}

    public void spawnOctorok()  {
        opsList.enqueue(new Octorok(220,361, Sprite.Direction.DOWN), CollisionOp.Operation.ADD);
    }


    public void spawnDarknut()  {
        opsList.enqueue(new Darknut(450,361, Sprite.Direction.DOWN), CollisionOp.Operation.ADD);
    }


	public GameOpsList getOpsList() {
		return opsList;
	}

	public void setOpsList(GameOpsList opsList) {
		this.opsList = opsList;
	}

	public  void clearAll(){
		movPlatform.clear();
		movFriends.clear();
		movFoes.clear();
		movBackground.clear();
	}

	public  boolean isPlaying() {
		return bPlaying;
	}

	public  void setPlaying(boolean bPlaying) {
		this.bPlaying = bPlaying;
	}

	public  boolean isPaused() {
		return bPaused;
	}

	public  void setPaused(boolean bPaused) {
		this.bPaused = bPaused;
	}
	
	public  boolean isGameOver() {		//if the number of Links is zero or seconds left is zero, then game over
		if ((getNumLinks() == 0 || nSecondsLeft == 0 || nLevel > Game.GAME_MAX_LEVEL) && nLevel != 0) {
			return true;
		}
		return false;
	}

	public  int getLevel() {
		return nLevel;
	}

    public void setNextLevel() {
        nLevel++;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public Flag getFlag() {
        return flag;
    }

    public boolean isLevelClear() {
        return bLevelClear;
    }

    public void setLevelClear(boolean bLevelClearStatus) {
        bLevelClear = bLevelClearStatus;
    }

	public   long getScore() {
		return lScore;
	}

    public void setCoins(int nCoins) {
        this.nCoins = nCoins;
    }

    public int getCoins() {
        return nCoins;
    }

    public void incrCoinScore() {
        nCoins++;
    }

	public  void setScore(long lParam) {
		lScore = lParam;
	}

    public  void addScore(long lParam) {
        lScore += lParam;
    }

	public  void setLevel(int n) {
		nLevel = n;
	}

	public  int getNumLinks() {
		return nNumLink;
	}

	public  void setNumLinks(int nParam) {
		nNumLink = nParam;
	}
	
	public Link getLink(){
		return link;
	}
	
	public  void setLink(Link linkParam){
		link = linkParam;
	}

	public  List<Movable> getMovFriends() {
		return movFriends;
	}

	public  List<Movable> getMovFoes() {
		return movFoes;
	}

	public  List<Movable> getMovBackground() {
		return movBackground;
	}

	public  List<Movable> getMovPlatform() {
		return movPlatform;
	}

    public int getMoveCountX() {
        return nMoveCountX;
    }

    public int getMoveCountY() {
        return nMoveCountY;
    }


    public void setMoveCountX(int nMoveCount) {
        this.nMoveCountX = nMoveCount;
    }

    public void decrMoveCountX() {
        nMoveCountX--;
    }

    public void setMoveCountY(int nMoveCount) {
	    this.nMoveCountY = nMoveCount;
    }

    public void decrMoveCountY() {
        nMoveCountY--;
    }

    public int getDeltaX() {
        return nDeltaX;
    }

    public void setDeltaX(int nDeltaX) {
        this.nDeltaX = nDeltaX;
    }

    public int getDeltaY() {
        return nDeltaX;
    }

    public void setDeltaY(int nDeltaX) {
        this.nDeltaX = nDeltaX;
    }


    public int getGameTimeLeft() {
        return nSecondsLeft;
    }

    public void updateTimeLeft() {
        if (lSysTimeSeconds != System.currentTimeMillis()/1000) {
            nSecondsLeft--;
            lSysTimeSeconds = System.currentTimeMillis()/1000;
        }
    }

    public boolean getInitPosFlag() {
        return bInitPosFlag;
    }

    public void setInitPosFlag(boolean bInitPosFlag) {
        this.bInitPosFlag = bInitPosFlag;
    }

    public void setPntFlagCenterTracker(int nCenterX, int nCenterY) {
        pntFlagCenterTracker = new Point(nCenterX,nCenterY);
    }

    public Point getPntFlagCenterTracker() {
        return pntFlagCenterTracker;
    }


}
