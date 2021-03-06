package inte.grupp5.enemy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class DragonTest {

    Dragon drag = new Dragon(50);

    @Test
    void checkIfHealsIself () {
        Dragon d = new Dragon(50);
        d.healItself();
        assertEquals(200,d.getCurrentHealth());
    }



    @Test
    void breathFireAttackHasCorrectValue () {
        Dragon d = new Dragon(51);
        d.breathFireAttack();
        assertEquals( 50,d.getCurrentDamage());
        assertEquals(75,d.getCurrentMana());
    }


    @ParameterizedTest
    @ValueSource(ints = {75, 50, 25})
    void fireAttackManaIsCorrectValue (int mana){
        drag.setMana(mana + 25);
        drag.breathFireAttack();
        assertEquals(mana, drag.getCurrentMana());
    }

    @Test
    void constructorThrowsIfLevelAboveCertainValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Dragon(1000);
        });
    }


    @Test
    void constructorThrowsIfLevelBelowCertainValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Dragon(-1);
        });
    }

    @Test
    void fireAttackThrowsIfManaToLow () {
        assertThrows(IllegalArgumentException.class, () -> {
            Dragon d = new Dragon(50);
            d.setMana(10);
            d.breathFireAttack();
        });
    }

    @Test
    void constructorThrowsIfNegativeValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            Dragon d = new Dragon(-50);
            d.breathFireAttack();
        });
    }








}