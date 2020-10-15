package inte.grupp5.item;

public class Weapon extends Item {

    private final int damage;
    private final WeaponType weaponType;

    public enum WeaponType {
        SWORD(1), BOW(10), STAFF(5);

        private final int range;

        WeaponType(int range) {
            this.range = range;
        }

        public int getRange() {
            return range;
        }
    }

    public Weapon(String name, int weight, int damage, WeaponType weaponType) {
        super(name, weight);
        this.damage = damage;
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public double getValue() {
        return getWeight() + getDamage();
    }

    @Override
    public String toString() {
        return null;
    }
}
