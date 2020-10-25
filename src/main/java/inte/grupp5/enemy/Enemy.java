package inte.grupp5.enemy;

public class Enemy {

    public static final double ATTRIBUTES_CALC = 1.5; //Ändra till private?
    private static int ID_COUNTER = 1;

    private final String enemyType; // gör final (klar)
    private final Enemy enemy;
    private final int ENEMY_ID;
    private final int level;
    private int hp;
    private int damage;


    public Enemy(int level) {
        if (level < 0 || level > 999)  {
            throw new IllegalArgumentException("Not valid level");
        }
        this.level = level;
        this.hp = getHealth();
        this.damage = getDamage();
        this.enemyType = getEnemyType();
        this.enemy = this;
        this.ENEMY_ID = ID_COUNTER++;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public int getENEMY_ID() {
        return ENEMY_ID;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage taken can not be below 0.");
        }
        hp = hp - damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public String getEnemyType() {
        return this.getClass().getSimpleName();
    }

    // Kan justera beroende spelarens damage eller items.
    public int getHealth() {
        return hp = (int) ((ATTRIBUTES_CALC * getLevel()) + 100);
    }

    // Kan justera beroende på spelarens damage eller items.
    public int getDamage() {
        return damage = (int) ((getLevel() * ATTRIBUTES_CALC) - level);
    }

    public int getCurrentHealth() {
        return hp; }


    public void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("Cant be below 0."); }
        else
            this.hp = hp;
    }
    public void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage can't be negative");
        }
        this.damage = damage;
    }

    public int getCurrentDamage() {
        return damage; }

    public int getLevel() {
        return level; }

        @Override
    public String toString() {
        return " Enemy type = " + enemyType + ", Level = " + level + ", Health = " + hp + ", Damage = " + damage + ", Enemy ID = " + ENEMY_ID;
    }
}