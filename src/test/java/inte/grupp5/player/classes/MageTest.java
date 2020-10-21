package inte.grupp5.player.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {
    Mage mage = new Mage();

    @Test
    void getStartingHealth() {
        assertEquals(100, mage.getStartingHealth());
    }

    @Test
    void setStartingHealth() {
        mage.setStartingHealth(200);
        assertEquals(200, mage.getStartingHealth());
    }

    @Test
    void getStartingMana() {
        assertEquals(100, mage.getStartingMana());
    }

    @Test
    void setStartingMana() {
        mage.setStartingMana(200);
        assertEquals(200, mage.getStartingMana());
    }

    @Test
    void getHealthPerLvl() {
        assertEquals(100, mage.getStartingMana());
    }
}