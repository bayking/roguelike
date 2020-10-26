package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.item.Armor;
import inte.grupp5.item.Weapon;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import inte.grupp5.player.spell.FlashOfLight;
import java.util.ArrayList;

public class Combat extends PrepareCombat {

    private boolean enemyDefeated = false;
    private boolean playerDefeated,enemydefeated = false;
    private boolean opponentDefeated = false;
    private boolean playerTakenDamage = false;
    private int SPELL_COUNTER = 0;

    public Combat(ArrayList<Enemy> enemy, Player player) {
        super(enemy, player);
    }

    /*
     Startar combat mellan spelare och enemies.
     Om ingen spelare finns startas combat mellan starkaste enemy i listan mot av enemies som finns i listan.
     */
    public void startCombat(Enemy enemy, Player player, ArrayList<Enemy> opponents) {
        if (enemy == null) {
            playerVersusEnemies(opponents);
        }
        if (player == null && enemy != null && opponents.size() >= 1) {
            enemyVersusEnemy(opponents);
        }
    }
    // Spelare mot enemies som finns i listan "opponents".
    private void playerVersusEnemies(ArrayList<Enemy> opponents) {
        setWeaponAndArmorForPlayer();
        for (Enemy e : opponents) {
            checkClass(e);
            combatLoop(e);
            if (playerDefeated) {
                break;
            }
        }
    }
//Starkaste enemy mot resten av enemies.
    private void enemyVersusEnemy(ArrayList<Enemy> opponents) {
        for (Enemy e : opponents) {
            enemyVsEnemyLoop(e);
            if (enemyDefeated) {
                break;
            }
        }
    }
//Loop spelare mot enemies.
    public void combatLoop(Enemy e) {
        while (!opponentDefeated) {
            playerTurn(e);
            checkIfOpponentHealthIsZero(e);
            if (opponentDefeated) {
                setOpponentDefeatedFalse();
                break;
            }
            opponentTurn(e);
            checkIfPlayerHealthIsZero();
            if (playerDefeated) {
                System.out.println("Player defeated");
                setPlayerTakenDamageFalse();
                break;
            }
        }
    }
// Loop starkaste enemy mot enemies.
    public void enemyVsEnemyLoop(Enemy e) {
        while (!opponentDefeated) {
            enemyTurn(e);
            checkIfOpponentHealthIsZero(e);
            if (opponentDefeated) {
                setOpponentDefeatedFalse();
                break;
            }
            opponentTurn(e);
            checkIfEnemyHealthIsZero();
            if (enemyDefeated) {
                System.out.println("Enemy defeated");
                break;
            }
        }
    }

    public void playerTurn(Enemy e) {
        if (playerTakenDamage = true) {
            playerCastSpell(super.getPlayer());
        }
        e.takeDamage(super.getPlayer().getDamage());
        System.out.println("Player attacked opponent");
    }

    public void enemyTurn(Enemy e) {
        e.takeDamage(super.getEnemy().getCurrentDamage());
        System.out.println("Enemy attacked Opponent");
    }

    public void setPlayerTakenDamage() {
        this.playerTakenDamage = true;
    }

    public void checkIfOpponentHealthIsZero(Enemy e) {
        if (e.getCurrentHealth() <= 0) {
            super.setDefeated(getDefeated() + 1);
            System.out.println(super.getDefeated() + " opponents defeated");
            setOpponentDefeatedTrue();
        }
    }

    public void checkIfPlayerHealthIsZero() {
        if (super.getPlayer().getCurrentHealthPoints() <= 0) {
            setPlayerDefeatedTrue();
        }
    }

    public void checkIfEnemyHealthIsZero() {
        if (super.getEnemy().getCurrentHealth() <= 0) {
            setEnemyDefeatedTrue();
        }
    }

    public void opponentTurn(Enemy e) {
        if (super.getPlayer() == null) {
            System.out.println("Opponent attacked enemy");
            super.getEnemy().takeDamage(e.getCurrentDamage());
        }
         else if (super.getPlayer() != null) {
            super.getPlayer().takeDamage(e.getCurrentDamage());
            System.out.println("Opponent attacked player");
            setPlayerTakenDamage();
        }
    }

    public boolean isPlayerDefeated() {
        return playerDefeated;
    }

    public void checkClass(Enemy enemy) {

        if (super.getPlayer().getKlass() instanceof Paladin || enemy.getEnemyType().equals("Wolf")) {
            enemy.takeDamage(5);
            System.out.println("Player class impacted enemy health.");
        } else if (super.getPlayer().getKlass() instanceof Mage || enemy.getEnemyType().equals("Enemy")) {
            enemy.takeDamage(25);
            System.out.println("Player class impacted enemy health.");
        }
    }

    private void setWeaponAndArmorForPlayer() {
        setWeaponForPlayer();
        setArmorForPlayer();
    }

    public void setOpponentDefeatedFalse() {
        this.opponentDefeated = false;
    }

    public void setOpponentDefeatedTrue() {
        this.opponentDefeated = true;
    }

    public void setPlayerDefeatedTrue() {
        this.playerDefeated = true;
    }

    public void setEnemyDefeatedTrue() {
        this.enemyDefeated = true;
    }

    public void setPlayerTakenDamageFalse() { playerTakenDamage = false; }

    public int getSPELL_COUNTER() { return SPELL_COUNTER; }

    //TODO: Flytta ut till Player och Gear klasserna? eller till combattest:

    public void playerCastSpell(Player player) {
        if (player.getKlass() instanceof Paladin && playerTakenDamage && SPELL_COUNTER <= 10) {
            player.castSpell(new FlashOfLight());
            SPELL_COUNTER++;
            System.out.println("Player has casted a spell.");
            setPlayerTakenDamageFalse();
        }
    }

    public void setArmorForPlayer() {
        if (super.getPlayer().getKlass() instanceof Paladin) {
            Armor paladinArmor = new Armor("Paladin Armor", 10, 30, Armor.ArmorType.HEAVY_ARMOR);
            super.getPlayer().setMaxHealthPoints(super.getPlayer().getCurrentHealthPoints() + paladinArmor.getArmorRating());
            super.getPlayer().setCurrentHealthPoints(super.getPlayer().getMaxHealthPoints());
        }
        if (super.getPlayer().getKlass() instanceof Mage) {
            Armor mageArmor = new Armor("Mage Armor", 5, 5, Armor.ArmorType.LIGHT_ARMOR);
            super.getPlayer().setMaxHealthPoints(super.getPlayer().getCurrentHealthPoints() + mageArmor.getArmorRating());
            super.getPlayer().setCurrentHealthPoints(super.getPlayer().getMaxHealthPoints());
        }
    }

    public void setWeaponForPlayer() {
        if (super.getPlayer().getKlass() instanceof Paladin) {
            Weapon paladinWeapon = new Weapon("Paladin Weapon", 10, 50, Weapon.WeaponType.SWORD);
            super.getPlayer().setDamage(paladinWeapon.getDamage());
        }
        if (super.getPlayer().getKlass() instanceof Mage) {
            Weapon mageWeapon = new Weapon("Mage Weapon", 1, 50, Weapon.WeaponType.STAFF);
            super.getPlayer().setDamage(mageWeapon.getDamage());
        }
    }
}