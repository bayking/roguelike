package inte.grupp5.player.spell;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashOfLightTest {

    FlashOfLight fol = new FlashOfLight();

    @Test
    void castAtLvlReqSelfWithMana() {
        Player player = new Player("player", new Paladin("paladin"), 10);
        player.setCurrentHealthPoints(50);
        int expected = player.getCurrentHealthPoints() + 50;
        assertTrue(fol.cast(player));
        assertEquals(expected, player.getCurrentHealthPoints());
        assertEquals(player.getMaxManaPoints()-25, player.getCurrentManaPoints());
    }

    @Test
    void castAtLvlReqSelfWithoutMana() {
        Player player = new Player("player", new Paladin("paladin"), 10);
        assertFalse(fol.cast(player));
    }

    @Test
    void castAsMageSelf() {
        Player player = new Player("player", new Mage("mage"), 10);
        assertFalse(fol.cast(player));
    }

    @Test
    void castAsMageTarget() {
        Player caster = new Player("player", new Mage("mage"), 10);
        Player target = new Player("player", new Mage("mage"), 10);
        assertFalse(fol.cast(caster, target));
    }


    @Test
    void castAtLvlReqTargetWithMana() {
        Player player = new Player("player", new Paladin("paladin"), 10);
        Player target = new Player("target", new Mage("mage"), 1);
        target.setCurrentHealthPoints(50);
        int expected = 100;
        assertTrue(fol.cast(player, target));
        assertEquals(expected, target.getCurrentHealthPoints());
        assertEquals(player.getMaxManaPoints()-25, player.getCurrentManaPoints());
    }

    @Test
    void castBelowLvlReqTarget() {
        Player player = new Player("player", new Mage("mage"), 1);
        Player target = new Player("target", new Mage("mage"), 10);
        assertFalse(fol.cast(player, target));
    }


}