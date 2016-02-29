package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Piso extends Image{
	
	Sprite pisoSprite1, pisoSprite2, penguinSprite;
	Penguin penguin;
	Tubo tubo;
	
	public Piso(Texture text, Penguin penguin, Tubo tubo) {
		pisoSprite1 = new Sprite(text);
		pisoSprite2 = new Sprite(text);
		
		penguinSprite = penguin.sprite;
		this.penguin = penguin;
		this.tubo = tubo;
		
		pisoSprite1.setSize(450, 80);
		pisoSprite2.setSize(450, 80);
		
		pisoSprite1.setPosition(0, 0);
		pisoSprite2.setPosition(450, 0);
	}
	
	@Override
	public void act(float delta) {
		pisoSprite1.setX(pisoSprite1.getX()-5);
		pisoSprite2.setX(pisoSprite2.getX()-5);
		
		if(pisoSprite1.getX() <= -450)
		{
			pisoSprite1.setX(450);
		}
		if(pisoSprite2.getX() <= -450)
		{
			pisoSprite2.setX(450);
		}
		
		if(pisoSprite1.getBoundingRectangle().overlaps(penguinSprite.getBoundingRectangle())
			|| pisoSprite2.getBoundingRectangle().overlaps(penguinSprite.getBoundingRectangle()))
		{
			penguin.Ypos = 400;
			penguin.Yvel = 2;
			tubo.Xpos = 750;
			tubo.Ypos = MathUtils.random(tubo.minY, tubo.maxY);
			tubo.puntos = 0;
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		pisoSprite1.draw(batch);
		pisoSprite2.draw(batch);
	}
	
}
