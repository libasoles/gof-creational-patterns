package domain;

import domain.exceptions.RoomNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
    private List<Room> rooms = new ArrayList();

    public void addRoom(Room aRoom) {
        int aNumber = rooms.size();
        aRoom.setNumber(aNumber);
        rooms.add(aRoom);
    }

    public Room getRoom(int aNumber) throws RoomNotFoundException {
        try {
            return rooms.get(aNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new RoomNotFoundException();
        }
    }
}
