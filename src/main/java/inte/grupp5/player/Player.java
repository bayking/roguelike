package inte.grupp5.player;

import inte.grupp5.player.classes.Class;
import inte.grupp5.player.spell.Spell;

import java.util.ArrayList;

// TODO: Tests för int Damage, getDamage, setDamage, takeDamage.
// TODO: Interaction with consumables.
public class Player {
    public static final int MAX_LEVEL = 60;
    public static final int MIN_LEVEL = 1;
    private String name;
    private final Class klass;
    private int maxHealthPoints, maxManaPoints, currentHealthPoints, currentManaPoints, level, damage; //la till damage
    private ArrayList<Spell> spells;

    public Player(String name, Class klass, int level) {
        setLevel(level);
        setName(name);
        //this.race = race;
        this.klass = klass;
        maxHealthPoints = klass.getHealth(level);
        maxManaPoints = klass.getMana(level);
        currentHealthPoints = maxHealthPoints;
        currentManaPoints = maxManaPoints;
        spells = klass.getSpells();
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

    public boolean heal(int amount) {
        if (currentHealthPoints == maxHealthPoints) {
            System.out.println("Health is full");
        }
        else if (hasManaForSpell(10)) {
            if (currentHealthPoints <= maxHealthPoints-amount)
                currentHealthPoints +=amount;
            else {
                currentHealthPoints = maxHealthPoints;
            }
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

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

    public void takeDamage (int damage) {
            currentHealthPoints = currentHealthPoints - damage;
        if (currentHealthPoints < 0) {
            currentHealthPoints = 0;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0 )
            throw new IllegalArgumentException("Value can't be less than 1");
        this.damage = damage;
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

    public boolean castSpell(Spell spell) {
        return spell.cast(this);
    }
}
