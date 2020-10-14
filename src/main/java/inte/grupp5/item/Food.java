package inte.grupp5.item;

public class Food extends Consumable {

    private final int healthBonus;

    public Food(String name, int healthBonus) {
        super(name);
        this.healthBonus = healthBonus;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

}
