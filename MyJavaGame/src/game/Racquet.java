package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/*
 * Alvin Quijano 
 * Version: 0.3
 * Description: This is the Racquet class file 
 */
public class Racquet {
	
	// private instance variables 
	int x = 0;
	int xa = 0; 
	private Game game; 
	
	// constructor
	public Racquet(Game game) {
		this.game = game;
	}
	
	// public methods 
	
	// This is the move method, it moves the racque
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 60)
			x = x + xa; 
	}
	
	// This is the paint method, it draws the racquet sprite on the game board
	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
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
}
