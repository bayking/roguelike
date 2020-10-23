package inte.grupp5.item;

public class Potion extends Consumable {

    private final PotionType potionType;

    public enum PotionType {

        // TODO: Have level potion give experience instead of whole level?

        HEALTH_POTION(100, 20), MANA_POTION(100, 20), LEVEL_POTION(1, 40);

        private final int restoreValue;
        private final int value;

        PotionType(int restoreValue, int value) {
            this.restoreValue = restoreValue;
            this.value = value;
        }

        public int getRestoreValue() {
            return restoreValue;
        }

        public int getValue() {
            return value;
        }
    }

    public Potion(String name, int weight, PotionType potionType) {
        super(name, weight);
        this.potionType = potionType;
    }

    @Override
    public double getValue() {
        if (getPotionType().equals(PotionType.HEALTH_POTION)) {
            return PotionType.HEALTH_POTION.getValue();
        } else if (getPotionType().equals(PotionType.MANA_POTION)) {
            return PotionType.MANA_POTION.getValue();
        } else return PotionType.LEVEL_POTION.getValue();
    }

    public PotionType getPotionType() {
        return potionType;
    }

    @Override
    public String toString() {
        return "[" + String.format("Name: %s, Weight: %.2f", getName(), getWeight()) + ", Potion type: " + getPotionType() + "]";
    }
}
