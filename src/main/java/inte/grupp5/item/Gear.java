package inte.grupp5.item;

public class Gear extends Item {

    private int armor;

    public Gear(String name, int weight, int armor) {
        super(name, weight);
        this.armor = armor;
    }

    @Override
    public int getValue() {
        return 0;
    }
}
