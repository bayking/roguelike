package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    private final Potion potionOfHealth =
            new Potion("Potion of health", 1, Potion.PotionType.HEALTH_POTION);
    private final Potion potionOfMana =
            new Potion("Potion of mana", 1, Potion.PotionType.MANA_POTION);
    private final Potion potionOfLevel =
            new Potion("Potion of level", 2, Potion.PotionType.LEVEL_POTION);

    @Test
    void nameMatches() {
        assertEquals("Potion of health", potionOfHealth.getName());
    }

    @Test
    void restoreValueMatches() {
        assertEquals(100, potionOfHealth.getPotionType().getRestoreValue());
        assertEquals(100, potionOfMana.getPotionType().getRestoreValue());
        assertEquals(1, potionOfLevel.getPotionType().getRestoreValue());
    }

    @Test
    void weightMatches() {
        assertEquals(1, potionOfHealth.getWeight());
        assertEquals(2, potionOfLevel.getWeight());
    }

    @Test
    void valueMatches() {
        assertEquals(20, potionOfHealth.getValue());
        assertEquals(40, potionOfLevel.getValue());
        assertEquals(20, potionOfMana.getValue());
    }

    @Test
    void typeMatches() {
        assertEquals(Potion.PotionType.LEVEL_POTION, potionOfLevel.getPotionType());
    }

    @Test
    void toStringMatches() {
        assertEquals("[Name: Potion of health, Weight: 1.00, Potion type: HEALTH_POTION]", potionOfHealth.toString());
    }
}