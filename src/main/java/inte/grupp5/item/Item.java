package inte.grupp5.item;

public abstract class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
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
