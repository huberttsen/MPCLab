package com.mpc.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.mpc.objects.Cannon;
import com.mpc.objects.Projectile;
import com.mpc.objects.Target;

public class Play extends BasicGameState {

	Image cannonImg;
	Image targetImg;
	Image projImg;
	Cannon cannon;
	Target target;
	Projectile proj;
	float cannonRadius;

	public Play() {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		cannon = new Cannon(25, 600);
		cannonImg = new Image("./resources/images/cannon0.png");
		target = new Target(1100,600);
		targetImg = new Image("./resources/images/Target.png");
		cannonImg.setCenterOfRotation(cannonImg.getCenterOfRotationX(), cannonImg.getCenterOfRotationY());
		proj = new Projectile(30, 600, 0, 0);
		projImg = new Image("./resources/images/Particle.png");
		cannonRadius = cannonImg.getWidth()/2;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setBackground(Color.lightGray);
		g.setColor(Color.white);
		g.drawString("Play State", 50, 50);
		g.drawImage(cannonImg, cannon.getX(), cannon.getY());
		g.drawImage(targetImg,target.getX(), target.getY());
		g.drawString("Angle: "+ String.valueOf(cannon.getAngle()), 50, 100);
		//double ang = (double) cannon.getAngle();
		//float projX = (float) (cannon.getX() + Math.cos(ang) * cannonRadius); 
	    //float projY = (float) (cannon.getY() + Math.sin(ang) * cannonRadius);
		//g.drawImage(projImg, projX, projY);
		Input userInput = gc.getInput();
		float mouseX = userInput.getMouseX();
		float mouseY = userInput.getMouseY();
		g.drawString("mouseX: "+ String.valueOf(mouseX), 50, 140);
		g.drawString("mouseY: "+ String.valueOf(mouseY), 50, 155);
		//g.drawString("centerX: "+ String.valueOf(cannonImg.getCenterOfRotationX()), 50, 180);
		//g.drawString("centerY: "+ String.valueOf(cannonImg.getCenterOfRotationY()), 50, 195);
		g.drawOval(35, 630, 10, 10);
		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input userInput = gc.getInput();
		float mouseX = userInput.getMouseX();
		float mouseY = userInput.getMouseY();
		float xDistance = mouseX - 35;
		float yDistance = 630 - mouseY;
		double rad = Math.atan2(yDistance, xDistance);
		double angleToTurn = rad * 180 / Math.PI;
		cannonImg.setRotation((float) angleToTurn);
		cannon.setAngle((float) angleToTurn);
		
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
