package inte.grupp5.item;

public class Weapon extends Item {

    private int damage;

    public Weapon(String name, int weight, int damage) {
        super(name, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int getValue() {
        return getWeight() + getDamage();
    }
}
