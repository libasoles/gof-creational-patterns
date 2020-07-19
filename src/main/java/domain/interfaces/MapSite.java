package domain.interfaces;

import domain.Room;
import domain.exceptions.CannotGoThroughObjectException;

public interface MapSite {
    Room enterFrom(Room room) throws CannotGoThroughObjectException;
}
