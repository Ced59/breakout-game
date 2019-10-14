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
    boolean right;
    boolean left;
    boolean leftSlow;
    boolean rightSlow;
    
    
    public Raquette() {
        
        this.texture = new Texture("textures/RaquetteTexture.png");
        this.x = (float)(Gdx.graphics.getWidth() / 2) - (texture.getWidth() / 2);
        this.y = 50.0f;
        this.speed = 20;
        zone = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        right = false;
        left = false;
        leftSlow = false;
        rightSlow = false;
        
    }
    
    
    public void move() {
        
        int speedSlow;
        
        if (Gdx.input.isKeyJustPressed(Keys.Q) || Gdx.input.isKeyJustPressed(Keys.LEFT)){
            
            x -= speed/3;
            borderCollision();
            
        }
        if ((Gdx.input.isKeyPressed(Keys.Q) && (Gdx.input.isKeyPressed(Keys.SPACE)) || Gdx.input.isKeyPressed(Keys.LEFT)) && (Gdx.input.isKeyPressed(Keys.SPACE))){
                
            left = true;
            leftSlow = true;
        }
        else {

            left = false;
            leftSlow = false;
        }

        if (Gdx.input.isKeyPressed(Keys.Q) || Gdx.input.isKeyPressed(Keys.LEFT)){
                
            left = true;
        }
        else {

            left = false;
         
        }
        
        
        
        if (Gdx.input.isKeyJustPressed(Keys.D) || Gdx.input.isKeyJustPressed(Keys.RIGHT)){
            
            speedSlow = speed / 2;
            x += speed;
            borderCollision();
            
        }

        if ((Gdx.input.isKeyPressed(Keys.D) && (Gdx.input.isKeyPressed(Keys.SPACE)) || Gdx.input.isKeyPressed(Keys.RIGHT)) && (Gdx.input.isKeyPressed(Keys.SPACE))){
                
            right = true;
            rightSlow = true;
        }
        else {

            right = false;
            rightSlow = false;
        }

        if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
                
            right = true;
        }
        
        else {
            
            right = false;
        }
        
        
        if (left){
            
            if (leftSlow) {

                speedSlow = speed / 2;
                x -= speedSlow;
            }

            else {

                x -= speed;
            }

            borderCollision();
        }
        
        if (right){
            
            
            if (rightSlow){

                speedSlow = speed / 2;
                x += speedSlow;
            }
            else {

                x += speed;
            }


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

    public boolean getMove() {

        boolean move;

        if (right || left) {
            
            move = true;
        }
        else {

            move = false;
        }

        return move;
    }

    public boolean getSlowMove() {

        boolean slowMove;

        if (rightSlow || leftSlow) {
            
            slowMove = true;
        }
        else {

            slowMove = false;
        }

        return slowMove;
    }
    
}