package com.Jakibah;

import java.awt.image.BufferedImage;

public enum LightType {
	
	Circle(Window.loadTexture("TestTile")), Square(Window.loadTexture("TestTile"));
	
	private BufferedImage image;
	
	LightType(BufferedImage image){
		this.setImage(image);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
