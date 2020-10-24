package inte.grupp5.enemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnemyTest {


    @Test
    void getEnemyReturnsRightEnemy () {
        Enemy e = new Enemy(23);
        assertEquals(23,e.getEnemy().getLevel());
    }

    @Test
    void getLevelIsCorrect () {
        Enemy e = new Enemy(26);
        assertEquals(26,e.getLevel());
    }

    @Test
    void setHpIsCorrectValueIfNegative () {
        Enemy e = new Enemy(50);
        e.setHp(-1);
        assertEquals(0,e.getHealth());
    }

    @Test
    void setHpIsCorrectValue () {
        Enemy e = new Enemy(50);
        e.setHp(10);
        assertEquals(10,e.getHealth());
    }

    @Test
    void setDamageThrowsIfNegativeValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy e = new Enemy(10);
            e.setDamage(-1);
        });
    }

    @Test
    void setDamageSetsCorrectValue () {
        Enemy e = new Enemy(50);
        e.setDamage(11);
        assertEquals(11,e.getDamage());
    }

    @Test
    void getDamageReturnsCorrectValue() {
        Enemy e = new Enemy(10);
        assertEquals(5,e.getDamage());
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
        assertEquals(" Enemy type = Enemy, Level = 58, Health = 187, Damage = 29," + " Enemy ID = " + e.getENEMY_ID(), e.toString());
    }


}
