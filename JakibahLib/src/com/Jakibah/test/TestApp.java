package com.Jakibah.test;

import java.util.ArrayList;

import com.Jakibah.App;
import com.Jakibah.Light;
import com.Jakibah.LightType;
import com.Jakibah.Main;
import com.Jakibah.Window;

public class TestApp extends Window implements App {
	

	public ArrayList<Light> lights = new ArrayList<Light>();
	Light light = new Light(0, 0, 100, 50, LightType.Circle);
	
	public TestApp(){
		super("Test", 800, 600);
	}
	
	public static void main(String[] args){
		Main.Boot(new TestApp());
	}
	
	
	public void Start(){
		Window.Prepare();
		Player.Init();
		lights.add(light);
		//Reciever.Init();
		
	}
	
	public void Update(){
		Window.StartDrawing();
		Window.Translate(Player.getX(), Player.getY());
		//Draw after this
		for(int i = 0; i < 10; i++){
			for(int j =0; j < 10; j++){
				Window.DrawTex(Player.getTexture(), i*32, j*32, true);
		}
		}
		Player.Update();
		light.setX(Player.getX() + 16);
		light.setY(Player.getY() + 16);
		//Draw before this
		Window.Output();
	}
	
	public void Stop(){
		
		
	}

}
