package inte.grupp5.enemy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static inte.grupp5.enemy.Enemy.ATTRIBUTES_CALC;
import static org.junit.jupiter.api.Assertions.*;

public class WolfTest {

    @Test
    void wolfConstructorThrowsIfEnemyTypeWrong () {
        assertThrows(IllegalArgumentException.class, () -> new Wolf(30,"Varg"));
        assertThrows(IllegalArgumentException.class, () -> new Wolf(30,null));
    }

    @Test
    void randomNumberGeneratorBetween1and5 () {
        Wolf w = new Wolf(20, "Wolf");
        assertTrue(w.randomWolvesGenerator() >= 1 && 5 >= w.randomWolvesGenerator());
    }
    @Test
    void constructorIsCorrectforOneWolf() {
        Wolf w = new Wolf (40);
        assertEquals(40,w.getLevel());
        assertEquals("Wolf",w.getEnemyType());
        assertEquals(20,w.getAttackDamage(40));
        assertEquals(90,w.getHealth(40));

    }

    @Test
    void constructorIsCorrectForManyWolves() {
        Wolf w = new Wolf (21,"Wolf");

        assertTrue(w.getGroupOfWolfes().size() >= 1);
        assertTrue(w.getGroupOfWolfes().get(1).getLevel() >= w.getLevel());
        assertEquals(w.getGroupOfWolfes().get(1).getEnemyType(), "Wolf");
        assertTrue(w.getGroupOfWolfes().get(1).getAttackDamage(w.getLevel()) <= (ATTRIBUTES_CALC * 21) - 21);
        assertTrue(w.getGroupOfWolfes().get(1).getHealth(w.getLevel()) <= ATTRIBUTES_CALC * 21 + 30);

    }


    @Test
    void ifcheckIfBelowLevel30WasCalled () {
        Wolf w = new Wolf (21,"Wolf");
        assertTrue(w.getRandom().size() >= 1);
    }

    @Test void addWolvesIfBelowLevelValueIsAboveOne () {
        Wolf w = new Wolf (21,"Wolf");
        assertTrue(w.getGroupOfWolfes().size() >= 1);
    }

    @Test
    void toStringHasRightFormatForOneWolf() {
        Wolf w = new Wolf (31,"Wolf");
        assertEquals( "Enemy type = Wolf Level = 31 Health = 76 Attack damage = 15", w.toString());
    }

    @Disabled
    @Test
    void toStringHasRightFormatForManyWolves() { }

}