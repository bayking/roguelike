package inte.grupp5.player.classes;

import java.util.Objects;

public abstract class  Class {
    private final String name;
    private int[] healthPerLvl = new int[60];
    private int[] manaPerLvl = new int[60];
    protected int startingHealth;
    protected int startingMana;
    // TODO: private ArrayList<Spell> spells

    public Class(String name) {
        this.name = name;
    }

    public Class() {
        this.name = "test";
        this.startingHealth = 50;
        this.startingMana = 50;
    }

    protected void initArrays(int health, int mana) {
        if (health <= 0 || mana <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i<=59;i++) {
            healthPerLvl[i] = health;
            manaPerLvl[i] = mana;
            health = health+100;
            mana = mana+100;
        }
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public int getStartingMana() {
        return startingMana;
    }

    public void setStartingMana(int startingMana) {
        this.startingMana = startingMana;
    }

    public int getHealth(int level) {
        if (level <= 0 || level > 60)
            throw new IllegalArgumentException("Level must be in range 1-60");
        return healthPerLvl[level-1];
    }

    public int getMana(int level) {
        if (level < 0 || level > 60)
            throw new IllegalArgumentException("Level must be in range 1-60");
        if (level == 0)
            return manaPerLvl[level];
        return manaPerLvl[level-1];
    }
  
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Class))
            return false;
        Class other = (Class)o;
        boolean nameEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equalsIgnoreCase(other.name));
        return this.name.equals(other.name) && nameEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
