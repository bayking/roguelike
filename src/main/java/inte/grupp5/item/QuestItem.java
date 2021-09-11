package inte.grupp5.item;

public class QuestItem extends Item {

    public QuestItem(String name, double weight) {
        super(name, weight);
    }

    @Override
    public double getValue() {
        return 100;
    }

    @Override
    public String toString() {
        return "[" + String.format("Name: %s, Weight: %.2f, Value: %.2f", getName(), getWeight(), getValue()) + "]";
    }
}
