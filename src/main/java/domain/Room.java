package domain;

import domain.exceptions.CannotGoThroughObjectException;
import domain.exceptions.NotADoorException;

import java.util.HashMap;
import java.util.Map;

public class Room implements MapSite {
    private int number;
    Map<Direction, MapSite> sides = new HashMap();

    public Room(int aNumber) {
        this.number = aNumber;
    }

    public void setSide(Direction direction, MapSite object) {
        sides.put(direction, object);
    }

    public MapSite getSide(Direction direction) {
        return sides.get(direction);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Room enterFrom(Room room) {
        return this;
    }

    public Room go(Direction direction) throws CannotGoThroughObjectException {
        return sides.get(direction).enterFrom(this);
    }

    public void toggleDoor(Direction direction) throws NotADoorException {
        try {
            Door aDoor = ((Door) sides.get(direction));
            aDoor.toggle();
        } catch(ClassCastException e) {
            throw new NotADoorException();
        }
    }
}
