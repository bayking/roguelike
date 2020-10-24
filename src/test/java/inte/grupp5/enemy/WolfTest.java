
package inte.grupp5.enemy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static inte.grupp5.enemy.Enemy.ATTRIBUTES_CALC;
import static org.junit.jupiter.api.Assertions.*;

public class WolfTest {

    @BeforeAll
    @Test
    public static void wolfIdIsCorrect () {
        Wolf wolf = new Wolf(35,0);
        assertEquals(2, wolf.getENEMY_ID());
    }

    @BeforeAll
    @Test
    public static void toStringHasRightFormatForOneWolf() {
        Wolf wolf = new Wolf(31,0);
        assertEquals( "Enemy type = Wolf, Level = 31, Health = 146, Damage = 15, Wolf ID = 1"+"\n", wolf.toString());
    }

    @Test
    void getRandomReturnsNumberBetween1And5 () {
        Wolf wolf = new Wolf(10,0);
        assertTrue(wolf.getRandom().get(0) >= 1 && wolf.getRandom().get(0) <= 5);

    }


    @Test
    void randomNumberGeneratorBetween1and5 () {
        Wolf w = new Wolf(20,0);
        assertTrue(w.randomWolvesGenerator() >= 1 && 5 >= w.randomWolvesGenerator());
    }
    @Test
    void constructorIsCorrectforOneWolf() {
        Wolf w = new Wolf (40,0);
        assertEquals(40,w.getLevel());
        assertEquals("Wolf",w.getEnemyType());
        assertEquals(20,w.getDamage(40));
        assertEquals(160,w.getHealth(40));
    }

    @Test
    void constructorIsCorrectForManyWolves() {
        Wolf w = new Wolf (21,5);

        assertTrue(w.getGroupOfWolves().size() >= 2);
        assertTrue(w.getGroupOfWolves().get(1).getLevel() >= w.getLevel());
        assertEquals(w.getGroupOfWolves().get(1).getEnemyType(), "Wolf");
        assertTrue(w.getGroupOfWolves().get(1).getDamage(w.getLevel()) <= (ATTRIBUTES_CALC * 21) - 21);
        assertTrue(w.getGroupOfWolves().get(1).getHealth(w.getLevel()) <= ATTRIBUTES_CALC * 21 + 131);
    }

    @Test
    void checkIfBelowLevel30MethodWasCalled () {
        Wolf w = new Wolf (21,0);
        assertTrue(w.getGroupOfWolves().size() >= 2);
        System.out.println(w.getGroupOfWolves().size());
    }

    @Test void addWolvesIfBelowLevel () {
        Wolf w = new Wolf (21,0);
        assertTrue(w.getGroupOfWolves().size() >= 1);
    }

    @Disabled
    @Test
    void wolfIdIsCorrectForManyWolves () {

    }

    @Disabled
    @Test
    void toStringHasRightFormatForManyWolves() { }


}