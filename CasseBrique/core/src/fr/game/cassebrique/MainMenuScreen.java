package fr.game.cassebrique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen implements Screen {
    
    Skin skin;
    Stage stage;
    final Color BACKGROUND_COLOR = Color.GOLD;
    MyCasseBrique game;
    
    
    // constructor to keep a reference to the main Game class
    public MainMenuScreen(MyCasseBrique pgame){
        this.game = pgame;
        
        stage=new Stage();
        Gdx.input.setInputProcessor(stage);
        
        skin = new Skin(Gdx.files.internal("skin/glassy/skin/glassy-ui.json"));
        
        Table table=new Table();
        table.setSize(1000,600);
        


        final TextButton startGame = new TextButton("Jouer",skin);
        table.add(startGame).width(500).height(100).padBottom(20);
        table.row();
        
        final TextButton options = new TextButton("Options",skin);
        table.add(options).width(500).height(100).padBottom(20);
        table.row();

        final TextButton credits = new TextButton("Credits",skin);
        table.add(credits).width(500).height(100).padBottom(20);
        table.row();
        
        final TextButton quitt = new TextButton("Quitter",skin);
        table.add(quitt).width(500).height(100);
        table.row();

        
        stage.addActor(table);
        
        startGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                startGame.addAction(Actions.fadeOut(0.7f));
                game.setScreen(game.gameScreen);
            }
        });
        
        quitt.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                quitt.addAction(Actions.fadeOut(0.7f));
                game.dispose();
            }
        });

        credits.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // credits.addAction(Actions.fadeOut(0.7f));
                game.setScreen(game.credentialsScreen);
                dispose();
            }
        });
    }
    
    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r , BACKGROUND_COLOR.g , BACKGROUND_COLOR.b , BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // let the stage act and draw
        stage.act(delta);
        stage.draw();
        
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
        stage.dispose();
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
        stage.dispose();
    }
    
    
}
