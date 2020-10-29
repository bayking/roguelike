
package inte.grupp5.enemy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static inte.grupp5.enemy.Enemy.ATTRIBUTES_CALC;
import static org.junit.jupiter.api.Assertions.*;

public class WolfTest {


    @Test
    public void constructorThrowsIfAmountNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Wolf(10,-1);
        });}

    @Test
    public void constructorThrowsIfAmountToHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Wolf(10,101);
        });}

    @Test
    public void wolfIdIsSet () {
        Enemy w = new Wolf(35,0);
        assertTrue(1 <= w.getENEMY_ID());
    }


    @Test
    public void toStringHasRightFormatForOneWolf() {
        Wolf d = new Wolf(31,0);
        assertEquals( "Enemy type = Wolf, Level = 31, Health = 146, Damage = 15, Wolf ID = " + d.getENEMY_ID() + "\n" , d.toString());
    }


    @Test
    void randomNumberGeneratorBetween1and5 () {
        // När enemy skapas så skapas 1-5 extra om level är >30
        Wolf w = new Wolf(20,0);
        // Metod som returnerar en int mellan 1-5
        assertTrue(w.randomWolvesGenerator() >= 1 && 5 >= w.randomWolvesGenerator());
    }

    @Test
    void constructorIsCorrectforOneWolf() {
        Wolf w = new Wolf (40,0);
        assertEquals(40,w.getLevel());
        assertEquals("Wolf",w.getEnemyType());
        assertEquals(20,w.getCurrentDamage());
        assertEquals(160,w.getCurrentHealth());
    }

    @Test
    void constructorIsCorrectForManyWolves() {
        Wolf w = new Wolf (21,5);
        assertEquals("Wolf", w.getGroupOfWolves().get(1).getEnemyType());
        assertEquals(6, w.getGroupOfWolves().size());
        assertTrue(w.getGroupOfWolves().get(1).getLevel() >= w.getLevel());
        assertTrue(w.getGroupOfWolves().get(1).getCurrentDamage() >=  (ATTRIBUTES_CALC * 21) - 21);
        assertTrue(w.getGroupOfWolves().get(1).getCurrentHealth() >= ATTRIBUTES_CALC * 21 + 100);
    }

    @Test
    void constructorIsCorrectForManyWolvesIfLevelToLow() {
        Wolf w = new Wolf (20,0);
        assertEquals("Wolf", w.getGroupOfWolves().get(1).getEnemyType());
        assertTrue(w.getGroupOfWolves().size() >= 2 && w.getGroupOfWolves().size() <= 6);
        assertTrue(w.getGroupOfWolves().get(1).getLevel() >= w.getLevel());
        assertTrue(w.getGroupOfWolves().get(1).getCurrentDamage() >=  (ATTRIBUTES_CALC * 20) - 20);
        assertTrue(w.getGroupOfWolves().get(1).getCurrentHealth() >= ATTRIBUTES_CALC * 20 + 100);

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

    @Test
    void groupOfWolvesContainsOnlyOneWolf() {
        Wolf w = new Wolf(50,0);
        assertEquals(1,w.getGroupOfWolves().size());
    }

    @Test
    void groupOfWolvesContainsMoreThanOne() {
        Wolf w = new Wolf(50,0);
        Wolf d = new Wolf(50,0);
        w.getGroupOfWolves().add(d);
        assertEquals(2,w.getGroupOfWolves().size());
    }




}