package com.Jakibah.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.Jakibah.Main;
import com.Jakibah.test.Player;

public class Keyboard {
	
	
	public static KeyListener listener = new KeyListener(){

		@Override
		public void keyTyped(KeyEvent e) {
			
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("A button has been pressed");
			if(e.getKeyCode() == KeyEvent.VK_W){
				Player.Move(0, -4);
			}
			else if(e.getKeyCode() == KeyEvent.VK_A){
				Player.Move(-4, 0);
			}
			else if(e.getKeyCode() == KeyEvent.VK_D){
				Player.Move(4, 0);
			}
			else if(e.getKeyCode() == KeyEvent.VK_S){
				Player.Move(0, 4);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}
		
	};
	
	public static void Init(){
		Main.canvas.addKeyListener(listener);
	}

}
