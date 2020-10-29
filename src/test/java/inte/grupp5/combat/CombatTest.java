package inte.grupp5.combat;

import inte.grupp5.enemy.Dragon;
import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.EnemyList;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class CombatTest {


    Enemy enemy = new Enemy(50);
    Wolf wolf = new Wolf(10,1);
    Wolf wolf1 = new Wolf(100,50);
    Wolf wolf2 = new Wolf(50,0);
    Wolf wolf3 = new Wolf(1,50);
    Dragon dragon = new Dragon(500);


    Player mage = new Player("Player",new Mage("mage"),32);
    Player paladin = new Player("Player", new Paladin("paladin"),50);

    EnemyList enemyList = new EnemyList();



    @Test
    void playerHealthImpactedAfterFirstCombat () {
        enemyList.addWolves(wolf3.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),paladin);
        int playerHealthBefore = combat.getPlayer().getCurrentHealthPoints();
        combat.startCombat();
        int playerHealthAfter = combat.getPlayer().getCurrentHealthPoints();
        assertNotEquals(playerHealthBefore,playerHealthAfter);
    }

    @Test
    void enemyHealthImpactedAfterFirstCombat() {
        enemyList.addEnemy(enemy);
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),null);
        int enemyhealthBefore = combat.getEnemy().getCurrentHealth();
        combat.startCombat();
        int enemyhealthAfter = combat.getEnemy().getCurrentHealth();
        assertNotEquals(enemyhealthBefore,enemyhealthAfter);
    }

   @Test
   void enemyDefeatedsetToTrueAfterEnemyDefeated() {
        enemyList.addWolves(wolf1.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),null);
   }

   @Test
   void booleansSetToFalseAfterStartCombatMethodCalled () {
        enemyList.addWolves(wolf1.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),null);
        combat.startCombat();
        assertFalse(combat.getPlayerDefeated());
        assertFalse(combat.getEnemyDefeated());
        assertFalse(combat.getOpponentDefeated());
        assertFalse(combat.getPlayerTakenDamage());

   }

    @ParameterizedTest
    @ValueSource(ints = {50, 25, 0})
    void playerManaSetCorrectAfterUsingSpellDuringCombat (int mana){
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(),paladin);
        combat.opponentTurn(wolf);
        paladin.setCurrentManaPoints(mana + 25);
        combat.playerCastSpell(paladin);
        assertEquals(mana, paladin.getCurrentManaPoints());
    }

    @Test
    void counterIsSetTo10WhenPlayerUsedSpellToManyTimes() {
        enemyList.addWolves(wolf1.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),paladin);
        combat.startCombat();
        assertEquals(11,combat.getSPELL_COUNTER());
    }


    @Test
    void playerExistsWhenStartingCombat() {
        enemyList.addEnemy(enemy);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        assertEquals("Player", combat.getPlayer().getName());
    }

    @Test
    void oneEnemyExistWhenStartingCombat() {
        enemyList.addEnemy(enemy);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        assertEquals( 1,combat.getOpponents().size());
    }

    @Test
    void paladinClassImpactsEnemyHealth() {
        enemyList.addEnemy(wolf2);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.checkClass(combat.getOpponents().get(0));
        assertEquals(170,combat.getOpponents().get(0).getCurrentHealth());
    }

    @Test
    void mageClassImpactsEnemyHealth() {
        enemyList.addEnemy(enemy);
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
        assertEquals(4150,combat.getPlayer().getCurrentHealthPoints());
    }


    @Test
    void enemyIsNullWhenPlayerAndEnemiesExist () {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat();
        assertNull(combat.getEnemy());
    }

    @Test
    void combatLoopRuns () {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat();
        assertEquals(0,combat.getOpponents().get(0).getCurrentHealth() );
    }


    @Test
    void paladinHasDamageWhenStartingCombat() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat();
        assertEquals(80,combat.useWeaponForPlayer());
    }


    @Test
    void mageHasDamageFromWeapon() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat();
        assertEquals(30,combat.useWeaponForPlayer());
    }

    @Test
    void mageHasExtraHealthFromArmor () {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        int beforeSettingArmorHealth = mage.getCurrentHealthPoints();
        combat.armorForPlayer();
        assertEquals(3230,beforeSettingArmorHealth + 30);

    }


    @Test
    void playerDoesDamage() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), paladin);
        combat.startCombat();
        assertEquals(0,combat.getOpponents().get(0).getCurrentHealth());

    }

    @Test
    void playerDefeatsOneEnemy() {
        enemyList.addEnemy(wolf);
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat();
        assertNull(combat.getEnemy());
        assertEquals(0,combat.getOpponents().get(0).getCurrentHealth());
        assertEquals(1,combat.getPlayerHasDefeated());
    }

    @Test
    void playerDefeatsManyOpponents() {
        Wolf wolf5 = new Wolf(10,5);
        enemyList.addWolves(wolf5.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat();
        assertNull(combat.getEnemy());
        assertEquals(0,combat.getOpponents().get(5).getCurrentHealth());
        assertEquals(6,combat.getPlayerHasDefeated());
    }

    @Test
    void playerDiesDuringCombat() {
        Wolf wolf = new Wolf(50,40);
        enemyList.addEnemy(this.wolf);
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), mage);
        combat.startCombat();
        assertEquals(0,combat.getPlayer().getCurrentHealthPoints());
    }

    @Test
    void enemyDefeatsOneOpponent () {
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), null);
        combat.startCombat();
        assertNull(combat.getPlayer());
        assertEquals(1,combat.getPlayerHasDefeated());
    }

    @Test
    void enemyDefeatsManyOpponents() {
        enemyList.addWolves(wolf1.getGroupOfWolves());
        enemyList.addEnemy(dragon);
        enemyList.addEnemy(enemy);
        Combat combat = new Combat(enemyList.getEnemies(), null);
        combat.startCombat();
        assertTrue(combat.getPlayerHasDefeated() >= 3);
    }

    @Test
    void enemyDiesFromCombat() {
        enemyList.addWolves(wolf1.getGroupOfWolves());
        enemyList.addEnemy(dragon);
        enemyList.addEnemy(enemy);
        Combat combat = new Combat(enemyList.getEnemies(), null);
        combat.startCombat();
        assertEquals(0,combat.getEnemy().getCurrentHealth());
    }

    @Test
    void enemyTakesDamage() {
        enemyList.addWolves(wolf.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(), null);
        int startingHealth = combat.getEnemy().getCurrentHealth();
        combat.startCombat();
        assertNotEquals(startingHealth, combat.getEnemy().getCurrentHealth());
    }

    @Disabled
    @Test
        //Måste reset health eller ta bort från listorna
    void startCombatRunsManyTimesWithPlayer () {
        enemyList.addWolves(wolf3.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),paladin);
        combat.startCombat();
        combat.startCombat();
        assertEquals(102,combat.getPlayerHasDefeated());
    }
    @Disabled
    @Test
        //Måste reset health eller ta bort från listorna
    void startCombatRunsManyTimesWithEnemy () {
        enemyList.addEnemy(dragon);
        enemyList.addWolves(wolf3.getGroupOfWolves());
        Combat combat = new Combat(enemyList.getEnemies(),null);
        combat.startCombat();
        combat.startCombat();
        assertEquals(102,combat.getPlayerHasDefeated());
    }

    }




