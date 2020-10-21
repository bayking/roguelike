package inte.grupp5.player.classes;

public class Paladin extends Class {
    public Paladin(String name) {
        super(name);
        this.startingHealth = 200;
        this.startingMana = 80;
        initArrays(startingHealth, startingMana);
    }
}