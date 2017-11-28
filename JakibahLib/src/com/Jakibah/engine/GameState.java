package com.Jakibah.engine;

import java.util.ArrayList;

public abstract class GameState {
	
	private String name;
	
	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public GameState(String name){
		this.setName(name);
	}
	
	public abstract void Start();
	
	public  void Update(){
		for(GameObject o : objects){
			o.Update();
		}
	}
	
	public abstract void Stop();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
