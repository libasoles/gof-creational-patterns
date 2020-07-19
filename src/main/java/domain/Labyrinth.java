package domain;

import domain.exceptions.RoomNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
    private List<Room> rooms = new ArrayList();

    public void addRoom(Room aRoom) {
        int aNumber = rooms.size();

        // as we are using a simple ArrayList to store the rooms, and making a basic look-up, that forces us to set the room nª here.
        aRoom.setNumber(aNumber);
        rooms.add(aRoom);
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
        try {
            return rooms.get(aNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new RoomNotFoundException();
        }
    }
}
