package fr.game.cassebrique.actors.levels.ressources;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import fr.game.cassebrique.actors.briques.*;

public class Row {
    
    final int NB_BRIQUE = 17;
    private Map<Integer, Brique> rowBriques = new HashMap<>();
    int rowNumber;
    float y;
    float x;
    
    public Row (int rowNumber) {
        
        this.rowNumber = rowNumber;
        x = 50.0f;
        y = 800 - ((float)rowNumber * 24.0f);
    }
    
    
    
    public void render(SpriteBatch batch) {
        
        for (int i = 0; i < rowBriques.size(); i++) {
            
            rowBriques.get(i).render(batch);
        }

    }
    
    

    // zone createRow à refactoriser et parametrer pour créer différentes lignes avec différentes briques (même les vides)

    public void createBasicRow(int rowNumber) {
        
        for (int i = 0; i < NB_BRIQUE; i++) {
            rowBriques.put(i, new BasicBrique(x, y));
            x += 52;
        }
        
    }
    
    public void createMediumRow(int rowNumber) {
        
        for (int i = 0; i < NB_BRIQUE; i++) {
            rowBriques.put(i, new MediumBrique(x, y));
            x += 52;
        }
    }
    
    public void createHardRow(int rowNumber) {
        
        for (int i = 0; i < NB_BRIQUE; i++) {
            rowBriques.put(i, new HardBrique(x, y));
            x += 52;
        }
    }

    public Map<Integer, Brique> getRowBriques() {

        return rowBriques;
    }
    // fin de la zone de refactorisation

}

