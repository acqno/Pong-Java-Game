package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 * Alvin Quijano 
 * Version: 1.0 
 * Description: This is the ball class, it creates the ball object 
 */
public class Ball {
	
	// instance variables 
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	// constructor 
	public Ball(Game game) {
		this.game= game;
	}

	// public methods 
	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER) // -1 moves ball left after hitting the wall
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - DIAMETER) // -1 moves ball up after hitting the wall
			game.gameOver();
		if (collision()) {
			ya = -1;
			y = game.racquet.getTopY() - DIAMETER;
		}

		x = x + xa;
		y = y + ya;
	}

	// This method paints the ball object to the game board
	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	// Boolean method that returns true if the ball intersects with the racquet 
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	// this method gets the position of the ball on the gameboard
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}

}