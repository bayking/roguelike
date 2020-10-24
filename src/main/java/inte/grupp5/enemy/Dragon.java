package inte.grupp5.enemy;

public class Dragon extends Enemy {

    private int mana = 100;

    public Dragon(int level) {
        super(level);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    //Testa med combat klasserna
    public void itemUsedOnDragon(int damage) {
        super.takeDamage(damage);
    }

    public void healItself() {
        setHp(getHealth() + 25);
    }

    public void breathFireAttack () {
        if (mana > 25 ) {
            setDamage(getDamage() + 25);
            mana = getMana() -25;
        }
        else {
            throw new IllegalArgumentException("Should not be called");
        }
    }






}
