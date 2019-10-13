package fr.game.cassebrique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.game.cassebrique.actors.Ball;
import fr.game.cassebrique.actors.Raquette;
import fr.game.cassebrique.actors.levels.ListLevels;


public class GameScreen implements Screen {
        
        MyCasseBrique game; 
        final Color BACKGROUND_COLOR = Color.GOLD;
        SpriteBatch batch;
        ListLevels listLevels;
        Raquette raquette;
        Ball ball;
        boolean gameStart;
        
        
        
        public GameScreen(MyCasseBrique game){
                this.game = game;
                gameStart = false;
                batch = new SpriteBatch();
                listLevels = new ListLevels();
                listLevels.generate();
                raquette = new Raquette();
                ball = new Ball(raquette);
                
        }
        
        
        @Override
        public void render(float delta) {
                
                clearScreen();
                raquette.move();
                gameStart = ball.startGame(gameStart);
                ball.updatePosition(raquette, gameStart, listLevels.getLevel(3));
                listLevels.getLevel(3).render(batch);
                raquette.render(batch);
                ball.render(batch);
                
                
        }
        
        
        
        
        private void clearScreen() {
                Gdx.gl.glClearColor(BACKGROUND_COLOR.r, BACKGROUND_COLOR.g, BACKGROUND_COLOR.b, BACKGROUND_COLOR.a); 
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
        
        
        
        
        
        @Override
        public void resize(int width, int height) {
        }
        
        
        @Override
        public void show() {
                // called when this screen is set as the screen with game.setScreen();
        }
        
        
        @Override
        public void hide() {
                // called when current screen changes from this to a different screen
        }
        
        
        @Override
        public void pause() {
        }
        
        
        @Override
        public void resume() {
        }
        
        
        @Override
        public void dispose() {
                // never called automatically
        }
}
