package inte.grupp5.enemy;

public class Enemy {
    private int hp;
    private int level;
    private int attackDamage;

    public static final double ATTRIBUTES_CALC = 1.5;


    public Enemy(int level) {
        if (level <= 0 || level > 999)  {
            throw new IllegalArgumentException("Not valid");
        }
        this.level = level;
        this.hp = getHealth(level);
        this.attackDamage = getAttackDamage(level);

    }

    public int getHealth(int level) {
        if (level <= 0 || level > 999)  {
            throw new IllegalArgumentException("Not valid");
        }
        return (int) (ATTRIBUTES_CALC * level + 30);
    }

    public int getAttackDamage(int level) {
        if (level <= 0)  {
            throw new IllegalArgumentException("Not valid");
        }
        return (int) ((level * ATTRIBUTES_CALC) - level);
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return " Level = " + level + " Health = " + hp + " Attack damage = " + attackDamage;
    }
}
