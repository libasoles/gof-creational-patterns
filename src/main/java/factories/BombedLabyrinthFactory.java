package factories;

import domain.Room;
import domain.Wall;
import domain.bombedLabyrinth.BombedWall;
import domain.bombedLabyrinth.RoomWithABomb;

public class BombedLabyrinthFactory extends LabyrinthFactory {
    @Override
    public Room createRoom(int number) {
        return new RoomWithABomb(number);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }
}
