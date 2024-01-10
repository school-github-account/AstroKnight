package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game implements KeyListener{

	JFrame window;
	DrawPanel panel;

	Timer timer;
	int T_SPEED = 10;

	Character player;
	Platform platform;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}

	public Game() {

		// set up game frame
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new DrawPanel();

		window.addKeyListener(this);

		player = new Character(400, 0, 100, 100);
		platform = new Platform (200, 100, 300, 30);

		window.add(panel);

		window.pack();
		window.setResizable(false);
		window.setVisible(true);

		timer = new Timer(T_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				player.move();
				panel.repaint();
				System.out.println(player.y);

			}
		});
		timer.start();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			player.yy -= 100;
			platform.yy -= 100;
		}
		else if (key == KeyEvent.VK_DOWN) player.y += 10;
		else if (key == KeyEvent.VK_LEFT) {
			player.x -= 10;
		}
		else if (key == KeyEvent.VK_RIGHT) {
			//player.x += 10;
			platform.x -= 10;
		}

		//Update the x of rectangle. Ensure rectangle stays within screen
		if (player.x > (panel.panW - player.width)) player.x = (panel.panW - player.width);
		else if (player.x < 0) player.x = 0;

		//Update the y of rectangle. Ensure rectangle stays within screen
		if (player.y > (panel.panH - player.height)) player.y = (panel.panH - player.height);
		else if (player.y < 0) player.y = 0;

		panel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private class DrawPanel extends JPanel {
		int panW, panH;

		DrawPanel() {
			panW = 800;
			panH = 500;
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.black);

		}
		public void paintComponent(Graphics g) {
			panW = this.getWidth();
			panH = this.getHeight();

			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2d.setPaint(Color.BLUE);
			g2d.fillRect(player.x,  player.y,  player.width,  player.height);

			g2d.setPaint(Color.GREEN);
			g2d.fillRect(platform.x, platform.y, platform.width, platform.height);
		}
	}

	private class Character extends Rectangle {

		Color c;
		double yy;
		static double vy = 2.5;
		static final double g = 0.01;

		Character(int x, int y, int width, int height) {
			super(x, y, width, height);

			yy = (double)y;

			c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
		}
		void move() {

			yy += vy;

			vy = vy + g;

			// if ball hits the bottom
			if (yy > panel.panH - height) {
				yy = panel.panH - height;
				vy = 0;

			}

			y = (int)yy;
		}

	}
	
	private class Platform extends Rectangle { 
		
		Color c;
		double yy;
		static double vy = 2.5;

		Platform(int x, int y, int width, int height) {
			super(x, y, width, height);

			yy = (double)y;

			c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
		}
	}
}

