package com.sw.game;

import java.util.Iterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class SpeedwayGame implements Screen{
	final GameControl game;

	SpriteBatch batch;
	Texture img;

	SpeedwayPlayer player;

	ShapeRenderer shapeRenderer;
	BezierCurve curve;

	OrthographicCamera camera;

	public SpeedwayGame(final GameControl game)
	{
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		player = new SpeedwayPlayer("Kriss Kringle");

		curve = new BezierCurve();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();

		camera.update();

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(1,1,0,1);
		shapeRenderer.line(0,0,1920,1080);
		shapeRenderer.rect(500, 500, 500, 500);
//		shapeRenderer.identity();
//		shapeRenderer.translate(20,12,2);
//		shapeRenderer.rotate(0,0,1, 90);
		shapeRenderer.circle(1200, 800, 100);
		shapeRenderer.end();

		if(Gdx.input.isTouched())
		{
			curve.draw(shapeRenderer);
			curve.NewRandomDataSet();
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		shapeRenderer.dispose();
	}
}
