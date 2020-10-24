package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.EnemyList;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StartCombatTest {

    //Mera tester

    Enemy enemy = new Enemy(50);
    Wolf wolf = new Wolf(50);
    Player mage = new Player("Player",new Mage("mage"),32);
    Player paladin = new Player("Player", new Paladin("paladin"),10);
    EnemyList enemyList = new EnemyList();


    @Test
    void playerExistsWhenStartingCombat() {
        enemyList.addEnemy(enemy);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), mage);
        assertEquals("Player", combat.getPlayer().getName());
    }

    @Test
    void oneEnemyExistWhenStartingCombat() {
        enemyList.addEnemy(enemy);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), mage);
        assertEquals( 1,combat.getOpponents().size());
    }

    @Test
    void paladinClassImpactsEnemyHealth() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.checkClass(combat.getOpponents().get(0));
        assertEquals(170,combat.getOpponents().get(0).getHealth());
    }

    @Test
    void mageClassImpactsEnemyHealth() {
        enemyList.addEnemy(enemy);
        StartCombat combat = new StartCombat(enemyList.getEnemies(),mage );
        combat.checkClass(combat.getOpponents().get(0));
        assertEquals(150 ,combat.getOpponents().get(0).getHealth());
    }

    @Disabled
    @Test
    void playerSpellsImpactsEnemyHealth() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertEquals(170,combat.getOpponents().get(0).getHealth());

    }

    @Test
    void enemyIsNullWhenPlayerAndEnemiesExist () {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertNull(combat.getEnemy());
    }

    @Test
    void combatLoopRuns () {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertEquals(0,combat.getOpponents().get(0).getHealth() );
    }

    @Test
    void paladingHasDamageWhenInitiziatingCombat() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertEquals(50,combat.getPlayer().getDamage());
    }

    @Test
    void mageHasDamageWhenInitiziatingCombat() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertEquals(50,combat.getPlayer().getDamage());
    }


    @Test
    void playerDoesDamage() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), paladin);
        combat.setWeaponForPlayer();
        combat.playerTurn(combat.getOpponents().get(0));
        assertEquals(125,combat.getOpponents().get(0).getHealth());
    }

    @Test
    void playerDefeatsOneEnemy() {
        enemyList.addEnemy(wolf);
        StartCombat combat = new StartCombat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertNull(combat.enemy);
        assertEquals(0,combat.getOpponents().get(0).getHealth());
        assertEquals(1,combat.getDefeated());
    }

    @Test
    void playerDefeatsManyOpponents() {
        Wolf wolf = new Wolf(10,5);
        enemyList.addEnemy(wolf);
        enemyList.addList(wolf.getGroupOfWolves());
        StartCombat combat = new StartCombat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.enemy, combat.player, combat.getOpponents());
        assertNull(combat.enemy);
        assertEquals(0,combat.getOpponents().get(6).getHealth());
        assertEquals(7,combat.getDefeated());
    }

    }




