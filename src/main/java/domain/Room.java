package domain;

import java.util.HashMap;
import java.util.Map;

public class Room {
    Map sides = new HashMap<Direction, MapSite>();

    public Room(MapSite northSide, MapSite southSide, MapSite eastSide, MapSite westSide) {

        sides.put(Direction.NORTH, northSide);
        sides.put(Direction.SOUTH, southSide);
        sides.put(Direction.EAST, eastSide);
        sides.put(Direction.WEST, westSide);
    }

    public MapSite getSide(Direction direction) {
        return (MapSite) sides.get(direction);
    }
}
