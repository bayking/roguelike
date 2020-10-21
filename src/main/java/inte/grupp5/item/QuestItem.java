package inte.grupp5.item;

public class QuestItem extends Item {

    public QuestItem(String name, int weight) {
        super(name, weight);
    }

    @Override
    public double getValue() {
        int QUEST_ITEM_VALUE = 100;
        return QUEST_ITEM_VALUE;
    }

    @Override
    public String toString() {
        return "[" + String.format("Name: %s, Weight: %.2f, Value: %.2f", getName(), getWeight(), getValue()) + "]";
    }
}
