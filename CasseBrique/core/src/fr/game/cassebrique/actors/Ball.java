package fr.game.cassebrique.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class Ball {
    
    Float x;
    Float y;
    double angle;
    Texture texture;
    int speed;
    Circle circle;
    boolean directionRight;
    boolean directionUp;
    
    
    public Ball(Raquette raquette) {
        
        texture = new Texture("textures/BallGolfTextureOK.png");
        this.x = raquette.x - (texture.getWidth() / 2);
        this.y = raquette.y + (texture.getHeight() / 2);
        speed = 15;
        circle = new Circle(x, y, (texture.getWidth() / 2));
        angle = (Math.PI)/4; // angle initial de la trajectoire
        directionRight = true;
        directionUp = true;
        
    }
    
    public void updatePosition(Raquette raquette, boolean gameStart) {
        
        if (!gameStart) {
            this.x = raquette.x + (raquette.texture.getWidth() / 2) - (texture.getWidth() / 2);
            this.y = raquette.y + (raquette.texture.getHeight());
        }
        else {
            trajectory(directionRight, directionUp);

            CollisionX();
            CollisionY();

        }
        
    }

    private void trajectory(boolean directionX, boolean directionY) {

        if (directionX) {

            this.x = x + speed * (float)Math.cos(angle);
        }
        else {

            this.x = x - speed * (float)Math.cos(angle);
        }

        if (directionY) {

            this.y = y + speed * (float)Math.sin(angle);
        }
        else {

            this.y = y - speed * (float)Math.sin(angle);
        }
        
        
    }
    
    
    private void CollisionY() {

        int limitY = Gdx.graphics.getHeight() - this.texture.getHeight();

        if (limitY < y) {

            y = (float)limitY;
            directionUp = false;
            
        } else if (y < 0.0f) {

            y = 0.0f;
            directionUp = true;

            // Rajouter la perte de vie ici (collision avec le bas de l'ecran)
        }
    }

    private void CollisionX() {

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
}