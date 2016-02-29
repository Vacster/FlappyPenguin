package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tubo extends Image{

	Sprite UpTubo, DownTubo, penguinSprite;
	float Ypos, Xpos = 500;
	static int minY = 350, maxY = 700, gap = 200, puntos = 0;
	Penguin penguin;
	
	public Tubo(Texture text, Penguin penguin) {
		UpTubo = new Sprite(text);
		DownTubo = new Sprite(text);
		
		penguinSprite = penguin.sprite;
		this.penguin = penguin;
		
		Ypos = MathUtils.random(minY, maxY);
		
		UpTubo.setPosition(Xpos, Ypos);
		
		DownTubo.setPosition(Xpos, Ypos-gap-DownTubo.getHeight());
		UpTubo.flip(false, true);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		UpTubo.draw(batch);
		DownTubo.draw(batch);
	}
	
	@Override
	public void act(float delta) {
		UpTubo.setPosition(Xpos -= 5, Ypos);
		DownTubo.setPosition(Xpos, Ypos-gap-DownTubo.getHeight());
		
		if(Xpos <= -UpTubo.getWidth())
		{
			Xpos = 450;
			Ypos = MathUtils.random(minY, maxY);
			puntos++;
			System.out.println(puntos);
		}
		
		if(UpTubo.getBoundingRectangle().overlaps(penguinSprite.getBoundingRectangle())
				|| DownTubo.getBoundingRectangle().overlaps(penguinSprite.getBoundingRectangle()))
		{
			penguin.Ypos = 400;
			penguin.Yvel = 2;
			Xpos = 750;
			Ypos = MathUtils.random(minY, maxY);
			puntos = 0;
		}
	}
	
}
