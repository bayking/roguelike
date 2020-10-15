package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void weaponDamageMatchesGivenValue() {
        Weapon sword5WGT10DMG = new Weapon("Sword", 5, 10);
        assertEquals(10, sword5WGT10DMG.getDamage());
    }

}