package com.mpc.objects;



import org.newdawn.slick.Image; 
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Projectile {
	protected Image sprite = null;
	protected float velY;
	protected float velX;
	protected float gravity = 20f;

	protected float x;
	protected float y;

	public Projectile() throws SlickException{
		sprite = new Image("./resources/images/Particle.png");
	}
	
	public Projectile(float initX, float initY,
			float power, float angle) {
		this.x = initX;
		this.y = initY;

		this.velX = (float) (Math.cos(angle) * power);
		
		this.velY = (float) (Math.sin(angle) * power);

	}
	
	
	public void shoot() {
		
		while (y != 700){
			velY -= gravity;
			y += velY;
			x += velX;
		}
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
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