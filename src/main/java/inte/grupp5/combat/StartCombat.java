package inte.grupp5.combat;

import inte.grupp5.enemy.Enemy;
import inte.grupp5.player.Player;

import java.util.ArrayList;

public class StartCombat  {
    boolean playerStartTurn = true;
    Enemy enemy;
    Player player;

    public StartCombat(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    public void initiziateCombat () { }
}