package domain;

import domain.exceptions.RoomNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Labyrinth {
    private Map<Integer, Room> rooms = new HashMap<>();

    public void addRoom(Room aRoom) {
        rooms.put(aRoom.getNumber(), aRoom);
    }

    /**
     * From the book:
     * getRoom could do a look-up using a linear search, a hash table, or even
     * a simple array. But we won’t worry about such details here. Instead,
     * we’ll focus on how to specify the components of a maze object.
     *
     * @param aNumber
     * @return Room
     * @throws RoomNotFoundException
     */
    public Room getRoom(int aNumber) throws RoomNotFoundException {
        if (!rooms.containsKey(aNumber))
            throw new RoomNotFoundException();
        return rooms.get(aNumber);
    }
}
