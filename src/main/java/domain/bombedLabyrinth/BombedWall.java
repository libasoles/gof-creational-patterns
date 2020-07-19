package domain.bombedLabyrinth;

import domain.Wall;

public class BombedWall extends Wall {
    public BombedWall() {
        System.out.println("If a bomb goes off, it will damage this wall");
    }
}
