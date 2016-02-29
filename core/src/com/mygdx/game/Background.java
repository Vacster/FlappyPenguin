package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Background extends Image{

	float Xpos;
	
	public Background(Texture text, boolean primero) {
		super(text);
		setSize(450, 800);
		if(primero == true){
			setPosition(0, 0);
		}else{
			setPosition(450, 0);
		}
		
		Xpos = getX();
	}
	
	@Override
	public void act(float delta) {
		setPosition(Xpos-=5, 0);
		if(Xpos <= -450)
		{
			Xpos = 450;
		}
	}
	
}
