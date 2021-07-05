package factories;

import domain.enchantedLabyrinth.DoorNeedingSpell;
import domain.enchantedLabyrinth.EnchantedRoom;
import domain.Door;
import domain.Room;

public class EnchantedLabyrinthFactory extends LabyrinthFactory {

    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Door createDoor(Room aRoom, Room anotherRoom) {
        return new DoorNeedingSpell(aRoom, anotherRoom);
    }
}
