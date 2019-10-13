package fr.game.cassebrique.actors.levels;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.game.cassebrique.actors.levels.ressources.Row;


public class Level {
    
    int lvlNumber;
    int rowsNbre;
    Row[] lvlRows;
    private BitmapFont font;
    
    
    public Level(int lvlNumber, int rowsNbre) {
        
        this.lvlNumber = lvlNumber;
        this.rowsNbre = rowsNbre;
        lvlRows = new Row[rowsNbre];
        font = new BitmapFont();
        
    }
    
    
    // A généraliser avec une methode aux nbre param indéfini ---> OK
    // A voir pour remplacer les String par enumerables
    
    public void create(String... rowNames) {
        
        for (int i = 0; i < rowNames.length; i++) {
            
            switch (rowNames[i]) {
                
                case "HardRow":
                lvlRows[i] = new Row(i);
                lvlRows[i].createHardRow(i);
                
                break;

                case "MediumRow":
                lvlRows[i] = new Row(i);
                lvlRows[i].createMediumRow(i);
                
                break;

                case "BasicRow":
                lvlRows[i] = new Row(i);
                lvlRows[i].createBasicRow(i);
                
                break;
                
                default:
                break;
                
            }       
            
        }
        
    }
    
    
    public void render(SpriteBatch batch) {
        
        for (Row row : lvlRows) {
            
            row.render(batch);
        }
        
        batch.begin();
        font.draw(batch, "Vous êtes au niveau " + this.lvlNumber, 10, 870);
        batch.end();
        
    }

    public Row[] getLvlRows() {

        return lvlRows;
    }
}