package com.mpc.objects;

import java.awt.Rectangle;
import java.awt.Polygon;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.particles.*;
import org.newdawn.slick.svg.inkscape.PolygonProcessor;

public class Cannon {

	// protected float x;
	protected float angleY;
	protected float power;
	protected float xPos;
	protected float yPos;
	protected String projectileFileName;

	public Cannon(String cannonFileName, String projectileFileName, float xPos, float yPos,
			float angleY, float power) {
		// this.x = 0;
		super();
		this.angleY = angleY;
		this.xPos = xPos;
		this.yPos = yPos;
		this.projectileFileName = projectileFileName;
		this.power = power;
		

	}

	public void release(){
		Projectile projectile = new Projectile(this.projectileFileName, xPos, yPos, power, angleY);
		projectile.shoot();
	}

	

}
