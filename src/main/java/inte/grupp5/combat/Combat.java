package inte.grupp5.combat;
import inte.grupp5.enemy.Enemy;
import inte.grupp5.enemy.Wolf;
import inte.grupp5.item.Consumable;
import inte.grupp5.player.Player;

import java.util.ArrayList;

import inte.grupp5.player.Player;
import inte.grupp5.enemy.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Combat {

    private ArrayList<Enemy> opponents = new ArrayList<Enemy>();
    private Player player;
    private Enemy enemy;
    private int defeated;
    Consumable itemsUsed;


    // Om ingen spelare så möter enemy varandra.
    public Combat(ArrayList<Enemy> enemy, Player player) {

        if (enemy.size() >= 2 && player == null) {
            addEnemyListToOpponents(enemy);
            strongestEnemy(opponents);

        }

        else if (enemy.size() == 0 ) {
            throw new IllegalArgumentException("There has to be enemies for a combat");
        }

        else if (player == null) {
            throw new NullPointerException ("There has to be a Player for a combat");
        }

        else addEnemyListToOpponents(enemy);
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public ArrayList<Enemy> getOpponents() {
        return opponents;
    }

    public Player getPlayer() {
        return player;
    }

    public void addEnemyListToOpponents(ArrayList<Enemy> enemy) {
        opponents.addAll(enemy);
    }

    public Enemy strongestEnemy(ArrayList<Enemy> opponents) {
        return   enemy = opponents.stream()
                .max(Comparator.comparingInt(Enemy::getLevel))
                .get();
    }

    public void startCombat (Enemy enemy, Player player,ArrayList<Enemy> opponents ) {
        if (enemy == null) {
            for (Enemy e: opponents) {
                StartCombat startCombat = new StartCombat(e.getEnemy(),player);
                startCombat.initiziateCombat();
            }
        }
    }
}