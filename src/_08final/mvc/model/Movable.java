package _08final.mvc.model;

import java.awt.*;

public interface Movable {

	public static enum Team {
		FRIEND, FOE, PLATFORM, BACKGROUND
	}



	//for the game to move and draw movable objects
	public void move();
	public void setLeftDirection();
    public void setRightDirection();
	public void setUpDirection();
	public void setDownDirection();
    public void setDead();
    public boolean isDead();
    public int getDeadTimeLeft();
	public void draw(Graphics g);
    public void initCenter();

	//for collision detection
	public Point getPos();
	public Point getCenter();
	public Team getTeam();
	public int getHeight();
	public int getWidth();


} //end Movable
