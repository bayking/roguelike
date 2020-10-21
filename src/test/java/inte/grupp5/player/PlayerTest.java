package inte.grupp5.player;

import inte.grupp5.player.classes.Mage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player("Tester", new Mage(), 1);

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
    void setLevelZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setLevel(0));
    }

    @Test
    void setLevelNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setLevel(-1));
    }
    @Test
    void setLevelOver60() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setLevel(61));
    }
    @Test
    void setLevelInRange() {
        player.setLevel(35);
        assertEquals(35, player.getLevel());
    }

    @Test
    void hasManaForSpellZero() {
        assertTrue(player.hasManaForSpell(0));
    }

    @Test
    void hasManaForSpellNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.hasManaForSpell(-1));
    }

    @Test
    void hasManaForSpellMoreThanCurrentMana() {
        assertFalse(player.hasManaForSpell(player.getCurrentManaPoints() + 1));
    }

    @Test
    void hasManaForSpell() {
        assertTrue(player.hasManaForSpell(1));
    }

    @Test
    void getName() {
        String expected = "Tester";
        assertEquals(expected, player.getName());
    }

    @Test
    void getKlass() {
        Mage mage = new Mage();
        assertEquals(mage, player.getKlass());
    }

    @Test
    void getMaxHealthPoints() {
        assertEquals(100, player.getMaxHealthPoints());
    }

    @Test
    void setMaxHealthPointsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setMaxHealthPoints(0));
    }

    @Test
    void setMaxHealthPointsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setMaxHealthPoints(-1));
    }


    @Test
    void setMaxHealthPointsPositive() {
        player.setMaxHealthPoints(30000);
        assertEquals(30000, player.getMaxHealthPoints());
    }
}