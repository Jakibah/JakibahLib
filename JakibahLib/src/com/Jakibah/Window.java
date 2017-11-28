package com.Jakibah;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.Jakibah.engine.Light;
import com.Jakibah.engine.Texture;
import com.Jakibah.input.Mouse;
import com.Jakibah.test.Player;

public abstract class Window {

	private static float width;
	private static float height;
	private String title;
	private static Graphics2D g;
	private static BufferStrategy buffer;
	public static int Xtrans;
	public static int Ytrans;

	public static ArrayList<Texture> texlighted = new ArrayList<Texture>();
	public static ArrayList<Texture> texunlighted = new ArrayList<Texture>();
	public static ArrayList<Texture> texlightedtoremove = new ArrayList<Texture>();
	public static ArrayList<Texture> texunlightedtoremove = new ArrayList<Texture>();
	public static ArrayList<Light> lights = new ArrayList<Light>();
	public static ArrayList<Light> lightstoremove = new ArrayList<Light>();
	public static ArrayList<Clip> sounds = new ArrayList<Clip>();

	public Window(String title, float width, float height) {
		this.setWidth(width);
		this.setHeight(height);
		this.setTitle(title);
	}

	public static void Render(Texture tex, int x, int y, boolean lighted) {
		if (lighted) {
			texlighted
					.add(new Texture(x, y, tex.getImage(), tex.isTranslated()));
		} else {
			texunlighted.add(new Texture(x, y, tex.getImage(), tex
					.isTranslated()));
		}
	}

	public static void UpdateImages() {
		for (Texture t : texlighted) {
			DrawTex(t);
			texlightedtoremove.add(t);
		}

		DrawTex(Lightning());
		

		for (Texture t : texunlighted) {
			DrawTex(t);
			texunlightedtoremove.add(t);
		}
	}

	public static void Prepare() {
		Main.canvas.createBufferStrategy(2);

	}

	public static void Translate(int x, int y) {
		Xtrans = x;
		Ytrans = y;
	}

	public static void StartDrawing() {
		buffer = Main.canvas.getBufferStrategy();
		g = (Graphics2D) buffer.getDrawGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Main.canvas.getWidth(), Main.canvas.getHeight());

	}

	private static Texture Lightning() {
		lights.removeAll(lightstoremove);
		lightstoremove.clear();
		BufferedImage lightmap = new BufferedImage((int)width, (int)height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gl  = lightmap.createGraphics();
		gl.setColor(new Color(0, 0, 0, Light.DayLight));
		gl.fillRect(0, 0, (int)width, (int)height);
		Composite oldComp = gl.getComposite();
		gl.setComposite(AlphaComposite.DstOut);
		for (Light light : lights){
			light.Render(gl);
		}
		gl.setComposite(oldComp);
		gl.dispose();
		return new Texture(0, 0, lightmap ,false);

	}

	// TODO draw text
	public static void DrawFont(String s, Color c, int x, int y) {
		g.setColor(c);
		Font f = new Font(Font.DIALOG, Font.PLAIN, 12);
		g.setFont(f);
		g.drawString(s, x, y);
	}

	public static void Output() {
		g.dispose();
		buffer.show();
		texlighted.removeAll(texlightedtoremove);
		texunlighted.removeAll(texunlightedtoremove);
		texlightedtoremove.clear();
		texunlightedtoremove.clear();

	}

	public static Clip loadAudio(String s) {
		Clip toreturn = null;
		AudioInputStream audioIn = null;
		try {
			audioIn = AudioSystem.getAudioInputStream(new File("src/res/audio/"
					+ s + ".wav"));
			toreturn = AudioSystem.getClip();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			toreturn.open(audioIn);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		return toreturn;
	}

	public static void PlaySound(Clip clip, int times) {

		clip.loop(times - 1);
		sounds.add(clip);

	}

	public static void StopSound() {

		for (Clip clips : sounds) {
			clips.stop();
		}
		sounds.clear();
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

	public static void DrawTex(Texture tex) {
		if (tex.isTranslated()) {
			g.drawImage(tex.getImage(),
					(tex.getX()) - Xtrans + Main.canvas.getWidth() / 2
							- tex.getImage().getWidth() / 2, (tex.getY())
							- Ytrans + Main.canvas.getHeight() / 2
							- tex.getImage().getHeight() / 2, tex.getImage()
							.getWidth(), tex.getImage().getHeight(),
					Main.canvas);
		} else {
			//g.drawImage(tex.getImage(), trans, Main.canvas);
			g.drawImage(tex.getImage(), tex.getX(), tex.getY(), tex.getImage().getWidth(), tex.getImage().getHeight(), Main.canvas);
		}
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
