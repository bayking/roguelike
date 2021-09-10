package inte.grupp5.item;

public abstract class Gear extends Item {

    private final int armorRating;
    private final Enchantment enchantment;

    public enum Enchantment {
        NONE(0, 1, 1),
        INVISIBILITY(30, 1, 1),
        QUAD_DAMAGE(15, 4, 1),
        PROTECTION(20, 1, 10);

        private final int duration;
        private final int damageModifier;
        private final int armorModifier;

        Enchantment(int duration, int damageModifier, int armorModifier) {
            this.duration = duration;
            this.damageModifier = damageModifier;
            this.armorModifier = armorModifier;
        }

        public int getDuration() {
            return duration;
        }

        public int getDamageModifier() {
            return damageModifier;
        }

        public int getArmorModifier() {
            return armorModifier;
        }
    }

    public Gear(String name, int weight, int armor, Enchantment enchantment) {
        super(name, weight);
        if (armor < 0) {
            throw new IllegalArgumentException("Armor can not be below zero!");
        }
        this.armorRating = armor;
        this.enchantment = enchantment;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    @Override
    public double getValue() {
        return (armorRating / getWeight()) *
                enchantment.damageModifier *
                enchantment.armorModifier +
                enchantment.duration;
    }
}
