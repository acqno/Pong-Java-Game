package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/*
 * Alvin Quijano 
 * Version: 0.5
 * Description: This is the Racquet class file 
 */
public class Racquet {
	
	int x = 0;
	int xa = 0;
	
	// private instance variables 
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	private Game game; 
	
	// constructor
	public Racquet(Game game) {
		this.game = game;
	}
	
	// PUBLIC METHODS 
	
	// This is the move method, it moves the racquet
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
			x = x + xa; 
	}
	
	// This is the paint method, it draws the racquet sprite on the game board
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}
	
	// This method stops the racquet from moving when user releases a button
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
	// This method handles the user input and moves the racquet left or right
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			xa = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 1;
		}

	}
	
	// Defines the position of the rectangle on the game board 
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y;
	}
}
