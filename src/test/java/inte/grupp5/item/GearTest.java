package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearTest {

    private final Gear GLOVES_WITH_NO_ENCHANTMENT = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.NONE);
    private final Gear GLOVES_WITH_QUAD = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.QUAD_DAMAGE);
    private final Gear GLOVES_WITH_INVIS = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.INVISIBILITY);
    private final Gear GLOVES_WITH_PROTEC = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.PROTECTION);
    private final Gear GLOVES_WITH_INFERNO = new Armor("Gloves", 4, 2, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.INFERNO);

    @Test
    void valueMatches() {
        assertEquals(0.5, GLOVES_WITH_NO_ENCHANTMENT.getValue());
        assertEquals(17.0, GLOVES_WITH_QUAD.getValue());
        assertEquals(30.5, GLOVES_WITH_INVIS.getValue());
        assertEquals(25.0, GLOVES_WITH_PROTEC.getValue());
        assertEquals(20.5, GLOVES_WITH_INFERNO.getValue());
    }

    @Test
    void gearHasEnchantment() {
        assertEquals(Gear.Enchantment.NONE, GLOVES_WITH_NO_ENCHANTMENT.getEnchantment());
        assertEquals(Gear.Enchantment.QUAD_DAMAGE, GLOVES_WITH_QUAD.getEnchantment());
        assertEquals(Gear.Enchantment.INVISIBILITY, GLOVES_WITH_INVIS.getEnchantment());
        assertEquals(Gear.Enchantment.PROTECTION, GLOVES_WITH_PROTEC.getEnchantment());
        assertEquals(Gear.Enchantment.INFERNO, GLOVES_WITH_INFERNO.getEnchantment());
    }

    @Test
    void gearEnchantmentHasCorrectDuration() {
        assertEquals(0, GLOVES_WITH_NO_ENCHANTMENT.getEnchantment().getDuration());
        assertEquals(15, GLOVES_WITH_QUAD.getEnchantment().getDuration());
        assertEquals(30, GLOVES_WITH_INVIS.getEnchantment().getDuration());
        assertEquals(20, GLOVES_WITH_PROTEC.getEnchantment().getDuration());
        assertEquals(20, GLOVES_WITH_INFERNO.getEnchantment().getDuration());
    }

    @Test
    void gearEnchantmentHasCorrectDamageModifier() {
        assertEquals(1, GLOVES_WITH_NO_ENCHANTMENT.getEnchantment().getDamageModifier());
        assertEquals(4, GLOVES_WITH_QUAD.getEnchantment().getDamageModifier());
        assertEquals(1, GLOVES_WITH_INVIS.getEnchantment().getDamageModifier());
        assertEquals(1, GLOVES_WITH_PROTEC.getEnchantment().getDamageModifier());
        assertEquals(1, GLOVES_WITH_INFERNO.getEnchantment().getDamageModifier());
    }

    @Test
    void gearEnchantmentHasCorrectArmorModifier() {
        assertEquals(1, GLOVES_WITH_NO_ENCHANTMENT.getEnchantment().getArmorModifier());
        assertEquals(1, GLOVES_WITH_QUAD.getEnchantment().getArmorModifier());
        assertEquals(1, GLOVES_WITH_INVIS.getEnchantment().getArmorModifier());
        assertEquals(10, GLOVES_WITH_PROTEC.getEnchantment().getArmorModifier());
        assertEquals(1, GLOVES_WITH_INFERNO.getEnchantment().getArmorModifier());
    }

    @Test
    void gearEnchantmentHasCorrectMuffle() {
        assertFalse(GLOVES_WITH_NO_ENCHANTMENT.getEnchantment().isMuffled());
        assertFalse(GLOVES_WITH_QUAD.getEnchantment().isMuffled());
        assertTrue(GLOVES_WITH_INVIS.getEnchantment().isMuffled());
        assertFalse(GLOVES_WITH_PROTEC.getEnchantment().isMuffled());
        assertFalse(GLOVES_WITH_INFERNO.getEnchantment().isMuffled());
    }

    @Test
    void gearEnchantmentHasCorrectAOE() {
        assertFalse(GLOVES_WITH_NO_ENCHANTMENT.getEnchantment().doesDamageToNearby());
        assertFalse(GLOVES_WITH_QUAD.getEnchantment().doesDamageToNearby());
        assertFalse(GLOVES_WITH_INVIS.getEnchantment().doesDamageToNearby());
        assertFalse(GLOVES_WITH_PROTEC.getEnchantment().doesDamageToNearby());
        assertTrue(GLOVES_WITH_INFERNO.getEnchantment().doesDamageToNearby());
    }

    @Test
    void armorWithNegativeArmorRatingThrowsIAE() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Armor("Gear", 1, -1, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.NONE));
    }

    @Test
    void armorWithNullEnchantmentThrowsIAE() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Armor("Gear", 1, 1, Armor.ArmorType.LIGHT_ARMOR, null));
    }

    @Test
    void usingEnchantmentOnArmorWithNoEnchantmentThrowsISE() {
        Paladin PALADIN = new Paladin("Paladin");
        Player p1 = new Player("Player", PALADIN, 1);
        Assertions.assertThrows(IllegalStateException.class, () ->
                new Armor("Gear", 1, 1, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.NONE).useEnchantment(p1));
    }

}