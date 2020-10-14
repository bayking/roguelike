package inte.grupp5.player.classes;

public abstract class  Class {
    private int[] healthPerLvl = new int[60];
    private int[] manaPerLvl = new int[60];
    // TODO: private ArrayList<Spell> spells

    void initArrays(int health, int mana) {
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
}
