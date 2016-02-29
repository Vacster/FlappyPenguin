package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Penguin extends Image{

	static float VelMax = -15.0f;
	float Xpos = 50, Ypos = 400;
	float Yvel = 2, Yacc = -0.25f;
	Sprite sprite;
	
	public Penguin(Texture text) {
		sprite = new Sprite(text);
		sprite.setPosition(Xpos, Ypos);
		sprite.setSize(100, 50);
		sprite.setOriginCenter();
	}
	
	@Override
	public void act(float delta) {
		Yvel += Yacc;
		
		sprite.setPosition(Xpos, Ypos+=Yvel);
		if(Ypos < 0)
		{
			Ypos = 800;
		}
		if(Yvel < VelMax)
		{
			Yvel = VelMax;
		}
		if(Gdx.input.isKeyJustPressed(Keys.SPACE))
		{
			Yvel = 7.5f;
		}
		
		sprite.setRotation(Yvel*3);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}
}
