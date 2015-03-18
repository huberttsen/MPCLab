package com.mpc.game;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
//import java.applet.Applet;
//import java.awt.*;
//import java.awt.image.*;
//import java.io.*;
//import java.net.URL;
//import javax.imageio.*;



public class Game extends StateBasedGame {

	private static final String name = "Blaster";
	private static final int menu = 0;
	private static final int play = 1;
	private static Image img;

	public Game(String name) {
		super(name);
		this.addState(new Menu());
		this.addState(new Play());
		
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu); 
//		this.enterState(play); //Delete this after debugging

	}

	
	public static void main(String[] args) throws SlickException {
		AppGameContainer ac;

		try {
			ac = new AppGameContainer(new Game(name));
			ac.setDisplayMode(1280, 720, false);
			ac.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
