package inte.grupp5.item;

public abstract class Gear extends Item {

    private final int armorRating;

    public Gear(String name, int weight, int armor) {
        super(name, weight);
        if (armor < 0) throw new IllegalArgumentException("Armor can not be below zero!");
        this.armorRating = armor;
    }

    @Override
    public int getValue() {
        return getArmorRating() / getWeight();
    }

    public int getArmorRating() {
        return armorRating;
    }
}
