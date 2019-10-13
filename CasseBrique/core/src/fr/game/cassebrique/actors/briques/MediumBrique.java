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

        testCollisionBottomBrique = new Rectangle(x, y + 10, zone.getWidth(), zone.getHeight());
        testCollisionUpBrique = new Rectangle(x, y - 10, zone.getWidth(), zone.getHeight());
        testCollisionLeftBrique = new Rectangle(x + 10, y, zone.getWidth(), zone.getHeight());
        testCollisionRightBrique = new Rectangle(x, y - 10, zone.getWidth(), zone.getHeight());
    } 

    public void render(SpriteBatch batch) {
        
        if (displayed) {
            
            batch.begin();
            batch.draw(texture, x, y);
            batch.end();
        }
        
    }

    public Rectangle getZone() {

        return zone;
    }

    public void setDisplayedWhenCollide() {

        this.power -=1;
        super.setDisplayedWhenCollide(this.power);

        if (this.power == 1) {
            this.texture = new Texture("textures/texture-basic-brique.jpg");
        }
	}
}