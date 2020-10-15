package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    Weapon sword5WGT10DMG =
            new Weapon("Sword of might", 5, 10, Weapon.WeaponType.SWORD);

    @Test
    void nameMatches() {
        assertEquals("Sword of might", sword5WGT10DMG.getName());
    }

    @Test
    void weaponDamageMatches() {
        assertEquals(10, sword5WGT10DMG.getDamage());
    }

    @Test
    void weightMatches() {
        assertEquals(5, sword5WGT10DMG.getWeight());
    }

    @Test
    void valueMatches() {
        assertEquals(15, sword5WGT10DMG.getValue());
    }

    @Test
    void weaponTypeMatches() {
        assertEquals(Weapon.WeaponType.SWORD, sword5WGT10DMG.getWeaponType());
    }

    @Test
    void rangeMatches() {
        assertEquals(1, sword5WGT10DMG.getWeaponType().getRange());
    }
}