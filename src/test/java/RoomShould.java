import domain.Direction;
import domain.Room;
import domain.Wall;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class RoomShould {
    @Test public void
    have_four_sides() {
        Wall northSideWall = new Wall();
        Wall southSideWall = new Wall();
        Wall eastSideWall = new Wall();
        Wall westSideWall = new Wall();

        Room room = new Room(northSideWall, southSideWall, eastSideWall, westSideWall);

        assertThat(room.getSide(Direction.NORTH)).isEqualTo(northSideWall);
        assertThat(room.getSide(Direction.SOUTH)).isEqualTo(southSideWall);
        assertThat(room.getSide(Direction.EAST)).isEqualTo(eastSideWall);
        assertThat(room.getSide(Direction.WEST)).isEqualTo(westSideWall);
    }
}
