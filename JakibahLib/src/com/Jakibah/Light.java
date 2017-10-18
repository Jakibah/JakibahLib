package com.Jakibah;

public class Light {
	
	private int x, y, radius, brightness;
	
	public Light(int x, int y, int radius, int brightness){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.brightness = brightness;
	}
	
	public static int getDayLight(){
		int toreturn = 250;
		
		return toreturn;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

}
