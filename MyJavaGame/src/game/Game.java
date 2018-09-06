package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Name: Alvin Quijano 
 * Version: 1.0 
 * Description: This is the main game class, it creates the game window and creates
 * the ball object and moves it around the window
 */


public class Game extends JPanel {

	Ball ball = new Ball(this);
	
	private void move() {
		ball.move();
	}
	
	// method that paints the ball to the canvas 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
	}



	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}

}
