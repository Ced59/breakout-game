package fr.game.cassebrique.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import fr.game.cassebrique.actors.levels.Level;
import fr.game.cassebrique.actors.levels.ressources.Row;




public class Ball {
    
    Float x;
    Float y;
    double angle;
    Texture texture;
    int speed;
    Circle zone;
    boolean directionRight;
    boolean directionUp;
    boolean collisionBottom;
    
    
    public Ball(Raquette raquette) {
        
        texture = new Texture("textures/BallGolfTextureOK.png");
        this.x = raquette.x - (texture.getWidth() / 2);
        this.y = raquette.y + (texture.getHeight() / 2);
        speed = 15;
        zone = new Circle(x, y, (texture.getHeight()/2 + 1));
        angle = (Math.PI)/3; // angle initial de la trajectoire
        directionRight = true;
        directionUp = true;
        collisionBottom = false;
        
    }
    
    public void updatePosition(Raquette raquette, boolean gameStart, Level lvl) {
        
        if (!gameStart) {
            this.x = raquette.x + (raquette.texture.getWidth() / 2) - (this.texture.getWidth() / 2);
            this.y = raquette.y + (raquette.texture.getHeight());
            collisionBottom = false;
        }
        else {
            
            collisionX();
            collisionBottom = collisionY();
            collisionBrique(lvl);
            collisionRaquette(raquette);
            trajectory(directionRight, directionUp);
        }
        
    }
    
    private void collisionBrique(Level lvl) {

        for (Row row : lvl.getLvlRows()) {
            
            // for (Brique brique : row.getRowBriques()) {

                for (int i = 0; i < row.getRowBriques().size(); i++) {
                    
                
                boolean collision = Intersector.overlaps(zone, row.getRowBriques().get(i).getZone());

                if (collision) {

                   //On teste le coté de la brique entré en collision pour déterminer la nouvelle direction de la balle (en testant une collision avec un nouveau rectangle fictif décalé)

                    if (Intersector.overlaps(zone, row.getRowBriques().get(i).getTestCollisionBottomBrique())) {

                        directionUp = false;
                    }

                    if (Intersector.overlaps(zone, row.getRowBriques().get(i).getTestCollisionUpBrique())) {

                        directionUp = true;
                    }

                    if (Intersector.overlaps(zone, row.getRowBriques().get(i).getTestCollisionLeftBrique())) {

                        directionRight = false;
                    }

                    if (Intersector.overlaps(zone, row.getRowBriques().get(i).getTestCollisionRightBrique())) {

                        directionRight = true;
                    }
  

                    row.getRowBriques().get(i).setDisplayedWhenCollide();
                    
                }
            }

        }
    }

    private void collisionRaquette(Raquette raquette) {
        
        boolean collision = Intersector.overlaps(zone, raquette.zone);
        
        if (collision) {
            
            angle = Math.PI / 3;

            if (raquette.getSlowMove()) {

                angle = Math.PI / 4;
            }
            if (raquette.getMove()) {

                angle = Math.PI / 6;
            }

            directionUp = true;
            
        }
        
       
        
    }
    
    private void trajectory(boolean directionX, boolean directionY) {
        
        Float modifX;
        
        if (directionX) {
            
            modifX = x + speed * (float)Math.cos(angle);
            this.x = modifX;
            zone.x = modifX;
        }
        else {
            
            modifX = x - speed * (float)Math.cos(angle);
            this.x = modifX;
            zone.x = modifX;
        }
        
        Float modifY;
        
        if (directionY) {
            
            modifY = y + speed * (float)Math.sin(angle);
            this.y = modifY;
            zone.y = modifY;
        }
        else {
            
            modifY = y - speed * (float)Math.sin(angle);
            this.y = modifY;
            zone.y = modifY;
        }
        
        
    }
    
    
    private boolean collisionY() {
        
        boolean collisionBottom = false;
        int limitY = Gdx.graphics.getHeight() - this.texture.getHeight();
        
        if (limitY < y) {
            
            y = (float)limitY;
            directionUp = false;
            
        } else if (y < 0.0f) {
            
            
            directionUp = true;
            
            // Rajouter la perte de vie ici (collision avec le bas de l'ecran)
            collisionBottom = true;
            
        }

        return collisionBottom;
    }
    
    private void collisionX() {
        
        int limitX = Gdx.graphics.getWidth() - this.texture.getWidth();
        
        if (limitX < x) {
            
            x = (float)limitX;
            directionRight = false;
            
        } else if (x < 0.0f) {
            
            x = 0.0f;
            directionRight = true;          
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

    public boolean getCollisionBottom() {

        return collisionBottom;
    }
}