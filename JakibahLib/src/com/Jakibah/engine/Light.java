package com.Jakibah.engine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.Jakibah.Main;
import com.Jakibah.Window;

public class Light {
	
	public static int DayLight = 150;
	
	private int x, y, radius;
	private float brightness;
	private BufferedImage image;
	public Light(int x, int y, int radius, float brightness){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.brightness = brightness;
		image = new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		
		for(int i = 0; i < radius; i++){
			double luma = 1.0D - ((i + 0.001) / radius);
			int alpha = Math.min((int)(255.0D * luma * brightness), 255);
			g2.setColor(new Color(0 ,0, 0, alpha));
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(radius-i, radius-i, i * 2,  i* 2);
			//g2.dispose();
		}
		Window.lights.add(this);
	}
	
	public void Render(Graphics2D G){
		G.drawImage(getImage(),
				(getX()) - Window.Xtrans + Main.canvas.getWidth() / 2
						- getImage().getWidth() / 2, (getY())
						- Window.Ytrans + Main.canvas.getHeight() / 2
						- getImage().getHeight() / 2, getImage()
						.getWidth(), getImage().getHeight(),
				Main.canvas);
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

	public float getBrightness() {
		return brightness;
	}

	public void setBrightness(float brightness) {
		this.brightness = brightness;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
