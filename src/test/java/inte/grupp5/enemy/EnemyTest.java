package inte.grupp5.enemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnemyTest {

    @Test
    void constructorThrowsIfNegativeValue () {
        assertThrows(IllegalArgumentException.class, () -> new Enemy(-1));
    }


    @Test
    void healthThrowsIfNegativeValue () {
        Enemy e = new Enemy(1);
        assertThrows(IllegalArgumentException.class, () -> e.getAttackDamage(-1));
    }

    @Test
    void damageThrowsIfNegativeValue () {
        Enemy e = new Enemy(1);
        assertThrows(IllegalArgumentException.class, () -> new Enemy(-1));
    }

    @Test
    void healthIsCorrect() {
        Enemy e = new Enemy(20);
        assertEquals(60,e.getHealth(20));
    }

    @Test
    void attackDamageIsCorrect() {
        Enemy e = new Enemy(21);
        assertEquals(10,e.getAttackDamage(20));
    }

    @Test
    void LevelIsCorrect() {
        Enemy e = new Enemy(20);
        assertEquals(20,e.getLevel());
    }

    @Test
    void toStringIsCorrect() {
        Enemy e = new Enemy(58);
        assertEquals(" Level = 58 Health = 117 Attack damage = 29",e.toString());
    }


}
