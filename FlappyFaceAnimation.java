//Divya Sharma 
//Final ITCH 1 Project 
//Wissler 

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
	import java.util.ArrayList;
	import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.Timer;



public class FlappyFaceAnimation extends JPanel {
	private static final int WIDTH = 1600;
		private static final int HEIGHT = 1250;
		private static final Color LIGHT_BLUE = new Color(108, 210, 247);
		private BufferedImage image;
		private Graphics g;
		private Timer timer;
		private FlappyBall ball;
		//private FlappyBall ball1; 
		//private FlappyBall ball2; 
		//private FlappyBall ball3; 
		//private boolean a; 
		//private boolean b; 
		//private boolean c; 
		public static final String[] choices = {"Kyra", "Kundana", "Izzy"};   
		public String mapChoice;
		
		//private SideBumper red5;
		private boolean spacePressed; 
		private boolean quit; 
		SideBumper[] boulders;
		SideBumper[] bottom; 
		
		
		public void jump() {
			
			ball.setY(ball.getY()-10); 
			ball.setY(ball.getY()+10); 
			
		}
		
		public FlappyFaceAnimation() {
			
			image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			g = image.getGraphics();

			g.setColor(LIGHT_BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			// instantiate stuff
			
			mapChoice = (String)JOptionPane.showInputDialog(null,"Choose your character.", "Characters", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
			
			boulders = new SideBumper[4]; 
			bottom = new SideBumper[4];
			int gap = 100; 
			
			for(int i =0; i<boulders.length; i++) {
				int ysize = (int) (Math.random()*300+300);
				boulders[i] = new SideBumper(1600+gap,0,200,ysize,Color.blue);	
				bottom[i] = new SideBumper(1600+gap, ysize+450,200,1000,Color.green); 
				boulders[i].draw(g); 
				bottom[i].draw(g);
				gap = gap+600; 
		
			}
			
			/*bottom = new SideBumper[4]; 
			for(int i =0; i<bottom.length; i++) {
				int ysize = (int) (Math.random()*500+300);
				boulders[i] = new SideBumper(1600+gap,HEIGHT,200,ysize,Color.blue);
				boulders[i].draw(g); 
				gap = gap+500; 
		
			}
			*/
			
			/*boulders = new ArrayList<>();
			 * 
			 */
			//red5= new SideBumper(1300, 0, 200, 400, Color.RED);
			
		
			//boulders.add(red5);
			//red5.setSpeed(10);
			
			
			
			spacePressed = false; 
			ball = new FlappyBall(600, 500, 100, Color.BLACK);
			ball.setXSpeed(0);
			ball.setYSpeed(-10);
			
			
			
			/*
			 * int gap = 100; 
			for (int i=0; i < 50; i++) {
					int ysize = (int) (Math.random()*500+300);
					boulders.add(new SideBumper(1600+gap,0,200,ysize,Color.blue));
					gap = gap +500; 
			}
			*/
		
			timer = new Timer(5, new TimerListener());
			timer.start();
			addKeyListener(new Keyboard());
			setFocusable(true);

		}
		public void updateKeyInput() {
			if (spacePressed ==true) {
				ball.setY(ball.getY()-40); 
				ball.draw(g);	
			}
			
			if (quit ==true) {
				timer.stop(); 
			}
			
			
		}
		
		
	private class Keyboard implements KeyListener {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() ==KeyEvent.VK_SPACE) {
					spacePressed = true; 
				}
				
				/*
				if (e.getKeyCode() ==KeyEvent.VK_Q) {
					quit = true; 
				}
				if (e.getKeyCode() ==KeyEvent.VK_A) {
					a = true; 
				}
				if (e.getKeyCode() ==KeyEvent.VK_B) {
					b = true; 
				}
				if (e.getKeyCode() ==KeyEvent.VK_C) {
					c = true; 
				}
				*/
			
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() ==KeyEvent.VK_SPACE) {
					spacePressed = false; 
				}
				
				
			}
			
		}

		private class TimerListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				// draw background / clear screen
				g.setColor(LIGHT_BLUE);
				g.fillRect(0, 0, WIDTH, HEIGHT);
				
				
				if (mapChoice.equals("Kyra")){
					//ball = new FlappyBall(300, 500, 100, Color.WHITE);
				    ball.draw(g);
				    ball.drawPic(g,"pic1.png");
			      } else if (mapChoice.equals("Kundana")){
			    	 // ball = new FlappyBall(300, 500, 100, Color.WHITE);
					    ball.draw(g);
					    ball.drawPic(g,"pic2.png");
			       } else if (mapChoice.equals("Izzy")){
			    	 //  ball = new FlappyBall(300, 500, 100, Color.WHITE);
					    ball.draw(g);
					    ball.drawPic(g,"pic3.png"); 
			      } 
				 

				
				/*g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 50));
			    g.setColor(Color.BLUE);
			    g.drawString("Choose your Character", 550, 320);
			    g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 20));
			    g.drawString("Press A for Character 1", 200, 600);
			    g.drawString("Press B for Character 2", 700, 600);
			    g.drawString("Press C for Character 3", 1200, 600);
			    */
			    
			/*
			    ball1 = new FlappyBall(300, 500, 100, Color.WHITE);
			    ball1.draw(g);
			    ball1.drawPic(g,"pic1.png");
			    
			    ball2 = new FlappyBall(800, 500, 100, Color.WHITE);
			    ball2.draw(g);
			    ball2.drawPic(g,"pic2.jpg");
			    
			    ball3 = new FlappyBall(1300, 500, 100, Color.WHITE);
			    ball3.draw(g);
			    ball3.drawPic(g,"pic3.jpg");
			    
		*/
				
				
				
				
				
				updateKeyInput();
				
			
				// move stuff / update locations
				ball.move(WIDTH, HEIGHT);
					
				for (int i=0; i < boulders.length; i++) {
					//System.out.println(boulders.get(i));
					boulders[i].setSpeed(30);
					boulders[i].move();
					boulders[i].draw(g);
					 
					bottom[i].setSpeed(30);
					bottom[i].move();
					bottom[i].draw(g);
					
					if (boulders[i].getX() == -100){
						boulders[i].setX(WIDTH + 100);
						boulders[i].setSize(); 
					}
					
					if (bottom[i].getX() == -100){
						bottom[i].setX(WIDTH + 100);
						bottom[i].setY(boulders[i].setSize()+450);
						 
					}
			      }
			
				/*if (a==true) {
					ball.draw(g);
					ball.drawPic(g,"pic1.png");
				}
				if (b==true) {
					ball.draw(g);
					ball.drawPic(g,"pic2.jpg");
				}
				if (c==true) {
					ball.draw(g);
					ball.drawPic(g,"pic3.jpg");
				}
				*/
				
				
				
				for (int i=0; i < boulders.length; i++) {
				
					g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
				    g.setColor(Color.pink);
				    int points = boulders[i].getPoints();
				    g.drawString("Points " + points , 1300, 50);
					
				}
				
				
				
				for (int i=0; i < boulders.length; i++) {
					if (boulders[i].inBumper(ball) ==true) {
						timer.stop(); 
						g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 100));
					    g.setColor(Color.RED);
					    g.drawString("YOU LOSE!", 575, 600);
						
				
						//System.out.println("hi");
					}
					
					if (bottom[i].inBumper1(ball) ==true) {
						timer.stop();  
						g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 100));
					    g.setColor(Color.RED);
					    g.drawString("YOU LOSE!", 575, 600);
					}
					
				}
			
				

	
				repaint();
			}
			
		}
		 
		
		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}

		public static void main(String[] args) {
			

			JFrame frame = new JFrame("Bumper!!!");
			frame.setSize(1200, 900);
			frame.setLocation(200, 50);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new FlappyFaceAnimation());
			frame.setVisible(true);
		}
	

}


