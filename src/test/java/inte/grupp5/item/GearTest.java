package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearTest {

    private final Gear GLOVES_WITH_NO_ENCHANTMENT = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.NONE);
    private final Gear GLOVES_WITH_QUAD = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.QUAD_DAMAGE);
    private final Gear GLOVES_WITH_INVIS = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.INVISIBILITY);
    private final Gear GLOVES_WITH_PROTEC = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.PROTECTION);

    @Test
    void valueMatches() {
        assertEquals(0.5, GLOVES_WITH_NO_ENCHANTMENT.getValue());
        assertEquals(17.0, GLOVES_WITH_QUAD.getValue());
        assertEquals(30.5, GLOVES_WITH_INVIS.getValue());
        assertEquals(25.0, GLOVES_WITH_PROTEC.getValue());
    }

    @Test
    void gearHasEnchantment() {
        assertEquals(Gear.Enchantment.NONE, GLOVES_WITH_NO_ENCHANTMENT.getEnchantment());
        assertEquals(Gear.Enchantment.QUAD_DAMAGE, GLOVES_WITH_QUAD.getEnchantment());
        assertEquals(Gear.Enchantment.INVISIBILITY, GLOVES_WITH_INVIS.getEnchantment());
        assertEquals(Gear.Enchantment.PROTECTION, GLOVES_WITH_PROTEC.getEnchantment());
    }

}