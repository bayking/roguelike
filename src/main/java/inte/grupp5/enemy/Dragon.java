package inte.grupp5.enemy;

public class Dragon extends Enemy {

    private int mana;

    public Dragon(int level) {
        super(level);
        mana = getMana();
    }

    public int getMana() {
        return mana = 100;
    }

    public int getCurrentMana () {
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
        setHp(getCurrentHealth() + 25);
    }

    public void breathFireAttack () {
        if (mana > 25 ) {
            setDamage(getCurrentDamage() + 25);
            mana = mana - 25;
        }
        else {
            throw new IllegalArgumentException("Should not be called");
        }
    }






}
