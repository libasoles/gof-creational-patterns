package domain;

import domain.exceptions.CannotGoThroughObjectException;

public interface MapSite {
    Room enterFrom(Room room) throws CannotGoThroughObjectException;
}
