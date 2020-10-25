package inte.grupp5.enemy;

import java.util.ArrayList;
import java.util.Comparator;

public class EnemyList {

    private ArrayList<Enemy> enemies;
    public EnemyList(){
        enemies = new ArrayList <>();
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
        sortEnemyList();
    }

    public void addWolves(ArrayList<Enemy> e) {
        enemies.addAll(e);
        sortEnemyList();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void sortEnemyList () {
        enemies.sort(Comparator.comparing(Enemy::getLevel));
    }

    @Override
    public String toString() {
        return " Enemies = " + enemies;
    }
}