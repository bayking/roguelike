package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.EnemyList;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrepareCombatTest {

    //Stridssystemet är turordning.
    //TTD och tillståndsmaskin?

    @Test
    void checkIfContainsPlayerFails () {  assertThrows(NullPointerException.class, () -> {
        Enemy e = new Enemy(40);
        EnemyList enemyList = new EnemyList();
        enemyList.addEnemy(e);
        new PrepareCombat(enemyList.getEnemies(),null);
    }); }

    @Test
    void checkIfContainsEnemiesfails () {  assertThrows(NullPointerException.class, () -> {
        Player player = new Player( "Player", new Mage("mage"), 40);
        new PrepareCombat(null,player);
    }); }

    @Test
    void checkIfEnemyContains () {  assertThrows(IllegalArgumentException.class, () -> {
        Player player = new Player("Player",new Mage("mage"),32);
        EnemyList enemyList = new EnemyList();
        new PrepareCombat(enemyList.getEnemies(),player);
    }); }

    @Test
    void ifEnemySizeMoreThan1AndPlayerNullRuns() {
        Wolf wolf = new Wolf(20,0);
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new PrepareCombat(enemyList.getEnemies(),null);
        assertNotNull(prepareCombat.getOpponents());
        assertNotNull(prepareCombat.getEnemy());
    }


}