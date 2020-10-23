package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.item.Armor;
import inte.grupp5.item.Consumable;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Paladin;

import java.util.ArrayList;

public class StartCombat extends Combat  {
    boolean playerStartTurn = true;
    Enemy enemy;
    Player player;
    private ArrayList<Enemy> opponents;

    public StartCombat(ArrayList<Enemy> enemy, Player player) {
        super(enemy, player);
        this.enemy = super.getEnemy();
        this.player = super.getPlayer();
        this.opponents = super.getOpponents();
    }

    public void startCombat (Enemy enemy, Player player,ArrayList<Enemy> opponents ) {
        if (enemy == null) {
            for (Enemy e: opponents) {
                checkClass(e);
            }
        }
    }

    @Override
    public ArrayList<Enemy> getOpponents() {
        return opponents;
    }

    public boolean isPlayerStartTurn() {
        return playerStartTurn;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }


public void checkClass (Enemy enemy) {
    if (player.getKlass() instanceof Paladin || enemy.getEnemyType().equals("Wolf")) {
        enemy.takeDamage(5);
    }
}
}