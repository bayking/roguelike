package inte.grupp5.enemy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class EnemyListTest {

    EnemyList e = new EnemyList();

    @Test
    void oneEnemy() {
        Enemy enemy = new Enemy(50);
        e.addEnemy(enemy);
        assertEquals(1,e.getEnemies().size());
    }

    @Test
    void moreThanOneEnemy() {
        Enemy enemy = new Enemy(50);
        Enemy enemy1 = new Enemy(700);
        e.addEnemy(enemy);
        e.addEnemy(enemy1);
        assertEquals(2,e.getEnemies().size());
    }


    @Test
    void oneWolf() {
        Wolf wolf = new Wolf(50,0);
        e.addEnemy(wolf);
        assertEquals(1,e.getEnemies().size());
    }

    @Test
    void manyWolves() {
        Wolf wolf = new Wolf(51,0);
        Wolf wolf1 = new Wolf(10,2);
        e.addEnemy(wolf);
        e.addList(wolf1.getGroupOfWolves());
        assertEquals(4,e.getEnemies().size());
    }

    @Test
    void randomWolves() {
        Wolf wolf = new Wolf(1,0);
        e.addList(wolf.getGroupOfWolves());
        assertTrue(e.getEnemies().size() >= 2);
    }

    @Test
    void dragonWolvesAndEnemies() {
        Dragon d = new Dragon(23);
        Enemy enemy = new Enemy(44);
        Wolf wolf = new Wolf(40,2);
        e.addEnemy(d);
        e.addEnemy(enemy);
        e.addList(wolf.getGroupOfWolves());
        assertEquals(5,e.getEnemies().size());
    }
    @Disabled
    @Test void listCantBeNull () {
    }

    @Disabled
    @Test void addEnemyCantBeNull() {

    }




















}