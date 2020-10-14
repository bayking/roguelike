package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    private final Potion potionOfHealth = new Potion("Potion of health", Potion.Type.HEALTH);
    private final Potion potionOfMana = new Potion("Potion of mana", Potion.Type.MANA);
    private final Potion potionOfLevel = new Potion("Potion of level", Potion.Type.LEVEL);

    @Test
    void nameMatches() {
        assertEquals("Potion of health", potionOfHealth.getName());
    }

    @Test
    void healthBonusMatches() {
        assertEquals(100, potionOfHealth.getType().getValue());
    }

    @Test
    void manaBonusMatches() {
        assertEquals(100, potionOfMana.getType().getValue());
    }

    @Test
    void levelBonusMatches() {
        assertEquals(1, potionOfLevel.getType().getValue());
    }
}