package com.Jakibah.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.Jakibah.Main;

public class Mouse {
	
	private static int MouseX = 0;
	private static int MouseY = 0;
	
	public static MouseListener clistener = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}
		
	};
	
	public static MouseMotionListener mlistener = new MouseMotionListener(){

		@Override
		public void mouseDragged(MouseEvent e) {
			
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			MouseX = e.getX();
			MouseY = e.getY();
			//System.out.println(MouseX + ", " + MouseY);
			
		}
		
	};
	
	public static void Init(){
		Main.canvas.addMouseListener(clistener);
		Main.canvas.addMouseMotionListener(mlistener);
	}

	public static int getMouseX() {
		return MouseX;
	}

	public static int getMouseY() {
		return MouseY;
	}

}
