package inte.grupp5.player.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassTest {
    Class c1 = new Class() {
    };

    @Test
    void initArrayWithNegativeValues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> c1.initArrays(-1, -3));
    }

    @Test
    void initArrayWithZeros() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> c1.initArrays(0, 0));
    }

    @Test
    void initArrayWithPositiveValues() {
        int health = 100;
        int mana = 50;
        c1.initArrays(health,mana);
        for (int i = 1; i<=60;i++) {
            assertEquals(health, c1.getHealth(i));
            assertEquals(mana, c1.getMana(i));
            health+=100;
            mana+=100;
        }
    }

    @Test
    void initArrayWithNegativeAndPositiveValues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> c1.initArrays(12, 0));
    }

    @Test
    void getHealthWithZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> c1.getHealth(0));
    }

    @Test
    void getHealthWithNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> c1.getHealth(-1));
    }

    @Test
    void getHealthWithAboveSixty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> c1.getHealth(61));
    }

    @Test
    void getHealthWithOne() {
        Class c2 = new Class() {
        };
        c2.initArrays(100, 100);
        assertEquals(100, c2.getHealth(1));
    }

    @Test
    void getHealthWithSixty() {
        Class c2 = new Class() {
        };
        c2.initArrays(100, 100);
        assertEquals(6000, c2.getHealth(60));
    }

    @Test
    void testEquals() {
        Mage mage = new Mage();
        Mage mage1 = new Mage();
        assertEquals(mage1, mage);
    }

    @Test
    void testHashCode() {
        Mage mage = new Mage();
        Mage mage1 = new Mage();
        assertEquals(mage1.hashCode(), mage.hashCode());
    }
}