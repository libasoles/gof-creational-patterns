package domain.enchantedLabyrinth;

import domain.Door;
import domain.Room;

public class DoorNeedingSpell extends Door {
    public DoorNeedingSpell(Room aRoom, Room anotherRoom) {
        super(aRoom, anotherRoom);
        System.out.println("Will not open without a spell");
    }
}
