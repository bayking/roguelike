package inte.grupp5.enemy;

import java.util.ArrayList;

public class EnemyList {

    private ArrayList<Enemy> enemies;
    public EnemyList(){
        enemies = new ArrayList <>();
    }

    public void addEnemy(Enemy enemy) {

        this.enemies.add(enemy);
    }

    public void addList(ArrayList<Enemy> e) {
        enemies.addAll(e);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public String toString() {
        return " Enemies = " + enemies;
    }
}