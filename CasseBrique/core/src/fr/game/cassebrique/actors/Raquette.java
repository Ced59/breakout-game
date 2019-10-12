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
    Rectangle zone;
    
    public Raquette() {
        
        this.texture = new Texture("textures/RaquetteTexture.png");
        this.x = (float)(Gdx.graphics.getWidth() / 2) - (texture.getWidth() / 2);
        this.y = 50.0f;
        this.speed = 20;
        zone = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
                
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

        zone.x = x;
        zone.y = y;
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