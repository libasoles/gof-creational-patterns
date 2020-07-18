package domain;

import domain.exceptions.CannotGoThroughObjectException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DoorShould {
    @Mock
    Room aRoom;
    @Mock
    Room aSecondRoom;
    Door aDoor;

    @Before
    public void setUp() {
        aDoor = new Door(aRoom, aSecondRoom);
    }

    @Test
    public void
    return_the_room_from_the_other_side() {
        assertThat(aDoor.otherSideOf(aRoom)).isEqualTo(aSecondRoom);
    }

    @Test
    public void
    allow_to_pass_if_open() throws CannotGoThroughObjectException {
        aDoor.open();

        assertThat(aDoor.enterFrom(aRoom)).isInstanceOf(Room.class);
    }

    @Test
    public void
    not_allow_to_pass_if_close() {
        assertThatThrownBy(() -> aDoor.enterFrom(aRoom)).isInstanceOf(CannotGoThroughObjectException.class);
    }

    @Test
    public void
    toggle() {
        assertFalse(aDoor.isOpen());

        aDoor.open();

        assertTrue(aDoor.isOpen());
    }
}
