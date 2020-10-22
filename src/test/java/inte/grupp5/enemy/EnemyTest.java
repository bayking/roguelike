package inte.grupp5.enemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    void constructorThrowsIfNegativeValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Enemy(-1);
        });
    }

    @Test
    void constructorThrowsIfLevelAboveCertainValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Enemy(1000);
        });
    }

    @Test
    void healthIsCalculatedCorrect() {
        Enemy e = new Enemy(20);
        assertEquals(130,e.getHealth(20));
    }

    @Test
    void damageIsCalculatedCorrect() {
        Enemy e = new Enemy(21);
        assertEquals(10,e.getDamage(21));
    }



    @Test
    void enemyHasCorrectValues () {
        Enemy e = new Enemy(50);
        assertEquals(50,e.getLevel());
        assertEquals(175,e.getHealth(e.getLevel()));
        assertEquals(25,e.getDamage(e.getLevel()));
    }

    @Test
    void enemyTypeHasRightName () {
        Enemy e = new Enemy(10);
        assertEquals("Enemy",e.getEnemyType());
    }

    @Test
    void LevelIsCorrect() {
        Enemy e = new Enemy(20);
        assertEquals(20,e.getLevel());
    }



    @Test
    void healthIsCorrectAftertakeDamageCalled() {
        Enemy e = new Enemy(30);
        e.takeDamage(30);
        assertEquals(115,e.getHealth());
    }

    @Test
    void toStringIsCorrect() {
        Enemy e = new Enemy(58);
        assertEquals(" Enemy type = Enemy, Level = 58, Health = 187, Damage = 29," + " Enemy ID = " + e.getEnemyID(), e.toString());
    }


}
