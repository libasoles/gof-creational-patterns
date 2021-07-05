package factories;

import domain.Door;
import domain.Labyrinth;
import domain.Room;
import domain.Wall;

/**
 * Note in the book that LabyrinthFactory is not an abstract class; thus it
 * acts as both the AbstractFactory and the ConcreteFactory. That is
 * another common implementation for simple applications of the
 * Abstract Factory pattern. Because the LabyrinthFactory is a concrete class
 * consisting entirely of factory methods, it’s easy to make a new
 * LabyrinthFactory by making a subclass and overriding the operations that
 * need to change.
 */
public abstract class LabyrinthFactory {
    public Labyrinth createLabyrinth() {
        return new Labyrinth();
    }

    public Room createRoom(int number) {
        return new Room(number);
    }

    public Wall createWall() {
        return new Wall();
    }

    public Door createDoor(Room aRoom, Room anotherRoom) {
        return new Door(aRoom, anotherRoom);
    }
}
