package inte.grupp5.enemy;

import java.util.ArrayList;
import java.util.Collections;


public class Wolf extends Enemy {
    private String enemyType;

    private ArrayList<Wolf> groupOfWolfes = new ArrayList <Wolf>();
    private ArrayList<Integer> random = new ArrayList<>(5);

    public Wolf(int level, String enemyType) {
        super(level);
        if (enemyType == null || !enemyType.equals("Wolf")) {
            throw new IllegalArgumentException("Not valid");
        }
        addWolvesIfBelowLevel(super.getLevel());
        this.enemyType = enemyType;
        groupOfWolfes.add(this);
    }

    public Wolf (int level) {
        super(level);
        this.enemyType = "Wolf";
    }

    public ArrayList<Wolf> getGroupOfWolfes() {
        return groupOfWolfes;
    }

    public ArrayList<Integer> getRandom() {
        return random;
    }

    public String getEnemyType() {
        return enemyType;
    }

    public void addWolvesIfBelowLevel(int level) {
        if (level < 30)  {
            int random = randomWolvesGenerator();
            for(int i=0;i<random;i++) {
                Wolf w = new Wolf(level + randomWolvesGenerator());
                groupOfWolfes.add(w);
            }
        }
    }

    public void printGroupOfWolfes() {
        Collections.shuffle(groupOfWolfes);
        System.out.println(groupOfWolfes);
    }


    public int randomWolvesGenerator() {
        for(int i=1;i<5;i++)
            random.add(i);
        Collections.shuffle(random);
        return random.get(0);
    }

    @Override
    public String toString() {
        return  "Enemy type = " + getEnemyType() + " Level = " + super.getLevel() + " Health = " + super.getHealth(getLevel()) + " Attack damage = " + super.getAttackDamage(getLevel());
    }
}
