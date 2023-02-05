//Divya Sharma 
//Final ITCS 1 Project 
//Wissler 
//June 2021
//Bumper file (basis of Side Bumper) 

import java.awt.Color;
import java.awt.Graphics;

public class Bumper {

	private int x; 
	private int y; 
	private int height; 
	private int width;
	private Color color; 
	private int points; 
	

	
	
	public Bumper(int x, int y, int width, int height, Color color) {
		this.x = x; 
		this.y = y; 
		this.height = height; 
		this.width = width; 
		this.color = color; 
	}
	
	public Bumper() {
		this.x = 800; 
		this.y = 625; 
		this.height = 20;
		this.width = 20; 
		this.color = Color.blue; 
	}
	
	/**
	 * Returns true if any part of the Ball is inside the bumper
	 * @param ball the Ball
	 * @return true if any part of the Ball is inside the bumper, false otherwise
	 */

	/*public boolean inBumper(FlappyBall ball) {
		for (int x = getX() - getWidth()/2; x <= getX() + getWidth()/2; x++) {
			for (int y = getY() - getHeight()/2; y <= getY() + getHeight()/2; y++) {
				if (getDistance(x, y, ball.getX(), ball.getY()) <= ball.getRadius()) {
					return true;
				}
			}
		}
		return false;
	}
	*/
	
	public boolean inBumper(FlappyBall ball) {
	for (int x = getX() - getWidth()/2; x <= getX() + getWidth()/2; x++) {
		for (int y = 0; y <= getY() + getHeight()-40; y++) {
			if (getDistance(x, y, ball.getX(), ball.getY()) <= ball.getRadius()) {
				return true;
			}
		}
	}
	points = points+1; 
	return false;
	
}
	
	public boolean inBumper1(FlappyBall ball) {
		for (int x = getX() - getWidth()/2; x <= getX() + getWidth()/2; x++) {
			//change
			for (int y = getY(); y <= 1600; y++) {
				
				if (getDistance(x, y, ball.getX(), ball.getY()) <= ball.getRadius()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Calculates the distance between (x1, y1) and (x2, y2)
	 * @param x1 the x-coordinate of the first point
	 * @param y1 the y-coordinate of the first point
	 * @param x2 the x-coordinate of the second point
	 * @param y2 the y-coordinate of the second point
	 * @return the distance between (x1, y1) and (x2, y2)
	 */
	private double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	
	public int getX() { 
		return x; 
	}
	
	public int getY() { 
		return y; 
	}
	public int getPoints() { 
		return points; 
	}
	
	public int getWidth() { 
		return width; 
	}
	
	public int getHeight() { 
		return height; 
	}
	
	public Color getColor() { 
		return color; 
	}
	
	public void setY(int d) { 
		this.y = d; 
	}
	
	public void setX(int x) { 
		this.x = x; 
	}
	
	public void setWidth(int width) { 
		this.width = width; 
	}
	
	public void setHeight(int ysize) { 
		this.height = ysize; 
	}
	
	public void setColor(Color color) { 
		this.color = color; 
	}

	
	public void setLocation (int x, int y) {
		this.x=x; 
		this.y=y;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(color); 
		int rectxcenter = x-(width/2); 
		int rectycenter = y-(height/2);
		g.fillRect(rectxcenter,rectycenter,width, height);
		
	}
	

	
}