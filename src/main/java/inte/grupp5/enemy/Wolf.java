package inte.grupp5.enemy;

import java.util.ArrayList;
import java.util.Collections;


public class Wolf extends Enemy {

    public String wolfId;

    private ArrayList<Wolf> groupOfWolfes = new ArrayList <Wolf>();
    private ArrayList<Integer> random = new ArrayList<>(5);

    public Wolf(int level) {
        super(level);
        addWolvesIfBelowLevel(level);
        groupOfWolfes.add(this);
        wolfId = getWolfId();
    }

    public Wolf (int level, String wolfId) {
        super(level);
        this.wolfId = wolfId;
    }

    public String getWolfId() {
        return wolfId =  "Wolf " + groupOfWolfes.size();
    }

    public ArrayList<Wolf> getGroupOfWolves() {
        return groupOfWolfes;
    }

    public ArrayList<Integer> getRandom() {
        return random;
    }



    // Om vargen är under level 30 i första konstruktorn skapas mellan 1-5 vargar i den andra konstruktorn.
    public void addWolvesIfBelowLevel(int level) {
        if (level < 30)  {
            int random = randomWolvesGenerator();
            for(int i=0;i<random;i++) {
                Wolf w = new Wolf(level + randomWolvesGenerator(), getWolfId());
                groupOfWolfes.add(w);
            }
        }
    }

    //Slumpar en siffra mellan 1-5.
    public int randomWolvesGenerator() {
        for(int i=1;i<5;i++)
            random.add(i);
        Collections.shuffle(random);
        return random.get(0);
    }

    @Override
    public String toString() {
        return  "Enemy type = " + getEnemyType() + ", Level = " + super.getLevel() + ", Health = " + super.getHealth(getLevel()) + ", Damage = " + super.getDamage(getLevel()) + ", Wolf ID = " + getWolfId() + "\n";
    }
}
