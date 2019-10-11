package fr.game.cassebrique.actors.briques;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MediumBrique extends Brique {

    protected Texture texture;
    protected int power;
    protected Rectangle zone;


    public MediumBrique(float x, float y) {

        super(x, y);
        texture = new Texture("textures/texture-medium-brique.jpg");
        zone = new Rectangle(x, y , texture.getWidth(), texture.getHeight());
        power = 2;
    } 

    public void render(SpriteBatch batch) {
        
        if (displayed) {
            
            batch.begin();
            batch.draw(texture, x, y);
            batch.end();
        }
        
    }
}