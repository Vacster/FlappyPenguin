package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Penguin extends Image{

	float Xpos = 50, Ypos = 50;
	float Yvel = 2, Yacc = -0.098f;
	
	public Penguin(Texture text) {
		super(text);
		setPosition(Xpos, Ypos);
		setSize(198, 92);
	}
	
	@Override
	public void act(float delta) {
		Yvel += Yacc;
		
		setPosition(Xpos, Ypos+=Yvel);
		if(Ypos < 0)
		{
			Ypos = 800;
		}
		if(Yvel < -7.5f)
		{
			Yvel = -7.5f;
		}
	}
	
}
