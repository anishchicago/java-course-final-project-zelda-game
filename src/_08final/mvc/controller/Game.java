package _08final.mvc.controller;

import _08final.mvc.model.*;
import _08final.mvc.view.GamePanel;
import _08final.sounds.Sound;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.util.Random;

import static java.awt.event.KeyEvent.VK_N;

/**
 *
 *  Date        Author      Description
 *  ----        ------      -----------
 *  06/05/16    Moison      Extended code to implement first two levels of Link
 */
public class Game implements Runnable, KeyListener {

	// FIELDS
	public static final Dimension DIM = new Dimension(1020, 780); //the dimension of the game.
	private GamePanel gmpPanel;
	public static Random R = new Random();
	public final static int ANI_DELAY = 45; // milliseconds between screen
											// updates (animation)

    public static final int GAME_MAX_LEVEL = 2; // Define max number of levels to determine if game is over.
	private Thread thrAnim;
	private int nTick = 0;
    private final int FOE_LEVEL_MULTIPLIER = 2; //Number of foes active based on level.

    private long lStartTime = System.currentTimeMillis();

	private boolean bMuted = false;
	private final int PAUSE = 80, // p key
			QUIT = 81, // q key
			LEFT = 37, // move left
			RIGHT = 39, // move right
			UP = 38, // move up
            DOWN = 40, // move down
			START = 83, // s key
			FIRE = 32, // space key
			MUTE = 77; // m-key mute

	private Clip clpMusicBackground;

	public Game() {

		gmpPanel = new GamePanel(DIM);
		gmpPanel.addKeyListener(this);
		//clpMusicBackground = Sound.clipForLoopFactory("Zelda_Classic.wav");
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Game game = new Game();
							game.fireUpAnimThread();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

	private void fireUpAnimThread() {
		if (thrAnim == null) {
			thrAnim = new Thread(this);
			thrAnim.start();
		}
	}


	public void run() {

		thrAnim.setPriority(Thread.MIN_PRIORITY);

		while (Thread.currentThread() == thrAnim) {

			tick();

            // Check items in order of priority
            checkGameOver();
            checkLevelClear();
            checkWallCollision();
            checkCollision();
			gmpPanel.update(gmpPanel.getGraphics());
			checkFoes();
            addFoes();
            processQueue();
			try {
				lStartTime += ANI_DELAY;
				Thread.sleep(Math.max(0,lStartTime - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				continue;
			}
		} // end while
	} // end run

    // Check if level is clear after the completion of fireworks
    private void checkLevelClear() {
        if (CommandCenter.getInstance().isLevelClear()) {
            CommandCenter.getInstance().getOpsList().enqueue(new Firework(Game.R.nextInt(Game.DIM.width),Game.R.nextInt(Game.DIM.height) - 300),
                                                            CollisionOp.Operation.ADD);
            for (Movable movFriend : CommandCenter.getInstance().getMovFriends()) {
                if (movFriend instanceof Firework) {
                    if (((Firework) movFriend).getExpiryCounter() > 0) {
                        ((Firework) movFriend).decrExpiryCounter();
                    } else {
                        CommandCenter.getInstance().getOpsList().enqueue(movFriend, CollisionOp.Operation.REMOVE);
                    }
                }
            }
        } else  {
            // Remove any left over fireworks from previous level
            for (Movable movFriend : CommandCenter.getInstance().getMovFriends()) {
                if (movFriend instanceof Firework) {
                    CommandCenter.getInstance().getOpsList().enqueue(movFriend, CollisionOp.Operation.REMOVE);
                }
            }
        }
        if (CommandCenter.getInstance().isLevelClear() && CommandCenter.getInstance().getFlag().getCenter().y > 650) {
            setNextLevel();
        }
    }

    // Check if Game is over and stop background music
    private void checkGameOver() {
        if (CommandCenter.getInstance().isGameOver()) {
            stopLoopingSounds(clpMusicBackground);
        }
    }

    // Method to draw background based on current level of game.
	private void drawBackGround() {



	}


    // Method to draw the game level components
    private void drawLevelGame() {

	    GameOpsList gameOpsList = CommandCenter.getInstance().getOpsList();


        gameOpsList.enqueue(new Wall(0, 0, 95, 768),CollisionOp.Operation.ADD);
        gameOpsList.enqueue(new Wall(946, 0, 95, 768),CollisionOp.Operation.ADD);

        gameOpsList.enqueue(new Wall(207, 0, 605, 71),CollisionOp.Operation.ADD);
        gameOpsList.enqueue(new Wall(207, 760, 605, 4),CollisionOp.Operation.ADD);

        gameOpsList.enqueue(new Wall(35, 108, 85, 85),CollisionOp.Operation.ADD);
        gameOpsList.enqueue(new Wall(112, 39, 85, 85),CollisionOp.Operation.ADD);

        gameOpsList.enqueue(new Wall(934, 51, 85, 85),CollisionOp.Operation.ADD);
        gameOpsList.enqueue(new Wall(112, 39, 85, 85),CollisionOp.Operation.ADD);

        gameOpsList.enqueue(new Wall(866, 682, 85, 85),CollisionOp.Operation.ADD);
        gameOpsList.enqueue(new Wall(68, 682, 85, 85),CollisionOp.Operation.ADD);

    }


    // Method to check collision with friends and foes
    private void checkCollision() {

        if (CommandCenter.getInstance().getLink() != null && !CommandCenter.getInstance().isLevelClear()) {
            Link link = CommandCenter.getInstance().getLink();

            int nLinkHeight = link.getHeight();
            int nLinkWidth =  link.getWidth();
            int nLinkPosX = link.getPos().x;
            int nLinkPosY = link.getPos().y;
            int nFriendHeight, nFriendWidth, nFriendCenterX, nFriendCenterY;
            int nFriendPosX, nFriendPosY;
            for (Movable movFriend : CommandCenter.getInstance().getMovFriends()) {
                if (!(movFriend instanceof Link)) {
                    nFriendHeight = movFriend.getHeight();
                    nFriendWidth = movFriend.getWidth();
                    nFriendCenterX = movFriend.getCenter().x;
                    nFriendCenterY = movFriend.getCenter().y;
                    nFriendPosX = nFriendCenterX - nFriendWidth / 2;
                    nFriendPosY = nFriendCenterY - nFriendHeight / 2;
                    if (checkWithinRange(nLinkPosX,nLinkWidth,nFriendPosX,nFriendWidth)
                            && checkWithinRange(nLinkPosY,nLinkHeight,nFriendPosY,nFriendHeight)) {
                        if (movFriend instanceof Gem) {
                            CommandCenter.getInstance().getOpsList().enqueue(movFriend, CollisionOp.Operation.REMOVE);
                            Sound.playSound("Link_Gem.wav");
                            CommandCenter.getInstance().incrCoinScore();
                            CommandCenter.getInstance().addScore(((Gem) movFriend).getValue());
                        } else if (movFriend instanceof Flag) {
                            stopLoopingSounds(clpMusicBackground);
                            CommandCenter.getInstance().addScore(Flag.FLAG_WORTH);
                            CommandCenter.getInstance().setLevelClear(true);
                        }

                    }
                }
            }

            int nFoeHeight, nFoeWidth, nFoeCenterX, nFoeCenterY, nFoePosX, nFoePosY;
            for (Movable movFoe : CommandCenter.getInstance().getMovFoes()) {
                nFoeHeight = movFoe.getHeight();
                nFoeWidth = movFoe.getWidth();
                nFoeCenterX = movFoe.getCenter().x;
                nFoeCenterY = movFoe.getCenter().y;
                nFoePosX = nFoeCenterX - nFoeWidth / 2;
                nFoePosY = nFoeCenterY - nFoeHeight / 2;
                if (checkWithinRange(nLinkPosX,nLinkWidth,nFoePosX,nFoeWidth)
                    && checkWithinRange(nLinkPosY,nLinkHeight,nFoePosY,nFoeHeight)
                    && !movFoe.isDead()) {
                    if (!link.cannotRespondToMoveRequest()) {
                        checkFighterBattle(link, movFoe);
                    }

                }
                if (movFoe.isDead() && movFoe.getDeadTimeLeft() == 0) {
                    if (movFoe instanceof Sprite) {
                        Point pntFoeCenter = movFoe.getCenter();
                        CommandCenter.getInstance().getOpsList().enqueue(
                                new GreenGem(pntFoeCenter.x, pntFoeCenter.y), CollisionOp.Operation.ADD);
                    }
                    CommandCenter.getInstance().getOpsList().enqueue(movFoe, CollisionOp.Operation.REMOVE);
                }

            }

        }

    }

    public void checkFighterBattle(Movable movFriend, Movable movFoe) {
        if (movFriend instanceof Fighter && movFoe instanceof Fighter) {
            if (canInflictDamage(((Fighter) movFriend),(Fighter) movFoe)) {
                ((Fighter) movFoe).setHurt();
                ((Fighter) movFriend).justInflictedDamage();
            }
            if (canInflictDamage(((Fighter) movFoe),(Fighter) movFriend)) {
                ((Fighter) movFriend).setHurt();
                ((Fighter) movFoe).justInflictedDamage();
                Sound.playSound("Link_Hurt.wav");
            }
        }
    }

    // Check for collision with wall
    private void checkWallCollision() {

        for (Movable movPlatform : CommandCenter.getInstance().getMovPlatform()) {

            Point pntPlatform = movPlatform.getCenter();

            for (Movable movFriend : CommandCenter.getInstance().getMovFriends()) {

                Point pntFriend = movFriend.getPos();

                if ((movPlatform instanceof Wall && movFriend instanceof Fighter) &&
                        checkWithinRange(pntFriend.x, movFriend.getWidth(), pntPlatform.x, movPlatform.getWidth())
                        && checkWithinRange(pntFriend.y, movFriend.getHeight(), pntPlatform.y, movPlatform.getHeight())) {
                    if (!((Fighter) movFriend).isParalyzed())
                        ((Fighter) movFriend).deflect();

                }
            }

            for (Movable movFoe : CommandCenter.getInstance().getMovFoes()) {

                Point pntFoe = movFoe.getPos();

                if ((movPlatform instanceof Wall && movFoe instanceof Fighter) &&
                        checkWithinRange(pntFoe.x, movFoe.getWidth(), pntPlatform.x, movPlatform.getWidth())
                        && checkWithinRange(pntFoe.y, movFoe.getHeight(), pntPlatform.y, movPlatform.getHeight())) {
                    if (!((Fighter) movFoe).isParalyzed()) {
                        ((Fighter) movFoe).deflect();
                        ((Fighter) movFoe).forceMoveInOppositeDirection();
                    }
                }
            }

        }

    }


    // homing and inter-foe collisions (lol)

    private void checkFoes() {

        // all other foes

        for (Movable movFoe1 : CommandCenter.getInstance().getMovFoes()) {

            if (CommandCenter.getInstance().getLink() != null) {
                Link link = CommandCenter.getInstance().getLink();

                if (movFoe1 instanceof Fighter) {

                    if (!((Fighter)(movFoe1)).cannotRespondToMoveRequest()) {

                        int pixelsPerMove = ((Fighter) movFoe1).getDeltaPerMove();

                        int nLinkX = link.getCenter().x;
                        int nLinkY = link.getCenter().y;

                        int nLinkFoeXDist = movFoe1.getCenter().x - nLinkX;
                        int nLinkFoeYDist = movFoe1.getCenter().y - nLinkY;


                        if (Math.abs(nLinkFoeXDist) + pixelsPerMove >= Math.abs(nLinkFoeYDist)) {
                            if (nLinkFoeXDist > pixelsPerMove * 5)
                                ((Fighter) (movFoe1)).moveLeft();
                            else if (nLinkFoeXDist < - pixelsPerMove * 5)
                                ((Fighter) (movFoe1)).moveRight();
                            else ((Fighter) (movFoe1)).attack();
                        } else {
                            if (nLinkFoeYDist > pixelsPerMove * 5)
                                ((Fighter) (movFoe1)).moveUp();
                            else if (nLinkFoeYDist < - pixelsPerMove * 5)
                                ((Fighter) (movFoe1)).moveDown();
                            else ((Fighter) (movFoe1)).attack();
                        }
                    }
                }
            }


            Point pntMovFoe1 = movFoe1.getCenter();

            for (Movable movFoe2 : CommandCenter.getInstance().getMovFoes()) {

                if (movFoe1 != movFoe2) {

                    Point pntMovFoe2 = movFoe2.getPos();

                    if ((movFoe1 instanceof Fighter && movFoe2 instanceof Fighter) &&
                            checkWithinRange(pntMovFoe2.x, movFoe2.getWidth(), pntMovFoe1.x, movFoe1.getWidth())
                            && checkWithinRange(pntMovFoe2.y, movFoe2.getHeight(), pntMovFoe1.y, movFoe1.getHeight())) {
                        if (!((Fighter) movFoe1).cannotRespondToMoveRequest()) {

                            ((Fighter) movFoe1).forceMoveInOppositeDirection(((Fighter) movFoe2).getFacingDirection());
                        }

                        if (!((Fighter) movFoe2).cannotRespondToMoveRequest()) {

                            ((Fighter) movFoe2).forceMoveInSameDirection();
                        }
                    }
                }
            }
        }

        }


    public boolean canInflictDamage(Fighter fighterAttacker, Fighter fighterUnderAttack) {
        if (!fighterUnderAttack.isVulnerable()) return false;
        Shape myFighterKillZone = fighterAttacker.getImgFighterKillZone();
        Shape otherFighterVulnerableZone = fighterUnderAttack.getImgFighterVulnerableZone();
        if (myFighterKillZone == null || otherFighterVulnerableZone == null) return false;
        Area myFighterKillZoneArea = new Area(myFighterKillZone);
        myFighterKillZoneArea.intersect(new Area(otherFighterVulnerableZone));
        return !myFighterKillZoneArea.isEmpty();
    }

    // Spawn a foes based on their intro interval but limit based on level multiplier
    // Ensure number of foes are proportionate to game level
    private void addFoes() {
        if (CommandCenter.getInstance().getLevel() != 0) {

            if (getTick() % (6000 /ANI_DELAY/CommandCenter.getInstance().getLevel()) == 0
                    && CommandCenter.getInstance().getMovFoes().size() < CommandCenter.getInstance().getLevel() * FOE_LEVEL_MULTIPLIER){
                CommandCenter.getInstance().spawnOctorok();
            }

            if (getTick() % (12000 /ANI_DELAY/CommandCenter.getInstance().getLevel()) == 0
                    && CommandCenter.getInstance().getMovFoes().size() < CommandCenter.getInstance().getLevel() * FOE_LEVEL_MULTIPLIER){
                CommandCenter.getInstance().spawnDarknut();
            }

        }
    }

    private void processQueue() {

        //we are dequeuing the opsList and performing operations in serial to avoid mutating the movable arraylists while iterating them above
        while(!CommandCenter.getInstance().getOpsList().isEmpty()){
            CollisionOp cop =  CommandCenter.getInstance().getOpsList().dequeue();
            Movable mov = cop.getMovable();
            CollisionOp.Operation operation = cop.getOperation();

            switch (mov.getTeam()){
                case FOE:
                    if (operation == CollisionOp.Operation.ADD){
                        CommandCenter.getInstance().getMovFoes().add(mov);
                    } else {
                        CommandCenter.getInstance().getMovFoes().remove(mov);
                    }
                    break;
                case FRIEND:
                    if (operation == CollisionOp.Operation.ADD){
                        CommandCenter.getInstance().getMovFriends().add(mov);
                    } else {
                        CommandCenter.getInstance().getMovFriends().remove(mov);
                    }
                    break;

                case BACKGROUND:
                    if (operation == CollisionOp.Operation.ADD){
                        CommandCenter.getInstance().getMovBackground().add(mov);
                    } else {
                        CommandCenter.getInstance().getMovBackground().remove(mov);
                    }
                    break;
                case PLATFORM:
                    if (operation == CollisionOp.Operation.ADD){
                        CommandCenter.getInstance().getMovPlatform().add(mov);
                    } else {
                        CommandCenter.getInstance().getMovPlatform().remove(mov);
                    }
                    break;
            }
        }
        System.gc();
    }//end meth

	//some methods for timing events in the game, such as the appearance of UFOs, floaters (power-ups), etc.
	public void tick() {
		if (nTick == Integer.MAX_VALUE)
			nTick = 0;
		else
			nTick++;
	}

	public int getTick() {
		return nTick;
	}

	// Called when user presses 's'
	private void startGame() {
		//clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
		CommandCenter.getInstance().clearAll();
		CommandCenter.getInstance().initGame();
		CommandCenter.getInstance().setPlaying(true);
		CommandCenter.getInstance().setPaused(false);
		drawBackGround();
        drawLevelGame();
        CommandCenter.getInstance().spawnLink(true);
	}


    // Varargs for stopping looping-music-clips
	private static void stopLoopingSounds(Clip... clpClips) {
		for (Clip clp : clpClips) {
			clp.stop();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Link link = CommandCenter.getInstance().getLink();
		int nKey = e.getKeyCode();

		if (nKey == START && !CommandCenter.getInstance().isPlaying())
			startGame();

		if (link != null) {
			switch (nKey) {
			case PAUSE:
				CommandCenter.getInstance().setPaused(!CommandCenter.getInstance().isPaused());
				//if (CommandCenter.getInstance().isPaused())
					//stopLoopingSounds(clpMusicBackground);
				//else
					//clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
				//break;
			case QUIT:
				System.exit(0);
				break;
            case UP:
                if (!CommandCenter.getInstance().getLink().cannotRespondToMoveRequest()) {
                    moveUp();
                }
                break;
            case DOWN:
                if (!CommandCenter.getInstance().getLink().cannotRespondToMoveRequest()) {
                    moveDown();
                }
                break;
            case RIGHT:
                if (!CommandCenter.getInstance().getLink().cannotRespondToMoveRequest()) {
                    moveRight();
                }
                break;
            case LEFT:
                if (!CommandCenter.getInstance().getLink().cannotRespondToMoveRequest()) {
                    moveLeft();
                }
                break;
            // Cheat key to jump to next level
            case FIRE:
                if (!CommandCenter.getInstance().getLink().isDead() && !CommandCenter.getInstance().getLink().cannotRespondToMoveRequest()) {
                    attack();
                    Sound.playSound("Link_Attack_1.wav");
                }
                break;
            case VK_N:
                //stopLoopingSounds(clpMusicBackground);
                CommandCenter.getInstance().getLink().setCenter(new Point(
                        CommandCenter.getInstance().getFlag().getCenter().x -26,
                        CommandCenter.getInstance().getFlag().getCenter().y
                ));
                break;
			default:
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Link link = CommandCenter.getInstance().getLink();
		int nKey = e.getKeyCode();

		if (link != null) {
			switch (nKey) {

			case MUTE:
				if (!bMuted){
					//stopLoopingSounds(clpMusicBackground);
					bMuted = !bMuted;
				}
				else {
					//clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
					bMuted = !bMuted;
				}
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

    public boolean checkWithinRange(int nObj1Pos, int nObj1Length, int nObj2Pos, int nObj2Length) {
        if ((nObj1Pos + nObj1Length >= nObj2Pos && nObj1Pos <= nObj2Pos)
                || (nObj2Pos + nObj2Length >= nObj1Pos && nObj2Pos <= nObj1Pos)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to move right when the right arrow key is pressed. If Link is beyond his screen limit, move everything else to left
    private void moveRight() {
        //if (CommandCenter.getInstance().getLink().getCenter().getX() > Link.SCREEN_RIGHT_LIMIT) {
        //    moveEverythingLeft();
        //} else {
        CommandCenter.getInstance().getLink().moveRight();
        //}
    }

    // Similar to moveRight method but this is for moving left.
    private void moveLeft() {
        //if (CommandCenter.getInstance().getLink().getCenter().getX() > Link.SCREEN_RIGHT_LIMIT) {
        //    moveEverythingLeft();
        //} else {
        CommandCenter.getInstance().getLink().moveLeft();
        //}
    }

    // Method to move up when the up arrow key is pressed. If Link is beyond his screen limit, move everything else to down
    private void moveUp() {
        //if (CommandCenter.getInstance().getLink().getCenter().getX() > Link.SCREEN_RIGHT_LIMIT) {
        //    moveEverythingLeft();
        //} else {
            CommandCenter.getInstance().getLink().moveUp();
        //}
    }

    // Method to move up when the up arrow key is pressed. If Link is beyond his screen limit, move everything else to down
    private void moveDown() {
        //if (CommandCenter.getInstance().getLink().getCenter().getX() > Link.SCREEN_RIGHT_LIMIT) {
        //    moveEverythingLeft();
        //} else {
            CommandCenter.getInstance().getLink().moveDown();
        //}
    }

    private void attack() {
        CommandCenter.getInstance().getLink().attack();
    }


    // Method to increment to next level of the game.
    private void setNextLevel() {
            CommandCenter.getInstance().setLevelClear(false);
            CommandCenter.getInstance().setNextLevel();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (CommandCenter.getInstance().getLevel()) {
                case 2:
                    //clpMusicBackground = Sound.clipForLoopFactory("Zelda_Theme.wav");
                    break;
                default:
                    //clpMusicBackground = Sound.clipForLoopFactory("Zelda_Theme.wav");
                    break;
            }
            //clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
            CommandCenter.getInstance().clearAll();
            CommandCenter.getInstance().setNumLinks(5);
            CommandCenter.getInstance().setCoins(0);
            drawBackGround();
            drawLevelGame();
            CommandCenter.getInstance().spawnLink(true);
            CommandCenter.getInstance().setTimeLeft(300);

        }

}

