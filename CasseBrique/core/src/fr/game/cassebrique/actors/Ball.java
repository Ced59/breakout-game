package fr.game.cassebrique.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class Ball {
    
    Float x;
    Float y;
    Float angle;
    Texture texture;
    int speed;
    Circle circle;
    
    
    public Ball(Raquette raquette) {
        
        texture = new Texture("textures/BallGolfTextureOK.png");
        this.x = raquette.x - (texture.getWidth() / 2);
        this.y = raquette.y + (texture.getHeight() / 2);
        speed = 30;
        circle = new Circle(x, y, (texture.getWidth() / 2));
        
    }
    
    public void updatePosition(Raquette raquette, boolean gameStart) {

        if (!gameStart) {
            this.x = raquette.x + (raquette.texture.getWidth() / 2) - (texture.getWidth() / 2);
            this.y = raquette.y + (raquette.texture.getHeight());
        }
            

    }


    public void render(SpriteBatch batch) {
        
        
            batch.begin();
            batch.draw(texture, x, y);
            batch.end();
        
    }

	public boolean startGame(boolean gameStart) {

        if (!gameStart) {
            if (Gdx.input.isKeyJustPressed(Keys.ENTER) || Gdx.input.isKeyJustPressed(Keys.SPACE)) {

                gameStart = true;
            }
        }

		return gameStart;
	}
}