package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    final Armor helmet = new Armor("Helmet", 10, 7, Armor.ArmorType.HEAVY_ARMOR, Gear.Enchantment.NONE);
    final Armor chestPlate = new Armor("Chest plate", 20, 22, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.NONE);

    @Test
    void armorTypeMatches() {
        assertEquals(Armor.ArmorType.HEAVY_ARMOR, helmet.getArmorType());
        assertEquals(Armor.ArmorType.LIGHT_ARMOR, chestPlate.getArmorType());
    }

    @Test
    void toStringMatches() {
        assertEquals("[Name: Helmet, Weight: 10.00, Armor rating: 7, Armor type: HEAVY_ARMOR]", helmet.toString());
    }

    @Test
    void enchantmentMatches() {
        assertEquals(Gear.Enchantment.NONE, helmet.getEnchantment());
        assertEquals(Gear.Enchantment.NONE, chestPlate.getEnchantment());
    }

}