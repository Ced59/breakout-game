package fr.game.cassebrique.actors.levels.ressources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.game.cassebrique.actors.briques.*;

public class Row {
    
    final int NB_BRIQUE = 17;
    Brique[] rowBriques = new Brique[NB_BRIQUE];
    int rowNumber;
    float y;
    float x;
    
    public Row (int rowNumber) {
        
        this.rowNumber = rowNumber;
        x = 50.0f;
        y = 800 - ((float)rowNumber * 24.0f);
    }
    
    
    
    public void render(SpriteBatch batch) {
        
        for (Brique var : rowBriques) {
            
            var.render(batch);
        }
    }
    
    

    // zone createRow à refactoriser et parametrer pour créer différentes lignes avec différentes briques (même les vides)

    public void createBasicRow(int rowNumber) {
        
        for (int i = 0; i < NB_BRIQUE; i++) {
            rowBriques[i] = new BasicBrique(x, y);
            x += 52;
        }
        
    }
    
    public void createMediumRow(int rowNumber) {
        
        for (int i = 0; i < NB_BRIQUE; i++) {
            rowBriques[i] = new MediumBrique(x, y);
            x += 52;
        }
    }
    
    public void createHardRow(int rowNumber) {
        
        for (int i = 0; i < NB_BRIQUE; i++) {
            rowBriques[i] = new HardBrique(x, y);
            x += 52;
        }
    }

    public Brique[] getRowBriques() {

        return rowBriques;
    }


    // fin de la zone de refactorisation

}

