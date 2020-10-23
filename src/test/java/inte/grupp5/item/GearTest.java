package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearTest {

    private final Gear gloves = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR);

    @Test
    void valueMatches() {
        assertEquals(0.5, gloves.getValue());
    }

}