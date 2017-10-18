package com.Jakibah.net;

import com.Jakibah.Main;

public class Reciever {

	public static boolean running = false;

	public static void Init() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Start();

			}

		});
		t.setName("Networking Thread");
		t.start();
	}

	public static void Start() {
		running = true;
		while (running) {
			if((Main.fps & 1) == 0){
			//System.out.println("Thread 2");
			}
			}

	}
}
