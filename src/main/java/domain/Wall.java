package domain;

import domain.exceptions.CannotGoThroughObjectException;

public class Wall implements MapSite {
    @Override
    public Room enterFrom(Room room) throws CannotGoThroughObjectException {
        throw new CannotGoThroughObjectException();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
