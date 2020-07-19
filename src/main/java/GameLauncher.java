import domain.LabyrinthGame;
import factories.BombedLabyrinthFactory;
import factories.LabyrinthFactory;

public class GameLauncher {
    public static void main(String[] args) {
        LabyrinthGame game = new LabyrinthGame();
        LabyrinthFactory factory = new BombedLabyrinthFactory();

        game.createLabyrinth(factory);
    }
}
