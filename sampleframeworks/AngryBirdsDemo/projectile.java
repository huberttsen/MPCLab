
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class projectile {
	
	// x and y positions of the proj
	private int x =0;
	private int y =0;
	
	//Staring velocity
	private double intXspeed;
	private double intYspeed;

	//Constructor sets up starting position
	private int intXposition;
	private int intYposition;
	
	//Gravity
	private double gravity = .8;
	
	
	public void setStart(int xInput, int yInput) {
		
		//Sets up both to be same
		x = xInput;
		y = yInput;
		
		intXposition = xInput;
		intYposition = yInput;
		
		
	}

	public void drawMe(Graphics window, double time, Graphics windowTemp) {
		
		//Sets the X and Y depending on the time
		x = xMotion(time);
		y = yMotion(time);

		//Draws the projectile
		windowTemp.setColor(Color.BLUE);
		windowTemp.fillOval(x, y, 5, 5);
		
	}
	
	//Calculates the x position from time
	private int xMotion(double time) {
		
		int xTemp = (int) (time * intXspeed) + intXposition;
		return xTemp;
	}

	//Calculates the y position from time
	private int yMotion(double time){
		
		int yTemp = (int) ((gravity * Math.pow(time,2)) - (intYspeed*time) + intYposition);
		return yTemp;
		
	}
	
	//Sets up the starting Velocity
	public void startVel (int xIN, int yIN) {
		
		intXspeed = xIN;
		intYspeed = yIN;
		
	}
	
	public int xAccess (boolean fireSwitch){
		
		if (fireSwitch == true){
			return x;
		}
		return 0;
	}
	
	public int yAccess(boolean fireSwitch){
		
		if (fireSwitch == true){
			return y;
		}
		return y;
	}
	
	public void resetCoord(){
		
		x=0;
		y=300;
	}
	

	
}