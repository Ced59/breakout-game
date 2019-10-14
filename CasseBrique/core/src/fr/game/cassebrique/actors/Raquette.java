package fr.game.cassebrique.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Raquette {
    
    Float x;
    Float y;
    Texture texture;
    int speed;
    Rectangle zoneLeft;
    Rectangle zoneRight;
    Rectangle zoneCenter;
    
    public Raquette() {
        
        this.texture = new Texture("textures/RaquetteTexture.png");
        this.x = (float)(Gdx.graphics.getWidth() / 2) - (texture.getWidth() / 2);
        this.y = 50.0f;
        this.speed = 20;
        zoneLeft = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        zoneCenter = new Rectangle((x + texture.getWidth() / 3), y, texture.getWidth() / 3, texture.getHeight());
        zoneRight = new Rectangle((x + texture.getWidth() / 3 * 2), y, texture.getWidth() / 3, texture.getHeight());
    }
    
    
    public void move() {
        
        boolean left = false;
        if (Gdx.input.isKeyJustPressed(Keys.Q) || Gdx.input.isKeyJustPressed(Keys.LEFT)){
            
            x -= speed/3;
            borderCollision();
            
        }
        else {
            
            if (Gdx.input.isKeyPressed(Keys.Q) || Gdx.input.isKeyPressed(Keys.LEFT)){
                
                left = true;
            }
        }
        
        
        boolean right = false;
        if (Gdx.input.isKeyJustPressed(Keys.D) || Gdx.input.isKeyJustPressed(Keys.RIGHT)){
            
            x += speed/3;
            borderCollision();
            
        }
        else {
            if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
                
                right = true;
            }
            
        }
        
        
        if (left){
            
            x -= speed;
            borderCollision();
        }
        
        if (right){
            
            x += speed;
            borderCollision();
        }

        updateZone();
    }
    
    
    private void updateZone() {

        zoneLeft.x = x;
        zoneLeft.y = y;

        zoneCenter.x = x + texture.getWidth() / 3;
        zoneCenter.y = y;

        zoneRight.x = x + texture.getWidth() / 3 * 2;
        zoneCenter.y = y;


    }



    public void borderCollision() {
        
        int limitX = Gdx.graphics.getWidth() - this.texture.getWidth();
        
        if (limitX < x) {
            
            x = (float)limitX;
            
        } else if (x < 0.0f) {
            
            x = 0.0f;
        }
    }
    
    
    public void render(SpriteBatch batch) {
        
        batch.begin();
        batch.draw(texture, x, y);
        batch.end();
    }
    
}