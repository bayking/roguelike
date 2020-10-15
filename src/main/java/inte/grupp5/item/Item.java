package inte.grupp5.item;

public abstract class Item {

    private String name;
    private int value;
    private int weight;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
