package inte.grupp5.item;


// TODO: Is this class necessary? Same as Potion basically.

public class Food extends Consumable {

    private final int healthBonus;

    public Food(String name, int weight, int healthBonus) {
        super(name, weight);
        this.healthBonus = healthBonus;
    }

    @Override
    public int getValue() {
        return getHealthBonus() / getWeight();
    }

    public int getHealthBonus() {
        return healthBonus;
    }

}
