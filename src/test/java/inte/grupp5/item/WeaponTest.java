package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    //                Weapon(name, damage, weight, value)
    Weapon sword10DMG5WGT5VAL = new Weapon("Sword", 10, 5, 5);

    @Test
    void weaponDamageMatchesGivenValue() {
        assertEquals(10, sword10DMG5WGT5VAL.getDamage());
    }

}