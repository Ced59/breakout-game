package fr.game.cassebrique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CredentialsScreen implements Screen {


    private MyCasseBrique game;
    Skin skin;
    Stage stageCredentials;
    final Color BACKGROUND_COLOR = Color.GOLD;
    private SpriteBatch batch;
    private BitmapFont font;
    private String message;

    public CredentialsScreen(MyCasseBrique pgame) {
        
        this.game = pgame;

        batch = new SpriteBatch();
        font = new BitmapFont();
        message = "Développé par Cédric Caudron avec LibGDX";

        stageCredentials = new Stage();
        Gdx.input.setInputProcessor(stageCredentials);

        skin = new Skin(Gdx.files.internal("skin/glassy/skin/glassy-ui.json"));

        Table table=new Table();
        table.setSize(1000,600);


        final TextButton returnMenu = new TextButton("Retour", skin);
        table.add(returnMenu).width(500).height(100).padBottom(20);  
        table.row();

        stageCredentials.addActor(table);

        returnMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                returnMenu.addAction(Actions.fadeOut(0.7f));
                game.setScreen(game.mainMenuScreen);
                
            }
        });

        
    }

    @Override
    public void show() {
        

    }

    @Override
    public void render(float delta) {
        
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r , BACKGROUND_COLOR.g , BACKGROUND_COLOR.b , BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        font.draw(batch, message, 350, 600);
        batch.end();
        
        

        stageCredentials.act(delta);
        stageCredentials.draw();

    }

    @Override
    public void resize(int width, int height) {
        

    }

    @Override
    public void pause() {
        

    }

    @Override
    public void resume() {
        

    }

    @Override
    public void hide() {
        

    }

    @Override
    public void dispose() {
        

    }

    
}