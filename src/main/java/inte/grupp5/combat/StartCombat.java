package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.item.Armor;
import inte.grupp5.item.Consumable;
import inte.grupp5.item.Gear;
import inte.grupp5.item.Weapon;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import inte.grupp5.player.spell.FlashOfLight;
import inte.grupp5.player.spell.Spell;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StartCombat extends Combat {

    //TODO: Spells, mera tester, enemy vs enemy, kommentarer

    private boolean playerDefeated = false;
    private boolean enemyDefeated = false;
    private int SPELL_COUNTER = 0;

    Enemy enemy;
    Player player;

    public StartCombat(ArrayList<Enemy> enemy, Player player) {
        super(enemy, player);
        this.enemy = super.getEnemy();
        this.player = super.getPlayer();
    }

    public boolean isEnemyDefeated() {
        return enemyDefeated;
    }

    public void startCombat(Enemy enemy, Player player, ArrayList<Enemy> opponents) {
        if (enemy == null) {
            setWeaponForPlayer();
            setArmorForPlayer();
            for (Enemy e : opponents) {
                    checkClass(e);
                    combatLoop(e);
                    if (playerDefeated) {
                        break;
                    }
            }
        }
    }


    public void combatLoop(Enemy e) {
          //  checkSpells(e);
        while (!enemyDefeated) {
            playerTurn(e);
            checkIfEnemyHealthIsZero(e);
            if (enemyDefeated) {
                setEnemyDefeatedFalse();
                break;
            }
            enemyTurn(e);
            checkIfPlayerHealthIsZero(e);
            if (playerDefeated) {
                break;
            }
        }
    }

    public void setEnemyDefeatedFalse() {
        this.enemyDefeated = false;
    }

    public void setEnemyDefeatedTrue() {
        this.enemyDefeated = true;
    }

    public void setPlayerDefeatedTrue() { this.playerDefeated = true; }

    public void playerTurn(Enemy e) {
        e.takeDamage(player.getDamage());
    }

    public void checkIfEnemyHealthIsZero (Enemy e) {
        if (e.getHealth() <= 0) {
            super.setDefeated(getDefeated() +1);
            System.out.println(super.getDefeated() + " opponents defeated");
            setEnemyDefeatedTrue();
        }
    }

    public void checkIfPlayerHealthIsZero(Enemy e) {
        if (player.getCurrentHealthPoints() <= 0) {
            System.out.println("Player defeated!");
            setPlayerDefeatedTrue();
        }
    }


    public void enemyTurn(Enemy e) {
        player.takeDamage(e.getDamage());

    }

    public boolean isPlayerDefeated() {
        return playerDefeated;
    }

    public void checkClass(Enemy enemy) {

            if (player.getKlass() instanceof Paladin || enemy.getEnemyType().equals("Wolf")) {
                enemy.takeDamage(5);
            } else if (player.getKlass() instanceof Mage || enemy.getEnemyType().equals("Enemy")) {
                enemy.takeDamage(25);
            }
        }


    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

  //  public void checkSpells(Enemy enemy) {
   //     if (playerTakenDamage = true || SPELL_COUNTER < 10) {
    //        player.castSpell(new FlashOfLight());
    //        SPELL_COUNTER ++;
    //    }
   // }


    //TODO: Flytta ut till Player och Gear klasserna
    public void setArmorForPlayer() {
        if (player.getKlass() instanceof Paladin) {
            Armor paladinArmor = new Armor("Paladin Armor",10, 30, Armor.ArmorType.HEAVY_ARMOR);
            player.setMaxHealthPoints(player.getCurrentHealthPoints() + paladinArmor.getArmorRating());
            player.setCurrentHealthPoints(player.getMaxHealthPoints());
        }
        if  (player.getKlass() instanceof Mage) {
            Armor mageArmor = new Armor("Mage Armor", 5, 5, Armor.ArmorType.LIGHT_ARMOR);
            player.setMaxHealthPoints(player.getCurrentHealthPoints() + mageArmor.getArmorRating());
            player.setCurrentHealthPoints(player.getMaxHealthPoints());
        }
    }

    public void setWeaponForPlayer() {
        if (player.getKlass() instanceof Paladin) {
            Weapon paladinWeapon = new Weapon("Paladin Weapon",10, 50, Weapon.WeaponType.SWORD);
            player.setDamage(paladinWeapon.getDamage());
        }
        if  (player.getKlass() instanceof Mage) {
            Weapon mageWeapon = new Weapon("Mage Weapon", 1, 50, Weapon.WeaponType.STAFF);
            player.setDamage(mageWeapon.getDamage());
        }
    }

}