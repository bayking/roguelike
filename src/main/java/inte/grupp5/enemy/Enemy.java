package inte.grupp5.enemy;

public class Enemy {
    private static int ID_COUNTER = 1;

    private Enemy enemy;
    private int hp;
    private int level;
    private int damage;
    private int enemyID;
    private String enemyType;

    public static final double ATTRIBUTES_CALC = 1.5;

    public Enemy(int level) {
        if (level < 0 || level > 999)  {
            throw new IllegalArgumentException("Not valid level");
        }
        this.level = level;
        this.hp = getHealth(level);
        this.damage = getDamage(level);
        this.enemyType = getEnemyType();
        this.enemyID = ID_COUNTER;
        this.enemy = this;
        ID_COUNTER ++;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public int getEnemyID() {
        return enemyID;
    }
    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    public String getEnemyType() {
        return this.getClass().getSimpleName();
    }

    // Kan justera beroende spelarens damage eller items.
    public int getHealth(int level) {
        return hp = (int) ((ATTRIBUTES_CALC * level) + 100);
    }

    // Kan justera beroende på spelarens damage eller items.
    public int getDamage(int level) {
        return damage = (int) ((level * ATTRIBUTES_CALC) - level);
    }

    public int getHealth() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return " Enemy type = " + enemyType + ", Level = " + level + ", Health = " + hp + ", Damage = " + damage + ", Enemy ID = " + enemyID ;
    }
}