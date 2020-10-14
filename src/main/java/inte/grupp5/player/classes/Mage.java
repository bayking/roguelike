package inte.grupp5.player.classes;

public class Mage extends Class {
    private String name;
    private int startingHealth;
    private int startingMana;
    private int[] healthPerLvl = new int[59];
    private int[] manaPerLvl = new int[59];

    public Mage(String name) {
        startingHealth = 100;
        startingMana = 100;
        initArrays(startingHealth, startingMana);
    }
}
