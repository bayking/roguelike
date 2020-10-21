package inte.grupp5.player.classes;

public class Mage extends Class {
    private String name;
    private int startingHealth;
    private int startingMana;
    private int[] healthPerLvl = new int[59];
    private int[] manaPerLvl = new int[59];

    public Mage() {
        name = "Mage";
        startingHealth = 100;
        startingMana = 100;
        initArrays(startingHealth, startingMana);
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public int getStartingMana() {
        return startingMana;
    }

    public void setStartingMana(int startingMana) {
        this.startingMana = startingMana;
    }
}
