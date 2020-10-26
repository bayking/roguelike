package inte.grupp5.combat;

import inte.grupp5.enemy.Dragon;
import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.EnemyList;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CombatTest {


    Enemy e = new Enemy(50);
    Wolf wolf = new Wolf(50);
    Player mage = new Player("Player",new Mage("mage"),32);
    Player paladin = new Player("Player", new Paladin("paladin"),10);
    EnemyList enemyList = new EnemyList();


    @Test
    void playerExistsWhenStartingCombat() {
        enemyList.addEnemy(e);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        assertEquals("Player", combat.getPlayer().getName());
    }

    @Test
    void oneEnemyExistWhenStartingCombat() {
        enemyList.addEnemy(e);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        assertEquals( 1,combat.getOpponents().size());
    }

    @Test
    void paladinClassImpactsEnemyHealth() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.checkClass(combat.getOpponents().get(0));
        assertEquals(170,combat.getOpponents().get(0).getCurrentHealth());
    }

    @Test
    void mageClassImpactsEnemyHealth() {
        enemyList.addEnemy(e);
        Combat combat = new Combat(enemyList.getEnemies(),mage );
        combat.checkClass(combat.getOpponents().get(0));
        assertEquals(150 ,combat.getOpponents().get(0).getCurrentHealth());
    }

    @Test
    void playerSpellsImpactsPlayerHealth() {
        wolf.setDamage(1000);
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.opponentTurn(wolf);
        combat.playerCastSpell(combat.getPlayer());
        assertEquals(150,combat.getPlayer().getCurrentHealthPoints());
    }


    @Test
    void enemyIsNullWhenPlayerAndEnemiesExist () {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertNull(combat.getEnemy());
    }

    @Test
    void combatLoopRuns () {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertEquals(0,combat.getOpponents().get(0).getCurrentHealth() );
    }


    @Test
    void paladinHasDamageWhenStartingCombat() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertEquals(50,combat.getPlayer().getDamage());
    }

    @Test
    void mageHasDamageWhenInitiziatingCombat() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertEquals(50,combat.getPlayer().getDamage());
    }


    @Test
    void playerDoesDamage() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.setWeaponForPlayer();
        combat.playerTurn(combat.getOpponents().get(0));
        assertEquals(125,combat.getOpponents().get(0).getCurrentHealth());
    }

    @Test
    void playerDefeatsOneEnemy() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertNull(combat.getEnemy());
        assertEquals(0,combat.getOpponents().get(0).getCurrentHealth());
        assertEquals(1,combat.getDefeated());
    }

    @Test
    void playerDefeatsManyOpponents() {
        Wolf wolf = new Wolf(10,5);
        enemyList.addEnemy(this.wolf);
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertNull(combat.getEnemy());
        assertEquals(0,combat.getOpponents().get(6).getCurrentHealth());
        assertEquals(7,combat.getDefeated());
    }

    @Test
    void playerDiesDuringCombat() {
        Wolf wolf = new Wolf(50,40);
        enemyList.addEnemy(this.wolf);
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat(combat.getEnemy(), combat.getPlayer(), combat.getOpponents());
        assertTrue(combat.isPlayerDefeated());
    }

    @Test
    void enemyDefeatsOneOpponent () {
        Wolf wolf = new Wolf(10,1);
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), null);
        combat.startCombat(combat.getEnemy(),combat.getPlayer(),combat.getOpponents());
        assertNull(combat.getPlayer());
        assertEquals(1,combat.getDefeated());
    }

    @Test
    void enemyDefeatsManyOpponents() {
        Dragon d = new Dragon(500);
        Enemy enemy = new Enemy(10);
        Wolf w = new Wolf(10,0);

        enemyList.addWolves(w.getGroupOfWolves());
        enemyList.addEnemy(d);
        enemyList.addEnemy(enemy);

        Combat combat = new Combat(enemyList.getEnemies(), null);
        combat.startCombat(combat.getEnemy(),combat.getPlayer(),combat.getOpponents());

        assertTrue(combat.getDefeated() >= 3);
    }

    @Test
    void enemyDiesFromCombat() {
        Dragon d = new Dragon(500);
        Enemy enemy = new Enemy(10);
        Wolf w = new Wolf(100,50);

        enemyList.addWolves(w.getGroupOfWolves());
        enemyList.addEnemy(d);
        enemyList.addEnemy(enemy);

        Combat combat = new Combat(enemyList.getEnemies(), null);
        combat.startCombat(combat.getEnemy(),combat.getPlayer(),combat.getOpponents());

        assertEquals(0,combat.getEnemy().getCurrentHealth());
    }

    @Test
    void enemyTakesDamage() {
        Wolf wolf = new Wolf(10,1);
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), null);
        int startingHealth = combat.getEnemy().getCurrentHealth();
        combat.startCombat(combat.getEnemy(),combat.getPlayer(),combat.getOpponents());
        assertNotEquals(startingHealth, combat.getEnemy().getCurrentHealth());
    }


    }




