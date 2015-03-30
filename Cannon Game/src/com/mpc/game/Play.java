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
	Image cannonBaseImg;
	Cannon cannon;
	Target target;
	Projectile proj;
	boolean fired = false;
	float cannonRadius;
	float projX;
	float projY;

	public Play() {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		cannonBaseImg = new Image("./resources/images/cannonbase.png");
		cannon = new Cannon(55, 500);
		cannonImg = new Image("./resources/images/rect.png");
		target = new Target(1100,600);
		targetImg = new Image("./resources/images/Target.png");
		
		proj = new Projectile(30, 600, 0, 0);
		projImg = new Image("./resources/images/Particle.png");
		cannonRadius = (float) cannonImg.getWidth()/2;
		double ang = (double) cannon.getAngle();
		projX = (float) (cannon.getX() + Math.cos(ang) * cannonRadius); 
	    projY = (float) (cannon.getY() + Math.sin(ang) * cannonRadius);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setBackground(Color.darkGray);
		g.setColor(Color.white);
		g.drawString("Play State", 50, 50);
		
		g.drawImage(cannonBaseImg, 25, 600);
		g.drawImage(cannonImg, cannon.getX(), cannon.getY());
		
		g.drawImage(targetImg,target.getX(), target.getY());
		
		g.drawString("Angle: "+ String.valueOf(cannon.getAngle()), 50, 100);
		Input userInput = gc.getInput();
		float mouseX = userInput.getMouseX();
		float mouseY = userInput.getMouseY();
		g.drawString("mouseX: "+ String.valueOf(mouseX), 50, 140);
		g.drawString("mouseY: "+ String.valueOf(mouseY), 50, 155);
		
		if (fired) {
			projX = proj.getX();
			projY = proj.getY();
			g.drawImage(projImg, projX, projY);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input userInput = gc.getInput();
		float mouseX = userInput.getMouseX();
		float mouseY = userInput.getMouseY();
		
		if (userInput.isKeyPressed(Input.KEY_SPACE)) {
			fired = true;
			//proj.shoot();
		}
		
		float xDistance = mouseX - 95;
		float yDistance = 675 - mouseY;
		double rad = Math.atan2(yDistance, xDistance);
		double angleToTurn = rad * 180 / Math.PI;
		cannonImg.setCenterOfRotation(40, 170);
		cannonImg.setRotation((float) -angleToTurn);
		cannon.setAngle((float) angleToTurn);
		
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
