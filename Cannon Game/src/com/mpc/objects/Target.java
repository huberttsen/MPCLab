package com.mpc.objects;

import org.newdawn.slick.Image; 
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Target {
	protected Image target = null;
	protected float x;
	protected float y;
	protected float vely;
	protected float velx;
	
	
	public Target(float x, float y) throws SlickException{
		target = new Image("./resources/images/Target.png");
		this.x = x;
		this.y = y;
		
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public boolean intersects(Projectile projectile) {
		Rectangle targ = new Rectangle(x, y, target.getWidth(), target.getHeight());
		
		if(targ.intersects(projectile.getRect())){
			return true;
		}
		
		return false;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, target.getWidth(), target.getHeight());
	}
	
	
}
