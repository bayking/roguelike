package inte.grupp5.item;

public class QuestItem extends Item {

    public QuestItem(String name, int weight) {
        super(name, weight);
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
