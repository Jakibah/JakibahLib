package com.Jakibah;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.Jakibah.test.Player;

public abstract class Window {

	private float width, height;
	private String title;
	private static Graphics g;
	private static BufferStrategy buffer;
	private static int Xtrans;
	private static int Ytrans;

	public Window(String title, float width, float height) {
		this.setWidth(width);
		this.setHeight(height);
		this.setTitle(title);
	}

	public static BufferedImage loadTexture(String s) {
		BufferedImage toreturn = null;
		try {
			toreturn = ImageIO.read(new File("src/res/textures/" + s + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toreturn;
	}

	public static void Prepare() {
		Main.canvas.createBufferStrategy(2);
		
	}
	
	public static void Translate(int x, int y){
		Xtrans = x;
		Ytrans = y;
	}

	public static void StartDrawing() {
		buffer = Main.canvas.getBufferStrategy();
		g = buffer.getDrawGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Main.canvas.getWidth(), Main.canvas.getHeight());
		
	}
	public static void Output(){
		g.dispose();
		buffer.show();
	}
	public static void DrawTex(BufferedImage image, int x, int y , boolean lighted) {
		g.drawImage(image, (x) - Xtrans + Main.canvas.getWidth() / 2 - 16,
				(y) - Ytrans + Main.canvas.getHeight() / 2 - 16, 32, 32, Main.canvas);
		
	}

	/*
	 * public static void DrawTex(BufferedImage image, int x, int y, boolean
	 * lighted) { for (int j = 0; j < image.getHeight(); j++) { for (int i = 0;
	 * i < image.getWidth(); i++) { int color = image.getRGB(i, j);
	 * 
	 * int red = (color & 0x00ff0000) >> 16; int green = (color & 0x0000ff00) >>
	 * 8; int blue = (color & 0x000000ff); int alpha = (color>>24) & 0xff;
	 * if(lighted){ int lamp = 0; for(Light l : Main.app.lights){ int xdist =
	 * x+i-l.getX(); int ydist = y+j-l.getY();
	 * 
	 * if(xdist > -l.getRadius() && xdist < l.getRadius()){ if(ydist >
	 * -l.getRadius() && ydist < l.getRadius()){ lamp = lamp +
	 * l.getBrightness(); } } } red = red - Light.getDayLight() + lamp; green =
	 * green - Light.getDayLight() + lamp; blue = blue - Light.getDayLight()+
	 * lamp;
	 * 
	 * if(red < 0){ red = 0; } if(green < 0){ green = 0; } if(blue < 0){ blue =
	 * 0; } } Color c = new Color(red, green, blue, alpha); g.setColor(c);
	 * //g.fillRect((i + x) - Player.getX() + Main.canvas.getWidth() / 2 - 16,
	 * (j + y) - Player.getY() + Main.canvas.getHeight() / 2 - 16, 1, 1);
	 * g.drawLine((i + x) - Player.getX() + Main.canvas.getWidth() / 2 - 16,(j +
	 * y) - Player.getY() + Main.canvas.getHeight() / 2 - 16, (i + x) -
	 * Player.getX() + Main.canvas.getWidth() / 2 - 16, (j + y) - Player.getY()
	 * + Main.canvas.getHeight() / 2 - 16); } } }
	 */

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
