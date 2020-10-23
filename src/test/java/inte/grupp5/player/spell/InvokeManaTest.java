package inte.grupp5.player.spell;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvokeManaTest {

    InvokeMana invokeMana = new InvokeMana();

    @Test
    void castAtLvlReqSelf() {
        Player player = new Player("player", new Mage("mage"), 10);
        int expected = player.getCurrentManaPoints();
        player.setCurrentManaPoints(10);
        assertTrue(invokeMana.cast(player));
        assertEquals(expected, player.getCurrentManaPoints());
    }

    @Test
    void castBelowLvlReqSelf() {
        Player player = new Player("player", new Mage("mage"), 1);
        player.setCurrentManaPoints(10);
        assertFalse(invokeMana.cast(player));
        assertEquals(10, player.getCurrentManaPoints());
    }

    @Test
    void castAtLvlReqTarget() {
        Player player = new Player("player", new Mage("mage"), 10);
        Player target = new Player("target", new Mage("mage"), 1);
        int expected = target.getCurrentManaPoints();
        target.setCurrentManaPoints(10);
        assertTrue(invokeMana.cast(player, target));
        assertEquals(expected, target.getCurrentManaPoints());
    }

    @Test
    void castBelowLvlReqTarget() {
        Player player = new Player("player", new Mage("mage"), 1);
        Player target = new Player("target", new Mage("mage"), 10);
        target.setCurrentManaPoints(10);
        assertFalse(invokeMana.cast(player, target));
        assertEquals(10, target.getCurrentManaPoints());
    }
}