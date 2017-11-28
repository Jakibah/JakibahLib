package com.Jakibah;

import java.awt.Canvas;

import javax.swing.JFrame;

import com.Jakibah.input.Keyboard;
import com.Jakibah.input.Mouse;
import com.Jakibah.test.TestApp;

public class Main {

	public static Thread t;
	public static JFrame frame = new JFrame();
	public static Canvas canvas = new Canvas();
	public static TestApp app;
	public static boolean running = false;
	public static long runtime;
	public static int fps;
	public static long fpsstart = 0;
	public static int fpslasts = 0;
	public static Keyboard key;
	
	
	
	//animations
	//rotation
	//particles
	//collision
	//text

	public static void Boot(TestApp app) {
		Main.app = app;
		t = new Thread(new Runnable() {

			@Override
			public void run() {
				Start();
			}

		});
		t.setName("Logic Thread");
		t.start();
	}
	
	

	public static void Start() {
		running = true;
		//Todo Edit "TestApp" to be the right App type
		canvas.setSize((int)app.getWidth(), (int)app.getHeight());
		canvas.setVisible(true);
		frame.add(canvas);
		frame.setSize((int)app.getWidth(), (int)app.getHeight());
		frame.setTitle(app.getTitle());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.requestFocus();
		app.Start();
		key = new Keyboard();
		canvas.addKeyListener(key);
		Mouse mouse = new Mouse();
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		
		
		
		while (running) {
			if(fpsstart == 0){
				fpsstart = System.currentTimeMillis();
			}
			long starttime = System.currentTimeMillis();
			
			key.Update();
			Update();
			
			
			fps++;
			if(System.currentTimeMillis() - fpsstart >= 1000){
				fpslasts = fps;
				fps = 0;
				fpsstart = System.currentTimeMillis();
			}
			runtime = System.currentTimeMillis() - starttime;
			frame.setTitle(app.getTitle() + "     " + runtime + " ms/f" + "     " + fpslasts + " fps" + "     " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024*1024) + " mB");
		}
		Stop();
	}

	public static void Update() {
		
		app.Update();
	}
	
	public static void Stop(){
		app.Stop();
		t.stop();
	}

	public App getApp() {
		return app;
	}

	public void setApp(TestApp app) {
		this.app = app;
	}

}
