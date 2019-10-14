package fr.game.cassebrique.actors;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private int life;
    private int lvl;
    private String pseudo;
    private BitmapFont font;

    public Player() {

        this.life = 10;
        this.lvl = 1;
        font = new BitmapFont();
    }


    public void lifeLost() {

        this.life -= 1;
    }

    public void passLvl() {

        this.lvl += 1;
    }

    public int getLife() {

        return life;
    }

    public int getLvl() {

        return lvl;
    }


	public void render(SpriteBatch batch) {

        batch.begin();
        if (life > 1) {
            font.draw(batch, "Il vous reste " + this.life + " vies.", 200, 870);
        }
        else {
            font.draw(batch, "Il vous reste " + this.life + " vie.", 200, 870);
        }
        
        batch.end();
	}

    
}