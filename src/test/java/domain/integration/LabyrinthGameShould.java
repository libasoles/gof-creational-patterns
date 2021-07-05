package domain.integration;

import domain.*;
import domain.exceptions.CannotGoThroughObjectException;
import domain.exceptions.RoomNotFoundException;
import factories.EnchantedLabyrinthFactory;
import factories.LabyrinthFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LabyrinthGameShould {
    @Test
    public void
    can_go_from_one_room_to_another() throws RoomNotFoundException, CannotGoThroughObjectException {
        LabyrinthGame game = new LabyrinthGame();
        LabyrinthFactory factory = new EnchantedLabyrinthFactory();
        Labyrinth labyrinth = game.createLabyrinth(factory);

        Room firstRoom = labyrinth.getRoom(1);
        Room secondRoom = firstRoom.go(Direction.SOUTH);

        Assertions.assertThat(secondRoom).isEqualTo(labyrinth.getRoom(2));
    }

    @Test
    public void
    cannot_go_from_one_room_to_another_when_door_is_closed() throws RoomNotFoundException {
        LabyrinthGame game = new LabyrinthGame();
        LabyrinthFactory factory = new EnchantedLabyrinthFactory();
        Labyrinth labyrinth = game.createLabyrinth(factory);

        Room firstRoom = labyrinth.getRoom(1);

        Door theDoor = (Door) firstRoom.getSide(Direction.SOUTH);
        theDoor.close();

        Assertions.assertThatThrownBy(() -> firstRoom.go(Direction.SOUTH)).isInstanceOf(CannotGoThroughObjectException.class);
    }
}