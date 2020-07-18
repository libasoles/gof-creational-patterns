package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.exceptions.RoomNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LabyrinthShould {

    @Mock
    Room aRoom;

    @Test public void
    return_a_room_by_number() throws RoomNotFoundException {
        Labyrinth labyrinth = new Labyrinth();
        labyrinth.addRoom(aRoom);

        Room foundRoom = labyrinth.getRoom(1);

        assertThat(foundRoom).isEqualTo(aRoom);
    }

    @Test public void
    fail_when_room_does_not_exist() {
        Labyrinth labyrinth = new Labyrinth();

        assertThatThrownBy(() -> labyrinth.getRoom(5)).isInstanceOf(RoomNotFoundException.class);
    }
}
