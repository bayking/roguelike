package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void instantiatingWithNameEmptyOrNullThrowsIAE() {
        assertThrows(IllegalArgumentException.class, () -> new Weapon("", 10, 5, Weapon.WeaponType.SWORD));
        assertThrows(IllegalArgumentException.class, () -> new Weapon(" ", 10, 5, Weapon.WeaponType.BOW));
        assertThrows(IllegalArgumentException.class, () -> new Weapon(null, 10, 5, Weapon.WeaponType.STAFF));
    }

    @Test
    void instantiatingWithWeightAtZeroOrBelowThrowsIAE() {
        assertThrows(IllegalArgumentException.class, () ->
                new Potion("Potion", 0, Potion.PotionType.HEALTH_POTION));
        assertThrows(IllegalArgumentException.class, () ->
                new Potion("Potion", -1, Potion.PotionType.LEVEL_POTION));
    }
}