package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.EnemyList;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrepareCombatTest {

    //Stridssystemet är turordning.
    //TTD och tillståndsmaskin?

    Player paladinPlayer = new Player("Player",new Paladin("Paladin"),10);
    Player magePlayer = new Player("Player",new Mage("Mage"),10);
    Wolf wolf = new Wolf(50,40);

    @Test
    void checkIfContainsPlayerFails () {  assertThrows(NullPointerException.class, () -> {
        Enemy e = new Enemy(40);
        EnemyList enemyList = new EnemyList();
        enemyList.addEnemy(e);
        new Combat(enemyList.getEnemies(),null);
    }); }

    @Test
    void checkIfContainsEnemiesfails () {  assertThrows(NullPointerException.class, () -> {
        Player player = new Player( "Player", new Mage("mage"), 40);
        new Combat(null,player);
    }); }


    @Test
    void checkIfEnemyContains () {  assertThrows(IllegalArgumentException.class, () -> {
        Player player = new Player("Player",new Mage("mage"),32);
        EnemyList enemyList = new EnemyList();
        new Combat(enemyList.getEnemies(),player);
    }); }

    @Test
    void ifEnemySizeMoreThan1AndPlayerNullRuns() {
        Wolf wolf = new Wolf(20,0);
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new Combat(enemyList.getEnemies(),null);
        assertNotNull(prepareCombat.getOpponents());
        assertNotNull(prepareCombat.getEnemy());
    }

    @Test
    void playerAndEnemiesExistSetsCorrect () {
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new Combat(enemyList.getEnemies(),paladinPlayer);
        assertNotNull(prepareCombat.getOpponents());
        assertNotNull(prepareCombat.getPlayer());
        assertNull(prepareCombat.getEnemy());
    }

    @Test
    void armorForPaladin () {
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new Combat(enemyList.getEnemies(),paladinPlayer);
        int healthBeforeArmor = paladinPlayer.getCurrentHealthPoints();
        prepareCombat.armorForPlayer();
        assertNotEquals(paladinPlayer.getCurrentHealthPoints(), healthBeforeArmor);
    }

    @Test
    void weaponForPaladin () {
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new Combat(enemyList.getEnemies(),paladinPlayer);
        assertEquals(5 * 2,prepareCombat.useWeaponForPlayer());
    }


    @Test
    void armorForMage () {
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new Combat(enemyList.getEnemies(), magePlayer);
        int healthBeforeArmor = magePlayer.getCurrentHealthPoints();
        prepareCombat.armorForPlayer();
        assertNotEquals(magePlayer.getCurrentHealthPoints(), healthBeforeArmor);
    }


    @Test
    void weaponForMage    () {
        EnemyList enemyList = new EnemyList();
        enemyList.addWolves(wolf.getGroupOfWolves());
        PrepareCombat prepareCombat = new Combat(enemyList.getEnemies(), magePlayer);
        assertEquals(5 ,prepareCombat.useWeaponForPlayer());
    }



}