package com.Jakibah;

public class Light {
	
	private int x, y, radius, brightness;
	private LightType type;
	
	public Light(int x, int y, int radius, int brightness, LightType type){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.brightness = brightness;
		this.type = type;
	}
	
	public static int getDayLight(){
		int toreturn = 150;
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
