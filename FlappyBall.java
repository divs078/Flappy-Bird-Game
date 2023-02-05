//worked with kundana on bouncing ball to debug 
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class FlappyBall {

	// 1. Declaration of Variables
	
	private double x;			//x-coordinate of the center of the ball
	private double y;			//y-coordinate of the center of the ball
	private double diameter;	//diameter of the ball
	private double radius;		//radius of the ball = diameter/2
	private Color color;		//color of the ball
	private double xSpeed;		//x-speed = change in x-position
	private double ySpeed;		//y-speed = change in y-position

	
	// 2. Create a default constructor
	/**
	 * Default Constructor
	 * Creates a red ball at (0, 0) with a diameter of 25.  
	 * The default speed is 0.
	 */
	public FlappyBall() {
		
		this.x = 0; 
		this.y = 0; 
		this.color = Color.red;
		this.xSpeed = 0; 
		this.ySpeed = 0; 
		this.diameter = 25; 
		this.radius = 25/2; 	

	}
	

	// 3. Write a constructor that allows the user to input the parameters (x, y, diameter, Color)
	// and sets the x and y-speed = 0.  Comment with javadoc.
	
	/**
	 * constructor above 
	 * @param x
	 * @param y
	 * @param diameter
	 * @param color
	 */
			
	public FlappyBall(double x, double y, double diameter, Color color) { 
		
		this.x = x; 
		this.y = y; 
		this.color = color;
		this.xSpeed = 0; 
		this.ySpeed = 0; 
		this.diameter = diameter; 
		this.radius = diameter/2;
	}
		



	// 4. Create getters and setters for all private variables
	// Comment with javadoc
	
   /**
    * get x method
    * @return
    */
	public double getX() { 
		return x; 
	}
	
	/**
	 * get y method
	 * @return
	 */
	public double getY() { 
		return y; 
	}
	/**
	 * get diameter method
	 * @return
	 */
	public double getDiameter() { 
		return diameter; 
	}
	
	/**
	 * get radius method
	 * @return
	 */
	public double getRadius() { 
		return radius; 
	}
	
	/**
	 * get color method
	 * @return
	 */
	
	public Color getColor() { 
		return this.color; 
	}
	
	/**
	 * get x speed method
	 * @return
	 */
	public double getXSpeed() { 
		return xSpeed; 
	}
	
	/**
	 * gets the y speed of ball
	 * @return
	 */
	public double getYSpeed() { 
		return ySpeed; 
	}
	
	/**
	 * sets the x speed of the ball 
	 * @param x
	 */
	public void setX(double x) { 
		this.x = x; 
	}
	
	/**
	 * sets the y of the bal l
	 * @param y
	 */
	public void setY(double y) { 
		this.y = y; 
	}
	
	/** 
	 * sets the diameter 
	 * @param diameter
	 */
	public void setDiameter(double diameter) { 
		this.diameter = diameter;
		this.radius = diameter/2; 
	}
	
	/** sets the color of ball
	 * 
	 * @param color
	 */
	public void setColor(Color color) { 
		this.color = color; 
	}
	
	/** sets the x speed of ball
	 * 
	 * @param xSpeed
	 */
	public void setXSpeed(double xSpeed) { 
		this.xSpeed = xSpeed; 
	}
	/**
	 * sets the y speed of ball 
	 * @param ySpeed
	 */
	public void setYSpeed(double ySpeed) { 
		this.ySpeed = ySpeed; 
	}
	
	/** 
	 * sets the radius of the ball 
	 * @param radius
	 */
	public void setRadius(double radius) { 
		this.radius = radius; 
		this.diameter = 2*radius;
	}
	
	

	public void draw(Graphics g) {
		g.setColor(color); 
		int ballxcenter = (int) (x-(diameter/2)); 
		int ballycenter = (int) (y-(diameter/2));
		double diameter1 = diameter; 
		int diameter = (int) diameter1; 
		g.fillOval(ballxcenter,ballycenter,diameter,diameter);
		
	}
	
	
	/**
	 * Sets the center location of the ball
	 * @param x
	 * @param y
	 */
	public void setLocation(double x, double y) {
		this.x=x; 
		this.y=y; 
	}
	
	
	/**
	 * Generates a speed between -<code>maxSpeed<code>
	 * and <code>maxSpeed<code>
	 * @param maxSpeed
	 */
	public void setRandomSpeed(double maxSpeed) {
		int minSpeed = (int) (-1*maxSpeed); 
		this.xSpeed= (Math.random()*(maxSpeed*2)+minSpeed);
		this.ySpeed = (Math.random()*(maxSpeed*2)+minSpeed);
	}

	
	//7. Write the move method to make the ball move around the screen
	// and bounce of the edges.
	/**
	 * Comment....
	 * @param rightEdge
	 * @param bottomEdge
	 */
	
	public void setRandomLocation(double width, double height ) {
		
		setX(Math.random()*width);
		setY(Math.random()*height);
	}
	
public void setRandomColor() {
	
	int a = (int) (Math.random()*255); 
	int b = (int) (Math.random()*255); 
	int c = (int) (Math.random()*255); 
	Color rc = new Color(a,b,c);
	
		setColor(rc);
	}
	
	public void move(int rightEdge, int bottomEdge) {
		x = x+xSpeed;
		y= y-ySpeed; 
			
	}
	
	

	
	public void drawPic(Graphics g, String imageFileName) {
		ImageIcon image = new ImageIcon(imageFileName); 
		//int ximage = (int) (x-(diameter/3));
		//int yimage = (int) (y-(diameter/3));
		int xpic = (int) ((int) x-radius); 
		int ypic= (int) ((int) y-radius); 
		g.drawImage(image.getImage(), xpic, ypic, (int)diameter,(int) diameter, null); 
		
	}



}

