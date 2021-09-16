package inte.grupp5.item;

public class Armor extends Gear {

    private final ArmorType armorType;

    public enum ArmorType {
        LIGHT_ARMOR, HEAVY_ARMOR
    }

    public Armor(String name, double weight, int armor, ArmorType armorType, Enchantment enchantment) {
        super(name, weight, armor, enchantment);
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public String toString() {
        return "[" + String.format("Name: %s, Weight: %.2f, Armor rating: %d", getName(), getWeight(), getArmorRating()) + ", Armor type: " + getArmorType() + ", Enchantment: " + getEnchantment() + "]";
    }
}
