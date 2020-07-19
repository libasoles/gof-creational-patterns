package domain;

public class LabyrinthGame {
    /**
     * TODO: this hardcoded creation will be replaced with creational design patterns as in the GoF book
     */
    public Labyrinth createLabyrinth() {
        Room firstRoom = new Room();
        Room secondRoom = new Room();

        Door aDoor = new Door(firstRoom, secondRoom);

        firstRoom.setSide(Direction.NORTH, new Wall());
        firstRoom.setSide(Direction.SOUTH, aDoor);
        firstRoom.setSide(Direction.EAST, new Wall());
        firstRoom.setSide(Direction.WEST, new Wall());

        secondRoom.setSide(Direction.NORTH, aDoor);
        secondRoom.setSide(Direction.SOUTH, new Wall());
        secondRoom.setSide(Direction.EAST, new Wall());
        secondRoom.setSide(Direction.WEST, new Wall());

        Labyrinth labyrinth = new Labyrinth();
        labyrinth.addRoom(firstRoom);
        labyrinth.addRoom(secondRoom);

        aDoor.open();

        return labyrinth;
    }
}
