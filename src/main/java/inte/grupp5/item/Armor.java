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

    // TODO: Using an enchantment depletes the enchantment, replace with non enchanted equivalent
    //  or make it have a cooldown
    //  or make it be rechargeable
    //  if player has active enchantments that interfere with the current one, eq. using INFERNO when INVISIBLE is active
    //  should do SOMETHING, maybe disable the other enchantment
    @Override
    public void useEnchantment() {
        if (!getEnchantment().equals(Enchantment.NONE)) {
            // Do something

            setEnchantmentToNONE();
        } else {
            throw new IllegalStateException("Gear: " + this.getName() + " is not enchanted: " + this.getEnchantment());
        }
    }

    @Override
    public String toString() {
        return "[" + String.format("Name: %s, Weight: %.2f, Armor rating: %d", getName(), getWeight(), getArmorRating()) + ", Armor type: " + getArmorType() + "]";
    }
}
