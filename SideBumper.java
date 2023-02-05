//Divya Sharma 
//Final ITCS 1 Project 
//Wissler 
//June 2021
//Side Bumper EXTENDS bumper with additions of move method< set size, set speed  
import java.awt.Color;
import java.awt.Graphics;



public class SideBumper extends Bumper {
	private int speed;
	
	
	//constructors 
	public SideBumper(int x, int y, int width, int height, Color color) {
		super(x,y,width,height,color); 
	}
	
	public SideBumper() {
		super();
	}
	
	//extra methods 
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed (int spe) {
		speed=spe;  
		
	}
	public void move() {
		
		
		setX(getX()-getSpeed()); 
	}
	
	public int setSize() {
		
		int ysize = (int) ((Math.random()*200+200)); 
		setHeight(ysize);
		return ysize;
		
	}
	
 
	//Draw the bumper with reference point being top middle
	public void draw(Graphics g) {
		g.setColor(getColor()); 
		int rectxcenter = getX()-(getWidth()/2); 
		g.fillRect(rectxcenter,getY(),getWidth(),getHeight());
		
	}
	
}