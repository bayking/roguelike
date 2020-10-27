package inte.grupp5.enemy;

import java.util.ArrayList;
import java.util.Collections;


public class Wolf extends Enemy {

    private final ArrayList<Enemy> groupOfWolves = new ArrayList<>(); //Final?


    public Wolf(int level, int amount) {
        super(level);
        if (amount < 0 || amount > 100) {
            throw new IllegalArgumentException("Amount can not be less than 0 or more than 100");
        }
        addWolvesIfBelowLevel(level, amount);
        groupOfWolves.add(this);
    }

    public Wolf(int level) {
        super(level);
    }

    public void addWolvesIfBelowLevel(int level, int amount) {

          if (!checkForOneWolf(level,amount)){
            generateWolves(amount, level);
        }
    }

    public boolean checkForOneWolf (int level, int amount) {
        if (amount == 0 && level < 30) {
            int random = randomWolvesGenerator();
            generateWolves(random, level);
            return true;
        }
        return false;
    }

    public void generateWolves(int random, int level) {
        if (random > 0) {
            for (int i = 0; i < random; i++) {
                groupOfWolves.add(new Wolf(level + randomWolvesGenerator()));
            }
        }
    }

    public int randomWolvesGenerator() {
        ArrayList<Integer> randomWolves = new ArrayList<>(5);
        for (int i = 1; i < 5; i++) {
            randomWolves.add(i);
        }
        Collections.shuffle(randomWolves);
        return randomWolves.get(0);
    }

    public ArrayList<Enemy> getGroupOfWolves() {
        return groupOfWolves;
    }

    @Override
    public String toString() {
        return "Enemy type = " + getEnemyType() + ", Level = " + super.getLevel() + ", Health = " + super.getCurrentHealth() + ", Damage = " + super.getCurrentDamage() + ", Wolf ID = " + getENEMY_ID() + "\n";
    }
}

