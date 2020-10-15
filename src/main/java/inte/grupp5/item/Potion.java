package inte.grupp5.item;

public class Potion extends Consumable {

    private final Type type;

    public enum Type {

        HEALTH(100, 20), MANA(100, 20), LEVEL(1, 40);

        private final int restoreValue;
        private final int value;


        Type(int restoreValue, int value) {
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

    public Potion(String name, int weight, Type type) {
        super(name, weight);
        this.type = type;
    }

    @Override
    public int getValue() {
        if (getType().equals(Type.HEALTH)) {
            return Type.HEALTH.getValue();
        } else if (getType().equals(Type.MANA)) {
            return Type.MANA.getValue();
        } else return Type.LEVEL.getValue();
    }

    public Type getType() {
        return type;
    }
}
