package inte.grupp5.item;

public class Potion extends Consumable {

    private final Type type;

    // Placeholder implementation. Each different potion type has only one value.
    // TODO: Different values for same potion type?

    public enum Type {

        HEALTH(100), MANA(100), LEVEL(1);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Potion(String name, Type type) {
        super(name);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
