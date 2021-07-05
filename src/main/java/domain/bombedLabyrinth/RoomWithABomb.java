package domain.bombedLabyrinth;

import domain.Room;

public class RoomWithABomb extends Room {
    public RoomWithABomb(int number) {
        super(number);
        System.out.println("This room keeps track of whether the\n" +
                "room has a bomb in it and whether the bomb has gone off");
    }
}
