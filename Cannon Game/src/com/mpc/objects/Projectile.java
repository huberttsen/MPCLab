package com.mpc.objects;

//package slick.OpenShooter.game.entities.projectiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
//
import org.newdawn.slick.particles.*;

//import slick.OpenShooter.game.entities.SuperObject;

public class Projectile {
	protected Image sprite = null;
	protected float initX;
	protected float initY;
	protected float velY;
	protected float velX;
	protected float gravity = 20f;

	protected float x;
	protected float y;

	public Projectile(String projectileFileName, float initX, float initY,
			float power, float angle) {

		this.x = initX;
		this.y = initY;

		this.velX = (float) (Math.cos(angle) * power);
		
		this.velY = (float) (Math.sin(angle) * power);

		try {
			sprite = new Image(projectileFileName);
		} catch (SlickException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void shoot() {
		
		while (true){
			velY -= gravity;
			y += velY;
			x += velX;
		}
	}

	// @Override
	public int getWidth() {
		return sprite.getWidth();
	}

	// @Override
	public int getHeight() {
		return sprite.getHeight();
	}
	

	public boolean intersects(Target target) {
		Rectangle rect = new Rectangle(x, y, sprite.getWidth(),
				sprite.getHeight());

		if (rect.intersects(target.getRect())) {
			return true;
		}
		return false;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
	}

}