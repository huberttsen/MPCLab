package com.mpc.objects;

import java.awt.Rectangle;
import java.awt.Polygon;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.particles.*;
import org.newdawn.slick.svg.inkscape.PolygonProcessor;

public class Cannon extends ConfigurableEmitter {
//public class Cannon extends Image{

	// protected float x;
	protected float angle;
	protected float power;
	protected float xPos;
	protected float yPos;
	protected static String projectileFileName;

//	public Cannon(String cannonFileName, float xPos, float yPos, float angle,
//			float power) {
		// this.x = 0;
		// super(cannonFileName);
//		this.angle = angle;
//		this.xPos = xPos;
//		this.yPos = yPos;
//		this.power = power;
//	}

	public Cannon(String name){
		super(projectileFileName);		
	}

	public void release() {
		Projectile projectile = new Projectile(projectileFileName, xPos,
				yPos, angle, power);
		projectile.shoot();
	}

	public Vector2f getLocation() {
		return new Vector2f(xPos, yPos);
	}

	public void setPosition(float x, float y) {
		xPos = x;
		yPos = y;
	}

}
