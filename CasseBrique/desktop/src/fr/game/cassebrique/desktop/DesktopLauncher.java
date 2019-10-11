package fr.game.cassebrique.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.game.cassebrique.MyCasseBrique;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Casse Brique";
		config.resizable = false;
		config.height = 900;
		config.width = 1000;
		config.backgroundFPS = 60;
		new LwjglApplication(new MyCasseBrique(), config);
	}
}
