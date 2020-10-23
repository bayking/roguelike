package inte.grupp5.player;
import inte.grupp5.item.Consumable;
import inte.grupp5.player.classes.Class;

import java.util.ArrayList;

// TODO: Spells, Interaction with consumables.
// Tests not done for some mana methods as they are equivalent to the hp methods
public class Player {
    public static final int MAX_LEVEL = 60;
    public static final int MIN_LEVEL = 1;
    private String name;
    //private final Race race;
    private final Class klass;
    private int maxHealthPoints, maxManaPoints, currentHealthPoints, currentManaPoints, level;
    private ArrayList<Consumable> consumables;

    public Player(String name, Class klass, int level) {
        setLevel(level);
        setName(name);
        //this.race = race;
        this.klass = klass;
        maxHealthPoints = klass.getHealth(level);
        maxManaPoints = klass.getMana(level);
        currentHealthPoints = maxHealthPoints;
        currentManaPoints = maxManaPoints;
        consumables = new ArrayList<>();
    }

    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }

    private void insufficientMana() {
        System.out.println("Insufficient Mana");
    }

    public boolean hasManaForSpell(int manaCost) {
        if (manaCost < 0)
            throw new IllegalArgumentException("Mana cost can't be less than 0.");
        if (currentManaPoints < manaCost) {
            insufficientMana();
            return false;
        }
        return true;
    }

    public void heal() {
        if (currentHealthPoints == maxHealthPoints) {
            System.out.println("Health is full");
            return;
        }
        if (hasManaForSpell(10)) {
            if (currentHealthPoints <= maxHealthPoints-5)
                currentHealthPoints-=5;
            else {
                currentHealthPoints = maxHealthPoints;
            }
        }
    }

    public String getName() {
        return name;
    }

    /*public Race getRace() {
        return race;
    }*/

    public Class getKlass() {
        return klass;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public int getCurrentManaPoints() {
        return currentManaPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        if (maxHealthPoints < 1)
            throw new IllegalArgumentException("Value can't be less than 1");
        this.maxHealthPoints = maxHealthPoints;
    }

    public void setMaxManaPoints(int maxManaPoints) {
        if (maxManaPoints < 1)
            throw new IllegalArgumentException("Value can't be less than 1");
        this.maxManaPoints = maxManaPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        if (currentHealthPoints < 0 || currentHealthPoints > maxHealthPoints) {
            throw new IllegalArgumentException("HP cannot be less than 0 or more than " + maxHealthPoints);
        }
        this.currentHealthPoints = currentHealthPoints;
    }

    public void setCurrentManaPoints(int currentManaPoints) {
        if (currentManaPoints < 0 || currentManaPoints > maxManaPoints) {
            throw new IllegalArgumentException("Mana cannot be less than 0 or more than " + maxManaPoints);
        }
        this.currentManaPoints = currentManaPoints;
    }

    public void setName(String name) {
        if (name.length() > 30 || name.length() < 3)
            throw new IllegalArgumentException("Name must contain between 3-30 characters");
        this.name = name;
    }

    public void setLevel(int level) {
        if (level > MAX_LEVEL || level < MIN_LEVEL)
            throw new IllegalArgumentException("Level must be in range 1-60");
        this.level = level;
    }
}
