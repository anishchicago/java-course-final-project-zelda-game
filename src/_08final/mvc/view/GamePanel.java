package _08final.mvc.view;

import _08final.mvc.controller.Game;
import _08final.mvc.model.*;
import _08final.sounds.Sound;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;


public class GamePanel extends JPanel {

	// FIELDS
	private Dimension dimOff;
	private Image imgOff;
	private Graphics grpOff;
	
	private GameFrame gmf;
	private Font fnt = new Font("SansSerif", Font.BOLD, 12);
	private Font fntBig = new Font("SansSerif", Font.BOLD, 28);
    private Font customFont;
    private Gem gemScore = new GreenGem(220,22);
	private FontMetrics fmt; 
	private int nFontWidth;
	private int nFontHeight;
	private String strDisplay = "";
    private boolean bPlayGameOverSound = true;

    private static final Image sanctuaryBackground = new ImageIcon(Sprite.strImageDir + "Sanctuary.png").getImage();


	// CONSTRUCTOR
	public GamePanel(Dimension dim){
	    gmf = new GameFrame();
		gmf.getContentPane().add(this);
		gmf.pack();
		initView();
		
		gmf.setSize(dim);
		gmf.setTitle("Super Link Bros.");
		gmf.setResizable(false);
		gmf.setVisible(true);
		this.setFocusable(true);
		setDoubleBuffered(true);
	}
/*
    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(new ImageIcon(Sprite.strImageDir + "Sanctuary.png").getImage(), 0, 0, null);
        super.paintComponent(g);
    }
*/
	// METHODS

	private void drawScore(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.white);
        g2D.setFont(customFont);


        // Draw time left
        //g2D.drawString("TIME", 700, nFontHeight + 20);
        //strDisplay = String.format("%03d",CommandCenter.getInstance().getGameTimeLeft());
        //g2D.drawString(strDisplay, 710, nFontHeight + 45);


        // Draw Link's total score
		g2D.drawString("FORCE COLLECTED", nFontWidth - 25, nFontHeight + 20);
        strDisplay = String.format("%05d",CommandCenter.getInstance().getScore());
		g2D.drawString(strDisplay, nFontWidth + 33, nFontHeight + 45);

        // Draw coin score
        gemScore.draw(g2D);
        strDisplay = "x" + String.format("%03d",CommandCenter.getInstance().getCoins());
        g2D.drawString(strDisplay, 245, 47);

        // Draw Link's hearts left

        if (CommandCenter.getInstance().getLink() != null) {
            int xPos = 890;
            int yPos = 22;
            int xIncr = 20;
            for (int i = 1; i <= CommandCenter.getInstance().getLink().getMaxHealth(); i++) {
                if (i <= CommandCenter.getInstance().getLink().getCurrHealth())
                    g2D.drawImage(Heart.fullHeart, xPos, yPos, null);
                else g2D.drawImage(Heart.emptyHeart, xPos, yPos, null);
                xPos += xIncr;
            }

        }


	}
	
	@SuppressWarnings("unchecked")
	public void update(Graphics g) {

		if (grpOff == null || Game.DIM.width != dimOff.width
				|| Game.DIM.height != dimOff.height) {
			dimOff = Game.DIM;
			imgOff = createImage(Game.DIM.width, Game.DIM.height);
			grpOff = imgOff.getGraphics();
		}

		// Fill in background with Link blue.
		grpOff.setColor(new Color(73, 144, 240));
		grpOff.fillRect(0, 0, Game.DIM.width, Game.DIM.height);

		if (!CommandCenter.getInstance().isPlaying() && !CommandCenter.getInstance().isGameOver()) {
            displayTextOnScreen(grpOff);
        } else if (CommandCenter.getInstance().isGameOver()) {
            grpOff.setColor(Color.white);
            grpOff.setFont(customFont);
            strDisplay = "GAME OVER"; // Manual alignment of 40 pixels to keep text in center
            grpOff.drawString(strDisplay,(Game.DIM.width - fmt.stringWidth(strDisplay))/2 - 50, Game.DIM.height / 2);
            strDisplay = "YOUR SCORE : " + String.format("%05d",CommandCenter.getInstance().getScore());
            grpOff.drawString(strDisplay,(Game.DIM.width - fmt.stringWidth(strDisplay))/2 - 100, Game.DIM.height / 2 + 50);
            if (bPlayGameOverSound) {
                //Sound.playSound("Game_over.wav");
                bPlayGameOverSound = false;
            }
		} else if (CommandCenter.getInstance().isPaused()) {
            Image imgBanner = new ImageIcon(Sprite.strImageDir + "Zelda_Logo.jpg").getImage();
            grpOff.drawImage(imgBanner,320,40,null);
			strDisplay = "GAME PAUSED";
            grpOff.setColor(Color.white);
            grpOff.setFont(customFont); // Manual alignment of 40 pixels to keep text in center
            grpOff.drawString(strDisplay,(Game.DIM.width - fmt.stringWidth(strDisplay))/2 - 50, Game.DIM.height / 2);
		}
		else {
            // Update game timer
            if (CommandCenter.getInstance().getLink() != null && !CommandCenter.getInstance().getLink().isDead()) {
                CommandCenter.getInstance().updateTimeLeft();
            }

            // draw background
            grpOff.drawImage(sanctuaryBackground, 0, 0, this);

            drawScore(grpOff);


			iterateMovables(grpOff,
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovBackground(),
                    (ArrayList<Movable>)  CommandCenter.getInstance().getMovFriends(),
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovPlatform(),
					(ArrayList<Movable>)  CommandCenter.getInstance().getMovFoes());
		}

		//draw the double-Buffered Image to the graphics context of the panel
		g.drawImage(imgOff, 0, 0, this);

        // Decrement global move counter
        if (CommandCenter.getInstance().getMoveCountX() != 0) {
            CommandCenter.getInstance().decrMoveCountX();
        }

        if (CommandCenter.getInstance().getMoveCountY() != 0) {
            CommandCenter.getInstance().decrMoveCountY();
        }


	} 

	//for each movable array, process it.
	private void iterateMovables(Graphics g, ArrayList<Movable>...movMovz){
		
		for (ArrayList<Movable> movMovs : movMovz) {
			for (Movable mov : movMovs) {
                if (!CommandCenter.getInstance().getInitPosFlag()) {
                    mov.move();
                } else {
                    mov.initCenter();
                }
				mov.draw(g);
			}
		}

        if (CommandCenter.getInstance().getInitPosFlag()) {
            CommandCenter.getInstance().setInitPosFlag(false);
        }
	}

	private void initView() {
		Graphics g = getGraphics();			// get the graphics context for the panel
        loadGameFont();
		g.setFont(fnt);						// take care of some simple font stuff
		fmt = g.getFontMetrics();
		nFontWidth = fmt.getMaxAdvance();
		nFontHeight = fmt.getHeight();
		g.setFont(fntBig);					// set font info
	}
	
	// This method draws some text to the middle of the screen before/after a game
	private void displayTextOnScreen(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        Image imgBackground = new ImageIcon(Sprite.strImageDir + "Zelda_Background_1.jpg").getImage();
        g2d.drawImage(imgBackground,0,0,null);

        Image imgBanner = new ImageIcon(Sprite.strImageDir + "Zelda_Logo.jpg").getImage();
        g2d.drawImage(imgBanner,320,40,null);

        g.setColor(Color.white);
        g.setFont(customFont);

        strDisplay = "KEY CONTROLS";
        grpOff.drawString(strDisplay,
                (Game.DIM.width)/2 - fmt.stringWidth(strDisplay), Game.DIM.height / 4
                        + nFontHeight + 160);

		strDisplay = "S : START";
		grpOff.drawString(strDisplay,
				(Game.DIM.width)/2 - fmt.stringWidth(strDisplay), Game.DIM.height / 4
						+ nFontHeight + 200);

		strDisplay = "P : PAUSE";
		grpOff.drawString(strDisplay,
				(Game.DIM.width)/2 - fmt.stringWidth(strDisplay), Game.DIM.height / 4
						+ nFontHeight + 230);

        strDisplay = "Q : QUIT    ";
        grpOff.drawString(strDisplay,
                (Game.DIM.width)/2 - fmt.stringWidth(strDisplay) + 2, Game.DIM.height / 4 // Manual offset to ensure the semi-colons align
                        + nFontHeight + 260);

        strDisplay = "ARROW KEYS TO MOVE";
        grpOff.drawString(strDisplay,
                (Game.DIM.width)/2 - fmt.stringWidth(strDisplay), Game.DIM.height / 4
                        + nFontHeight + 290);

        strDisplay = "SPACE TO ATTACK";
        grpOff.drawString(strDisplay,
                (Game.DIM.width)/2 - fmt.stringWidth(strDisplay), Game.DIM.height / 4
                        + nFontHeight + 320);

	}
	

    // Custom font for Link
    private void loadGameFont() {
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(Sprite.strFontDir + "Triforce.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);

        } catch (java.io.IOException | FontFormatException e)  {
            e.printStackTrace();
            System.out.println("Invalid font or font file not found");
        }
    }
}