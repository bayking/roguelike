package inte.grupp5.item;

public class Consumable extends Item{

    private final int healthBonus;

    public Consumable(String name, int healthBonus) {
        super(name);
        this.healthBonus = healthBonus;
    }

    public int getHealthBonus() {
        return healthBonus;
    }
}
