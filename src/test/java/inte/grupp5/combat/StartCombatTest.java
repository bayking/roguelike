package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.EnemyList;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class StartCombatTest {

    //Mera tester

    Enemy enemy = new Enemy(50);
    Wolf wolf = new Wolf(50);
    Player player = new Player("Player",new Mage("mage"),32);
    Player paladin = new Player("Player", new Paladin("paladin"),50);
    EnemyList enemyList = new EnemyList();


    @Test
    void playerExistsWhenStartingCombat() {
        enemyList.addEnemy(enemy);
        StartCombat combat = new StartCombat(enemyList.getEnemies(),player);
        assertEquals("Player", combat.getPlayer().getName());
    }

    @Test
    void oneEnemyExistWhenStartingCombat() {
        enemyList.addEnemy(enemy);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), player);
        assertEquals( 1,combat.getOpponents().size());
    }

    @Test
    void playerClassImpactsEnemyHealth() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertEquals(170,combat.getOpponents().get(0).getHealth());
    }
}