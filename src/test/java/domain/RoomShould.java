package domain;

import domain.exceptions.CannotGoThroughObjectException;
import domain.exceptions.NotADoorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomShould {
    Room aRoom;
    @Mock
    Door northSideDoor;
    @Mock
    Wall southSideWall;
    @Mock
    Wall eastSideWall;
    @Mock
    Wall westSideWall;

    @Mock
    Room anotherRoom;

    @Before
    public void
    setup() {
        createRoom();
    }

    private void createRoom() {
        aRoom = new Room(1);
        aRoom.setSide(Direction.NORTH, northSideDoor);
        aRoom.setSide(Direction.SOUTH, southSideWall);
        aRoom.setSide(Direction.EAST, eastSideWall);
        aRoom.setSide(Direction.WEST, westSideWall);
    }

    @Test
    public void
    have_four_sides() {
        assertThat(aRoom.getSide(Direction.NORTH)).isEqualTo(northSideDoor);
        assertThat(aRoom.getSide(Direction.SOUTH)).isEqualTo(southSideWall);
        assertThat(aRoom.getSide(Direction.EAST)).isEqualTo(eastSideWall);
        assertThat(aRoom.getSide(Direction.WEST)).isEqualTo(westSideWall);
    }

    @Test
    public void
    be_able_to_enter_into_a_room() {
        assertThat(aRoom.enterFrom(anotherRoom)).isInstanceOf(Room.class);
    }

    @Test
    public void
    can_go_from_one_room_to_another() throws CannotGoThroughObjectException {
        given(northSideDoor.enterFrom(aRoom)).willReturn(anotherRoom);

        northSideDoor.open();

        assertThat(aRoom.go(Direction.NORTH)).isInstanceOf(Room.class);
    }

    @Test
    public void
    can_toggle_a_door() throws NotADoorException {
        aRoom.toggleDoor(Direction.NORTH);
        verify(northSideDoor).toggle();
    }

    @Test
    public void
    cannot_toggle_a_thing_that_is_not_a_door() {
        assertThatThrownBy(() -> aRoom.toggleDoor(Direction.SOUTH)).isInstanceOf(NotADoorException.class);
    }
}
