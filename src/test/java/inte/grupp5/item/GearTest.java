package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearTest {

    private final Gear glowes = new Armor("Glowes", 4, 2, Armor.ArmorType.LIGHT_ARMOR);

    @Test
    void valueMatches() {
        assertEquals(0.5, glowes.getValue());
    }

}