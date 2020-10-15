package inte.grupp5.item;

public abstract class Item {

    private final String name;
    private final int weight;

    public Item(String name, int weight) {
        if (name == null || name.isBlank()) throw
                new IllegalArgumentException("Name can not be empty!");
        this.name = name;
        if (weight <= 0) throw
                new IllegalArgumentException("Weight can not be zero or below!");
        this.weight = weight;
    }

    public abstract int getValue();

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
