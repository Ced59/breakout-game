package fr.game.cassebrique;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyCasseBrique extends Game {
	SpriteBatch batch;
	Texture img;
	MainMenuScreen mainMenuScreen;
	GameScreen gameScreen;
	CredentialsScreen credentialsScreen;
	
	@Override
	public void create () {
		
		mainMenuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);
		credentialsScreen = new CredentialsScreen(this);

		setScreen(gameScreen);
		
	}

}
