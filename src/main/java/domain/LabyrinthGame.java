package domain;

import factories.LabyrinthFactory;

public class LabyrinthGame {
    /**
     * Recall that the member function createLabyrinth builds a small
     * Labyrinth consisting of two rooms with a door between them. But createLabyrinth
     * hard-coded the class names, making it difficult to create Labyrinths with
     * different components.
     * Here’s a version of createLabyrinth that remedies that shortcoming by
     * taking a MazeFactory as a parameter:
     *
     * @param factory A concrete theme for the game
     */
    public static Labyrinth createLabyrinth(LabyrinthFactory factory) {
        Room firstRoom = factory.createRoom(1);
        Room secondRoom = factory.createRoom(2);

        Door aDoor = factory.createDoor(firstRoom, secondRoom);

        firstRoom.setSide(Direction.NORTH, factory.createWall());
        firstRoom.setSide(Direction.SOUTH, aDoor);
        firstRoom.setSide(Direction.EAST, factory.createWall());
        firstRoom.setSide(Direction.WEST, factory.createWall());

        secondRoom.setSide(Direction.NORTH, aDoor);
        secondRoom.setSide(Direction.SOUTH, factory.createWall());
        secondRoom.setSide(Direction.EAST, factory.createWall());
        secondRoom.setSide(Direction.WEST, factory.createWall());

        Labyrinth labyrinth = factory.createLabyrinth();
        labyrinth.addRoom(firstRoom);
        labyrinth.addRoom(secondRoom);

        aDoor.open();

        return labyrinth;
    }
}
