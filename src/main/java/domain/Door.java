package domain;

import domain.exceptions.CannotGoThroughObjectException;
import domain.interfaces.MapSite;

public class Door implements MapSite {
    private Room oneRoom;
    private Room anotherRoom;
    private boolean isOpen;

    public Door(Room aRoom, Room anotherRoom) {
        isOpen = false;
        setSides(aRoom, anotherRoom);
    }

    private void setSides(Room aRoom, Room anotherRoom) {
        this.oneRoom = aRoom;
        this.anotherRoom = anotherRoom;
    }

    public Room otherSideOf(Room aRoom) {
        if (aRoom.equals(oneRoom)) {
            return anotherRoom;
        }
        return oneRoom;
    }

    @Override
    public Room enterFrom(Room aRoom) throws CannotGoThroughObjectException {
        if(isOpen) {
            return otherSideOf(aRoom);
        }
        throw new CannotGoThroughObjectException();
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public void toggle() {
        isOpen = !isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
