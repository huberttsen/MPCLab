package com.mpc.game;

import org.lwjgl.input.Mouse; 
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	
	public Menu() {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("This is the Cannon Game Menu", 50, 50);
		g.fillRect(50, 150, 50, 50);
		g.setColor(Color.black);
		g.drawString("Play", 57, 167);
		g.setBackground(Color.darkGray);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int xMouse = Mouse.getX();
		int yMouse = Mouse.getY();
		if ((xMouse > 50 && xMouse < 100) && (yMouse > 520  && yMouse < 570)) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}
	}

	@Override
	public int getID() {
		return 0;
	}
	
}

