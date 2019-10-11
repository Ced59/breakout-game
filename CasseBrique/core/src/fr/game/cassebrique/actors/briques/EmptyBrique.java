package fr.game.cassebrique.actors.briques;


public class EmptyBrique {

    private float x;
    private float y;
    private float widght;
    
    
    
    public EmptyBrique(float x, float y) {
        this.x = x;
        this.y = y;
        this.widght = 50;
        
    }

    public EmptyBrique(float x, float y, float widght) {
        this.x = x;
        this.y = y;
        this.widght = widght;
    }

}