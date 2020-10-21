package inte.grupp5.item;


// TODO: Placeholder class if we decide to use it. Same as Potion basically.

public class Food extends Consumable {

    private final int healthBonus;

    public Food(String name, int weight, int healthBonus) {
        super(name, weight);
        this.healthBonus = healthBonus;
    }

    @Override
    public double getValue() {
        return getHealthBonus() / getWeight();
    }

    @Override
    public String toString() {
        return "[" + String.format("Name: %s, Weight: %.2f, Healthbonus: %d", getName(), getWeight(), getHealthBonus()) + "]";
    }

    public int getHealthBonus() {
        return healthBonus;
    }

}
