package inte.grupp5.player;

import inte.grupp5.player.classes.Class;
import inte.grupp5.player.classes.Mage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player("Tester", new Mage("Mage"), 1);

    @Test
    void setCurrentHealthPointsZero() {
        player.setCurrentHealthPoints(0);
        assertEquals(0, player.getCurrentHealthPoints());
    }

    @Test
    void setCurrentHealthPointsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setCurrentHealthPoints(-1));
    }

    @Test
    void setCurrentHealthPointsOverMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setCurrentHealthPoints(player.getMaxHealthPoints()+1));
    }
    @Test
    void setCurrentHealthPointsMax() {
        player.setCurrentHealthPoints(player.getMaxHealthPoints());
        assertEquals(player.getMaxHealthPoints(), player.getCurrentHealthPoints());
    }

    @Test
    void healHealthIsFull() {
        player.heal();
        assertEquals(100, player.getCurrentHealthPoints());
    }

    @Test
    void setLevel() {
    }

    @Test
    void hasMana() {

    }
}