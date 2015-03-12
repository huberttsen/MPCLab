package com.mpc.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	private static final String name = "Blaster";
	private static final int menu = 0;
	private static final int play = 1;
	
	public Game(String name) {
		super(name);
		this.addState(Menu(menu));
		this.addState(Play(play));
		
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args) {
		AppGameContainer ac;
		try {
			ac = new AppGameContainer(new Game(name));
			ac.setDisplayMode(1600, 900, true);
			ac.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	
	
	

}
