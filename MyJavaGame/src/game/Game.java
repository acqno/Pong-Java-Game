package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Name: Alvin Quijano 
 * Version: 1.3
 * Description: This is the main game class, it creates the game window and creates
 * the ball object and moves it around the window
 */


public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	
	public Game() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}
	
	// method that paints the ball to the canvas 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		racquet.paint(g2d);
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(350, 450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}

}
