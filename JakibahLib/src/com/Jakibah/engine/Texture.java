package com.Jakibah.engine;

import java.awt.image.BufferedImage;

public class Texture {
	
	private int x, y;
	private BufferedImage image;
	private boolean translated;
	
	public Texture(int x, int y, BufferedImage image, boolean translated){
		this.setX(x);
		this.setY(y);
		this.setImage(image);
		this.translated = translated;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
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

	public boolean isTranslated() {
		return translated;
	}

	public void setTranslated(boolean translated) {
		this.translated = translated;
	}

}
