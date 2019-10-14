package fr.game.cassebrique.actors.briques;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Brique {

    protected float x;
    protected float y;
    protected boolean displayed;
    protected Rectangle zone;
    protected Rectangle testCollisionBottomBrique;
    protected Rectangle testCollisionUpBrique;
    protected Rectangle testCollisionLeftBrique;
    protected Rectangle testCollisionRightBrique;
   
    

    public Brique(float x, float y) {

        this.x = x;
        this.y = y;
        displayed = true;
    }


    public void position() {

        
    }

	public void render(SpriteBatch batch) {

    
    }
    
    public Rectangle getZone() {

        return zone;
    }

	public void setDisplayedWhenCollide(int power) {

        if (power == 0) {

            displayed = false;
            getZone().set(0, 0, 0, 0);
        }
    }
    
    public void setDisplayedWhenCollide() {

        
    }
    
    public float getX() {

        return x;
    }

    public float getY() {

        return y;
    }

    public Rectangle getTestCollisionBottomBrique() {

        return testCollisionBottomBrique;
    }

    public Rectangle getTestCollisionUpBrique() {

        return testCollisionUpBrique;
    }

    public Rectangle getTestCollisionLeftBrique() {

        return testCollisionLeftBrique;
    }

    public Rectangle getTestCollisionRightBrique() {

        return testCollisionRightBrique;
    }

}