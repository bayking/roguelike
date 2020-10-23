package inte.grupp5.item;

public abstract class Item {

    private final String name;
    private final double weight;

    public Item(String name, double weight) {
        if (name == null || name.isBlank()) throw
                new IllegalArgumentException("Name can not be empty!");
        this.name = name;
        if (weight <= 0) throw
                new IllegalArgumentException("Weight can not be zero or below!");
        this.weight = weight;
    }

    public abstract double getValue();

    public abstract String toString();

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
