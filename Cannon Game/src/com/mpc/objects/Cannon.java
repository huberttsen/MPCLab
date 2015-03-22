package com.mpc.objects;


public class Cannon {

	protected float angle;
	protected float power;
	protected float xPos;
	protected float yPos;

	public Cannon(float xPos, float yPos) {
		this.angle = 0;
		this.xPos = xPos;
		this.yPos = yPos;
		this.power = 0;
	}



	public void release() {
		Projectile projectile = new Projectile(xPos, yPos, angle, power);
		projectile.shoot();
	}


	public void setPosition(float x, float y) {
		xPos = x;
		yPos = y;
	}
	
	public void setAngle(float a) {
		angle = a;
	}
	
	public float getAngle() {
		return angle;
	}
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public void setPower(float pwr) {
		power = pwr;
	}

}
