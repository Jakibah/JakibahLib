package com.Jakibah.engine;

import java.awt.image.BufferedImage;

import com.Jakibah.Window;

public abstract class Tile extends GameObject {
	
	private boolean lighted;
	private Texture tex;

	public Tile(int x, int y, Texture tex, boolean lighted) {
		super(x, y);
		this.lighted = lighted;
		this.tex = tex;
	}

	@Override
	public void Update() {
		Window.Render(tex, this.getX(), this.getY(), lighted);

	}

}
