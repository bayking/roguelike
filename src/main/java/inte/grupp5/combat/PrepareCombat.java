package inte.grupp5.combat;
import inte.grupp5.enemy.Enemy;
import inte.grupp5.item.Armor;
import inte.grupp5.item.Weapon;
import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class PrepareCombat {

    private final Player player;
    private Enemy enemy;
    private int defeated;
    private final ArrayList<Enemy> opponents = new ArrayList<>();


    public PrepareCombat(ArrayList<Enemy> enemies, Player player) {
        // Om ingen spelare så möter enemy varandra.
        if (enemies.size() >= 2 && player == null) {
            addEnemyListToOpponents(enemies);
            enemy = getStrongestEnemy();
            opponents.remove(enemy);
        }
        else if (enemies.size() == 0 ) {
            throw new IllegalArgumentException("There has to be enemies for a combat");
        }
        else if (player == null) {
            throw new NullPointerException ("There has to be a Player for a combat");
        }
        //Spelare och enemy finns
        else addEnemyListToOpponents(enemies);
        this.player = player;
    }

    public void setArmorForPlayer() {
        Armor armor = (Armor) player.getItem(player.getItems().size() - 1);
        if (player.getKlass() instanceof Paladin) {
            player.setMaxHealthPoints(player.getCurrentHealthPoints() + armor.getArmorRating() >> 2);
            player.setCurrentHealthPoints(player.getMaxHealthPoints());
        }
        if (player.getKlass() instanceof Mage) {
            player.setMaxHealthPoints(player.getCurrentHealthPoints() + armor.getArmorRating());
            player.setCurrentHealthPoints(player.getMaxHealthPoints());
        }
    }

    public int setWeaponForPlayer() {
        Weapon weapon = (Weapon) player.getItem(player.getItems().size() - 2);
        System.out.println(weapon);
        if (player.getKlass() instanceof Paladin) {
            return weapon.getDamage() * 2;
        } else if (player.getKlass() instanceof Mage) {
            return weapon.getDamage();
        }
        else return getPlayer().getLevel();
    }

    public void checkClass(Enemy enemy) {
        if (player.getKlass() instanceof Paladin || enemy.getEnemyType().equals("Wolf")) {
            enemy.takeDamage(5);
            System.out.println("Player class impacted enemy health.");
        } else if (player.getKlass() instanceof Mage || enemy.getEnemyType().equals("Enemy")) {
            enemy.takeDamage(25);
            System.out.println("Player class impacted enemy health.");
        }
    }

    public Enemy getStrongestEnemy () {
        return opponents.stream()
                .max(Comparator.comparingInt(Enemy::getLevel))
                .get();
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
}