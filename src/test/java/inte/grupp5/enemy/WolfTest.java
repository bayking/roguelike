package inte.grupp5.enemy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static inte.grupp5.enemy.Enemy.ATTRIBUTES_CALC;
import static org.junit.jupiter.api.Assertions.*;

public class WolfTest {


    @Test
    void randomNumberGeneratorBetween1and5 () {
        Wolf w = new Wolf(20);
        assertTrue(w.randomWolvesGenerator() >= 1 && 5 >= w.randomWolvesGenerator());
    }
    @Test
    void constructorIsCorrectforOneWolf() {
        Wolf w = new Wolf (40);
        assertEquals(40,w.getLevel());
        assertEquals("Wolf",w.getEnemyType());
        assertEquals(20,w.getDamage(40));
        assertEquals(160,w.getHealth(40));
    }

    @Test
    void constructorIsCorrectForManyWolves() {
        Wolf w = new Wolf (21);

        assertTrue(w.getGroupOfWolves().size() >= 1);
        assertTrue(w.getGroupOfWolves().get(1).getLevel() >= w.getLevel());
        assertEquals(w.getGroupOfWolves().get(1).getEnemyType(), "Wolf");
        assertTrue(w.getGroupOfWolves().get(1).getDamage(w.getLevel()) <= (ATTRIBUTES_CALC * 21) - 21);
        assertTrue(w.getGroupOfWolves().get(1).getHealth(w.getLevel()) <= ATTRIBUTES_CALC * 21 + 131);
    }

    @Test
    void checkIfBelowLevel30MethodWasCalled () {
        Wolf w = new Wolf (21);
        assertTrue(w.getRandom().size() >= 1);
    }

    @Test void addWolvesIfBelowLevelValueIsAboveOne () {
        Wolf w = new Wolf (21);
        assertTrue(w.getGroupOfWolves().size() >= 1);
    }

    @Test
    void toStringHasRightFormatForOneWolf() {
        Wolf w = new Wolf (31);
        assertEquals( "Enemy type = Wolf, Level = 31, Health = 146, Damage = 15, Wolf ID = Wolf 1"+"\n", w.toString());
    }

    @Test
    void wolfIdIsCorrect () {
        Wolf w = new Wolf (31);
        assertEquals("Wolf 1", w.getWolfId());

    }
    @Disabled
    @Test
    void wolfIdIsCorrectForManyWolves () {

    }

    @Disabled
    @Test
    void toStringHasRightFormatForManyWolves() { }


}