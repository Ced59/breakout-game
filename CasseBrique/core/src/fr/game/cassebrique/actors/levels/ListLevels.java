package fr.game.cassebrique.actors.levels;

import java.util.ArrayList;

public class ListLevels {
    
    ArrayList<Level> levels = new ArrayList<Level>();
    private Level level;
    
    
    public void generate() {
        
        level = new Level(1, 3);
        level.create("BasicRow", "BasicRow", "BasicRow");
        levels.add(level);

        level = new Level(2, 4);
        level.create("BasicRow", "MediumRow", "HardRow", "HardRow");
        levels.add(level);

        level = new Level(3, 10);
        level.create("BasicRow", "MediumRow", "HardRow", "HardRow", "BasicRow", "MediumRow", "HardRow", "HardRow", "BasicRow", "MediumRow");
        levels.add(level);

        level = new Level(4, 15);
        level.create("HardRow", "HardRow", "HardRow", "HardRow", "HardRow","HardRow","HardRow","HardRow","HardRow","HardRow","HardRow",
                     "HardRow","HardRow","HardRow","HardRow");
        levels.add(level);
    }

    public Level getLevel(int lvl) {

        return levels.get(lvl - 1);
    }
    
}