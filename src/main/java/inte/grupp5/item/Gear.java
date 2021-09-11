package inte.grupp5.item;

public abstract class Gear extends Item {

    private final int armorRating;
    private Enchantment enchantment;

    public enum Enchantment {
        NONE(0, 1, 1, false, false),
        INVISIBILITY(30, 1, 1, true, false),
        QUAD_DAMAGE(15, 4, 1, false, false),
        PROTECTION(20, 1, 10, false, false),
        INFERNO(20, 1, 1, false, true);

        private final int duration;
        private final int damageModifier;
        private final int armorModifier;
        private final boolean muffled;
        private final boolean damageNearby;

        Enchantment(int duration, int damageModifier, int armorModifier, boolean muffled, boolean damageNearby) {
            this.duration = duration;
            this.damageModifier = damageModifier;
            this.armorModifier = armorModifier;
            this.muffled = muffled;
            this.damageNearby = damageNearby;
        }

        public boolean isMuffled() {
            return muffled;
        }

        public boolean doesDamageToNearby() {
            return damageNearby;
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

    public Gear(String name, double weight, int armor, Enchantment enchantment) {
        super(name, weight);
        if (armor < 0) {
            throw new IllegalArgumentException("Armor can not be negative!");
        }
        this.armorRating = armor;
        if (enchantment == null) {
            throw new IllegalArgumentException("Enchantment can not be null! Choose NONE instead");
        }
        this.enchantment = enchantment;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public abstract void useEnchantment();

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantmentToNONE() {
        enchantment = Enchantment.NONE;
    }

    @Override
    public double getValue() {
        return (armorRating / getWeight()) *
                enchantment.damageModifier *
                enchantment.armorModifier +
                enchantment.duration;
    }
}
