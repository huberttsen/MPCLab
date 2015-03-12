
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;


public class scene extends JFrame {
	
	//Instantiation Variables
	private double time = 0;
	private projectile ball;
	private BufferedImage buffered;
	private int xVel, yVel; 
	private boolean fireSwitch = false;
	private boolean animation = true;
	private int pointScore=0;
	private boolean hitcheck = false;
	
	//Random target setup
	private int targetY1;
	private int targetY2;
	private int targetY3;
	private int startX = 0, startY = 300;
	
	//Constructor
	public scene() {
		
		//Title and housekeeping
		super("Winter Palace");

		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Generates 3 spaced targets, and starting
		targetGen();
				
		//Creates the start of the projectile
		projectile ball = new projectile();
		ball.setStart(startX, startY);
		
		
	}
	
	public void paint(Graphics window) {
		
		//---- Double buffering setup ----
		if(buffered==null)
 			buffered = (BufferedImage)(createImage(getWidth(),getHeight()));
		
		Graphics windowTemp = buffered.createGraphics();
		
		//---- Background fill ----
		windowTemp.setColor(Color.WHITE);
		windowTemp.fillRect(0, 0, 600, 600);
		
		//Check for hit
		hitDetect();
		
		//---- Starts the projectile ----
		if (fireSwitch == true){
			
			ball.startVel(xVel, yVel);
			ball.drawMe(window, time, windowTemp);
			
		}
		
		//---- Targets ----
		windowTemp.setColor(Color.YELLOW);
		windowTemp.fillRect(500, targetY1, 25, 25);
		windowTemp.fillRect(500, targetY2, 25, 25);
		windowTemp.fillRect(500, targetY3, 25, 25);
		
		//---- OnScreen Points -----
		windowTemp.setColor(Color.BLACK);
		Font font = new Font("Arial", Font.PLAIN, 36);
		windowTemp.setFont(font);
		windowTemp.drawString("Score: " + pointScore, 100, 100);
		
		//---- Draws final buffered image ----
		window.drawImage(buffered, 0, 0, null);
	}
	
	public void animate() {
		
		while(animation==true) {
			
			//Changes the time for the projectile
			time+=.1;
			
			//Wait
			try {
			    Thread.sleep(7);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			
			repaint();
		}
	}
	
	
	public void setVelocity(int xIN, int yIN){
		
		//sets up the velocity
		xVel = xIN;
		yVel = yIN;
		
		//makes the projectile fire and move
		fireSwitch = true;
		animation = true;
		hitcheck = false;
		
	}
	
	private void targetGen() {
		
		//Randomly generates targets
		targetY1=(int)(Math.random()*150+30);
		targetY2=(int)(Math.random()*200+200);
		targetY3=(int)(Math.random()*145+425);
		
		startX=(int)(30);
		startY=(int)(Math.random()*500+50);
		
	}
	
	private void hitDetect(){
		
		int x = ball.xAccess(fireSwitch);
		int y = ball.yAccess(fireSwitch);
		
		//Target 1
		if (x>=500 && x<=525 && y<targetY1+20 && y>targetY1) {
			hitcheck = true;
			pointScore++;
			breakResetAll(hitcheck);
		}
		
		//Target 2
		if (x>=500 && x<=525 && y<targetY2+20 && y>targetY2) {
			hitcheck = true;
			pointScore++;
			breakResetAll(hitcheck);
		}
		
		//Target 3
		if (x>=500 && x<=525 && y<targetY3+20 && y>targetY3) {
			hitcheck = true;
			pointScore++;
			breakResetAll(hitcheck);
		}
		
		//breaks the animation
		if ((x>600 || y>600) && hitcheck==false){
			pointScore--;
			breakResetAll(hitcheck);
		}
		
	
	}
	
	//Breaks the animation, resets coordinates, etc
	private void breakResetAll(boolean hit){
		
		targetGen();
		fireSwitch = false;
		animation= false;
		time=0;
		ball.setStart(startX, startY);
		if (hit == true){
			
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		
	
	}
	
}