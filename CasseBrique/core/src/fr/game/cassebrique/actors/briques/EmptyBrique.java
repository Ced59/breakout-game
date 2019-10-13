package fr.game.cassebrique.actors.briques;


public class EmptyBrique extends Brique {

    private float x;
    private float y;
    private float widght;
    
    
    
    public EmptyBrique(float x, float y) {
        
        super(x, y);
        this.widght = 50;
        
    }

    public EmptyBrique(float x, float y, float widght) {

        super(x, y);
        this.widght = widght;
    }

}