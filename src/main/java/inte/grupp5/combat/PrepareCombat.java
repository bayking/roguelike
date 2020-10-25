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

public class PrepareCombat {

    private Player player;
    private Enemy enemy;
    private int defeated;
    private ArrayList<Enemy> opponents = new ArrayList<Enemy>();

    // Om ingen spelare så möter enemy varandra.
    public PrepareCombat(ArrayList<Enemy> enemies, Player player) {

        if (enemies.size() >= 2 && player == null) {
            addEnemyListToOpponents(enemies);
            enemy = getStrongestEnemy();
        }
        else if (enemies.size() == 0 ) {
            throw new IllegalArgumentException("There has to be enemies for a combat");
        }
        else if (player == null) {
            throw new NullPointerException ("There has to be a Player for a combat");
        }
        else addEnemyListToOpponents(enemies);
        this.player = player;
    }

    public int getDefeated() {
        return defeated;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDefeated(int defeated) {
        this.defeated = defeated;
    }

    public void addEnemyListToOpponents(ArrayList<Enemy> enemy) {
        opponents.addAll(enemy);
    }

    public ArrayList<Enemy> getOpponents() {
        return opponents;
    }

    public Enemy getStrongestEnemy () {
        return opponents.stream()
                .max(Comparator.comparingInt(Enemy::getLevel))
                .get();
    }




}