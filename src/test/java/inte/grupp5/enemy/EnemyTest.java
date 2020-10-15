package inte.grupp5.enemy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    void healthIsCorrectForDragon() {
        Enemy e = new Enemy(20, "Dragon");
        assertEquals(60,e.getHealth(20,"Dragon"));
    }

    @Test
    void attackDamageIsCorrectforDragon() {
        Enemy e = new Enemy(20, "Dragon");
        assertEquals(10,e.getAttackDamage(20));

    }

    @Test
    void healthIsCorrect() {
        Enemy e = new Enemy(20, "Sorcerer");
       // assertEquals();
    }

    @Test
    void attackDamageIsCorrect() {
        Enemy e = new Enemy(20, "Wolf");
       // assertEquals();
    }

    @Test
    void constructorThrowsIfNegativeValue () {
        assertThrows(IllegalArgumentException.class, () -> {
            new Enemy(-1,"Sorcerer");
        });
    }}

