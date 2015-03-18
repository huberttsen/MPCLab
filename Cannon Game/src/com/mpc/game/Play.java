package com.mpc.game;

import java.awt.Graphics2D;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.mpc.objects.Cannon;

public class Play extends BasicGameState {
	// private static Image img;

	Image map;
	Image gun;
	boolean quit = false;
	Cannon cannon;

	public Play() {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		cannon = new Cannon("Blaster");
		cannon.setPosition(50, 650);
		

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setBackground(Color.blue);
		g.setColor(Color.white);
		g.drawString("Play State", 50, 50);
		gun = new Image("./res/Cannon.png");
		g.drawImage(gun, 50, 650);

		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		gun = new Image("./res/Cannon.png");
//		gun.draw(50,650);
		Input userInput = gc.getInput();
		float mouseX = userInput.getMouseX();
		float mouseY = userInput.getMouseY();

		/* Cannon Rotation suite */
		// TODO: Not working.

		Vector2f gunLocation = cannon.getLocation();
		float xDistance = mouseX - gunLocation.x;
		float yDistance = gunLocation.y - mouseY;
		double angleToTurn = Math.toDegrees(Math.atan2(yDistance, xDistance));
		gun.setCenterOfRotation(45, 600);
		gun.setRotation((float) angleToTurn);
		
		cannon.angularOffset.setValue((float) angleToTurn);
		gun.draw(50, 650);


	}

	@Override
	public int getID() {
		return 1;
	}

}
