package inte.grupp5.enemy;

import java.util.ArrayList;
import java.util.Collections;


    public class Wolf extends Enemy {

        private ArrayList<Enemy> groupOfWolves = new ArrayList<Enemy>();
        private ArrayList<Integer> randomWolves = new ArrayList<>(5);

        public Wolf(int level, int amount) {
            super(level);
            addWolvesIfBelowLevel(level, amount);
            groupOfWolves.add(this);
        }

        public Wolf(int level) {
            super(level);
        }

        public ArrayList<Integer> getRandom() {
            return randomWolves;
        }

        public ArrayList<Enemy> getGroupOfWolves() {
            return groupOfWolves;
        }

        // Om vargen är under level 30 i första konstruktorn skapas mellan 1-5 vargar i den andra konstruktorn.
        public void addWolvesIfBelowLevel(int level, int amount) {
            if (amount <= 0) {
                if (level < 30) {
                    int random = randomWolvesGenerator();
                    generateWolves(random, level);
                }
            } else {
                generateWolves(amount, level);
            }
        }

        public void generateWolves(int random, int level) {
            if (random > 0) {
                for (int i = 0; i < random; i++) {
                    Wolf w = new Wolf(level + randomWolvesGenerator());
                    groupOfWolves.add(w);
                }
            }
        }

        //Slumpar en siffra mellan 1-5.
        public int randomWolvesGenerator() {
            for (int i = 1; i < 5; i++)
                randomWolves.add(i);
            Collections.shuffle(randomWolves);
            return randomWolves.get(0);
        }

        @Override
        public String toString() {
            return "Enemy type = " + getEnemyType() + ", Level = " + super.getLevel() + ", Health = " + super.getHealth(getLevel()) + ", Damage = " + super.getDamage(getLevel()) + ", Wolf ID = " + getEnemyID() + "\n";
        }
    }

