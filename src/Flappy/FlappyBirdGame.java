package Flappy;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
public class FlappyBirdGame extends JFrame {
	public int birdY = 250;
	public int birdVelocity = 0;
	public int gravity = 2;
	public int gap = 200;
	public int pipeX = 400;
	public int pipeWidth = 50;
	public int pipeHeight = 300;
	public int score = 0;
	
	public FlappyBirdGame() {
		setTitle("Flappy Bird Game");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		Timer timer = new Timer(20, new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.start();
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					birdVelocity = -20;
				}
			}
		});
		setFocusable(true);
		requestFocus();
	}
	private void update() {
		birdVelocity += gravity;
		birdY += birdVelocity;
		
		if(birdY < 0) {
			birdY = 0;
			birdVelocity = 0;
		}
		if(birdY + 50 > getHeight()) {
			birdY = getHeight() - 50;
			birdVelocity = 0;
		}
		
		pipeX -= 5;
		
		if(pipeX <- pipeWidth) {
			pipeX = getWidth();
			pipeHeight = (int) (Math.random() * 300) + 100;
			score++;
		}
		if(birdY < pipeHeight || birdY + 50 > pipeHeight + gap) {
			if(pipeX < 50 && pipeX + pipeWidth > 0) {
				gameOver();
			}
		}
	}
	private void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over! Your score is: " +score+ "Game Over", "GameOver", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	@Override 
	public void paint(Graphics g) { 
		super.paint(g);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.GREEN);
		g.fillRect(pipeX, 0, pipeWidth, pipeHeight);
		g.fillRect(pipeX, pipeHeight + gap, pipeWidth, getHeight()-pipeHeight - gap);
		
		g.setColor(Color.RED);
		g.fillRect(100, birdY, 50, 50);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Score"+score, 20, 20);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FlappyBirdGame().setVisible(true);
			}
		});
		

	}

}
