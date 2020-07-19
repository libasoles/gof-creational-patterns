package domain.enchantedLabyrinth;

import domain.Room;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
        System.out.println("Strange things will happen here.");
    }
}
