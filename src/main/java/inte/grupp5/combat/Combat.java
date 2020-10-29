package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Paladin;
import inte.grupp5.player.spell.FlashOfLight;

import java.util.ArrayList;

public class Combat extends PrepareCombat {


    private boolean playerDefeated, enemyDefeated, opponentDefeated, playerTakenDamage;
    private int SPELL_COUNTER = 0;

    public Combat(ArrayList<Enemy> enemy, Player player) {
        super(enemy, player);
    }

    public void startCombat() {
        if (super.getEnemy() == null) {
            playerVersusEnemies(super.getOpponents());
        }
        if (super.getPlayer() == null && super.getEnemy() != null && super.getOpponents().size() >= 1) {
            enemyVersusEnemy(super.getOpponents());
        }
        setBooleansToFalse();
    }

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

    private void enemyVersusEnemy(ArrayList<Enemy> opponents) {
        for (Enemy e : opponents) {
            enemyVsEnemyLoop(e);
            if (enemyDefeated) {
                break;
            }
        }
    }

    private void combatLoop(Enemy e) {
        while (!opponentDefeated) {
            playerTurn(e);
            checkIfOpponentHealthIsZero(e);
            if (opponentDefeated) {
                opponentDefeated = false;
                break;
            }
            opponentTurn(e);
            checkIfPlayerHealthIsZero();
            if (playerDefeated) {
                System.out.println("Player defeated");
                playerTakenDamage = false;
                break;
            }
        }
    }

    private void enemyVsEnemyLoop(Enemy e) {
        while (!opponentDefeated) {
            enemyTurn(e);
            checkIfOpponentHealthIsZero(e);
            if (opponentDefeated) {
                opponentDefeated = false;
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

    private void playerTurn(Enemy e) {
        if (playerTakenDamage = true) {
            playerCastSpell(super.getPlayer());
        }
        e.takeDamage(useWeaponForPlayer());
        System.out.println("Player attacked opponent");
    }

    private void enemyTurn(Enemy e) {
        e.takeDamage(super.getEnemy().getCurrentDamage());
        System.out.println("Enemy attacked Opponent");
    }

    public void opponentTurn(Enemy e) {
        if (super.getPlayer() == null) {
            System.out.println("Opponent attacked enemy");
            super.getEnemy().takeDamage(e.getCurrentDamage());
            System.out.println(super.getEnemy().getCurrentHealth());
        } else if (super.getPlayer() != null) {
            super.getPlayer().takeDamage(e.getCurrentDamage());
            System.out.println("Opponent attacked player");
            playerTakenDamage = true;
        }
    }


    private void checkIfOpponentHealthIsZero(Enemy e) {
        if (e.getCurrentHealth() <= 0) {
            super.setPlayerHasDefeated(getPlayerHasDefeated() + 1);
            System.out.println(super.getPlayerHasDefeated() + " opponents defeated");
            opponentDefeated = true;
        }
    }

    private void checkIfPlayerHealthIsZero() {
        if (super.getPlayer().getCurrentHealthPoints() <= 0) {
            playerDefeated = true;
        }
    }

    public void checkIfEnemyHealthIsZero() {
        if (super.getEnemy().getCurrentHealth() <= 0) {
            enemyDefeated = true;
        }
    }

    private void setWeaponAndArmorForPlayer() {
        useWeaponForPlayer();
        armorForPlayer();
    }

    public void playerCastSpell(Player player) {
        if (player.getKlass() instanceof Paladin && playerTakenDamage && SPELL_COUNTER <= 10) {
            player.castSpell(new FlashOfLight());
            SPELL_COUNTER++;
            System.out.println("Player has casted a spell.");
            playerTakenDamage = false;
        }
    }
    private void setBooleansToFalse () {
        playerTakenDamage = false;
        playerDefeated = false;
        enemyDefeated = false;
        opponentDefeated = false;
    }

    public boolean getPlayerDefeated() { return playerDefeated;
    }

    public boolean getEnemyDefeated() {
        return enemyDefeated;
    }

    public boolean getOpponentDefeated() {
        return opponentDefeated;
    }

    public boolean getPlayerTakenDamage() {
        return playerTakenDamage;
    }

    public int getSPELL_COUNTER() { return SPELL_COUNTER;
    }

}