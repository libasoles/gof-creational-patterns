package domain;

import domain.exceptions.CannotGoThroughObjectException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mock;

public class WallShould {
    @Mock
    Room aRoom;

    @Test
    public void
    not_allow_to_enter() {
        Wall wall = new Wall();

        Assertions.assertThatThrownBy(() -> wall.enterFrom(aRoom)).isInstanceOf(CannotGoThroughObjectException.class);
    }
}