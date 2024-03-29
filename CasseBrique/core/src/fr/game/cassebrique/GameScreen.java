package fr.game.cassebrique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.game.cassebrique.actors.Ball;
import fr.game.cassebrique.actors.Player;
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
        boolean gameTestWin;
        boolean gameTestLostLife;
        int lvl;
        Player player;
        
        
        
        public GameScreen(MyCasseBrique game){
                this.game = game;
                gameStart = false;
                gameTestWin = false;
                gameTestLostLife = false;
                batch = new SpriteBatch();
                listLevels = new ListLevels();
                listLevels.generate();
                raquette = new Raquette();
                ball = new Ball(raquette);
                player = new Player();
                
        }
        
        
        @Override
        public void render(float delta) {
                
                clearScreen();
                raquette.move();
                gameStart = ball.startGame(gameStart);
                ball.updatePosition(raquette, gameStart, listLevels.getLevel(player.getLvl()));
                listLevels.getLevel(player.getLvl()).render(batch);
                raquette.render(batch);
                ball.render(batch);
                player.render(batch);
                gameTestWin = !listLevels.getLevel(player.getLvl()).testWin(player);

                if (!gameTestWin) {

                        gameStart = false;
                }

                gameTestLostLife = ball.getCollisionBottom();

                if (gameTestLostLife) {

                        player.lifeLost();
                        gameStart = false;
                        gameTestLostLife = false;
                        if (player.getLife() == 0) {
                                dispose();
                        }

                }
                
                
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
                batch.dispose();
                game.dispose();
        }
}
