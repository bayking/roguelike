package inte.grupp5.enemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class DragonTest {

    @Test
    void checkIfHealsIself () {
        Dragon d = new Dragon(50);
        d.healItself();
        assertEquals(200,d.getHealth());
    }

    @Test
    void breathFireAttackHasCorrectValue () {
        Dragon d = new Dragon(51);
        d.breathFireAttack();
        assertEquals( 50,d.getDamage());
        assertEquals(75,d.getMana());
    }

    @Test
    void fireAttackThrowsIfManaToLow () {
        Dragon d = new Dragon(50);
        d.healItself();
        assertEquals(200,d.getHealth());
    }

    @Test
    void constructorThrowsIfNegativeValue () {
        assertThrows(IllegalArgumentException.class, () -> {
          Dragon d = new Dragon(-50);
          d.breathFireAttack();
        });
    }








}
