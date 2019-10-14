package fr.game.cassebrique.actors;



public class Player {

    private int life;
    private int lvl;
    private String pseudo;

    public Player() {

        this.life = 10;
        this.lvl = 1;
    }


    public void lifeLost() {

        this.life -= 1;
    }

    public void passLvl() {

        this.lvl += 1;
    }

    public int getLife() {

        return life;
    }

    public int getLvl() {

        return lvl;
    }

    
}