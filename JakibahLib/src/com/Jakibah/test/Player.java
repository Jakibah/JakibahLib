package com.Jakibah.test;

import java.awt.image.BufferedImage;

import com.Jakibah.Window;

public class Player {
	
	private static int x;
	private static int y;
	private static BufferedImage texture;
	
	public static void Init(){
		x = 0;
		y = 0;
		texture = Window.loadTexture("TestTile");
	}
	
	public static void Move(int xa, int ya){
		x+=xa;
		y+=ya;
	}
	
	public static void Update(){
		Window.DrawTex(texture, x, y, false);
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Player.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Player.y = y;
	}

	public static BufferedImage getTexture() {
		return texture;
	}

	public static void setTexture(BufferedImage texture) {
		Player.texture = texture;
	}
	
}
	
	