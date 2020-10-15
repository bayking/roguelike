package inte.grupp5.enemy;


public class Enemy {
    private int id;
    private int hp;
    private int level;
    private int attackDamage;
    private String enemyType;

    private static final double ATTRIBUTES_CALC = 1.5;


    public Enemy(int level, String enemyType) {
        this.level = level;
        this.enemyType = enemyType;
        this.hp = getHealth(level, enemyType);
        this.attackDamage = getAttackDamage(level);
    }

    public int getHealth(int level, String enemyType) {
        if (enemyType.equals("Dragon")) {
            return (int) (ATTRIBUTES_CALC * level + 30);
        }
        return (int) (level * ATTRIBUTES_CALC);
    }

    public int getAttackDamage(int level) {
        return (int) ((level * ATTRIBUTES_CALC) - level);
    }


    @Override
    public String toString() {
        return "Enemy type = " + enemyType + " Level = " + level + " Health = " + hp + " Attack damage = " + attackDamage;
    }
}
