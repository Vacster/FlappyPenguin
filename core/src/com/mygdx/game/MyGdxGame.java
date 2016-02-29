package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, backgroundimg, tuboimg, pisoimg;
	Stage stage;
	Actor penguin, background1, background2, tubo, piso;
	Viewport viewport;
	float Ypos = 0;
	
	@Override
	public void create () {
		img = new Texture("penguin.png");
		backgroundimg = new Texture("background.png");
		tuboimg = new Texture("pipe.png");
		pisoimg = new Texture("floor.png");
		
		viewport = new FitViewport(450, 800);
		stage = new Stage();
		
		background1 = new Background(backgroundimg, true);
		background2 = new Background(backgroundimg, false);
		penguin = new Penguin(img);
		tubo = new Tubo(tuboimg, (Penguin)penguin);
		piso = new Piso(pisoimg, (Penguin)penguin, (Tubo)tubo);

		stage.addActor(background1);
		stage.addActor(background2);
		stage.addActor(tubo);
		stage.addActor(penguin);
		stage.addActor(piso);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		stage.act();
	}
	
}
