package com.Jakibah;

import com.Jakibah.engine.GameState;

public interface App {
	
	
	public default void Start(){
		
	}
	
	public default void Update(){
		
	}
	
	public default void Stop(){
		
	}
	public default GameState ChangeState(GameState oldstate, GameState newstate){
		if(oldstate != null){
			oldstate.Stop();
		}
		newstate.Start();
		Main.app.actieve = newstate;
		return newstate;
	}

}
