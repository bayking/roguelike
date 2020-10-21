package inte.grupp5.player.classes;

public class Mage extends Class {
    public Mage(String name) {
        super(name);
        this.startingHealth = 100;
        this.startingMana = 100;
        initArrays(startingHealth, startingMana);
    }
}
