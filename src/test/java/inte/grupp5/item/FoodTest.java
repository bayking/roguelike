package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    private final Food steak50Health = new Food("Steak", 50);

    @Test
    void NameMatches() {
        assertEquals("Steak", steak50Health.getName());
    }

    @Test
    void healthBonusMatches() {
        assertEquals(50, steak50Health.getHealthBonus());
    }
}