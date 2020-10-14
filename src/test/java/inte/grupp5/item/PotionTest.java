package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    private final Potion potionOfHealth60Hp = new Potion("Potion of health", 60);

    @Test
    void NameMatches() {
        assertEquals("Potion of health", potionOfHealth60Hp.getName());
    }

    @Test
    void healthBonusMatches() {
        assertEquals(60, potionOfHealth60Hp.getHealthBonus());
    }
}