package inte.grupp5.player.classes;

import inte.grupp5.player.spell.InvokeMana;

public class Mage extends Class {
    public Mage(String name) {
        super(name);
        startingHealth = 100;
        startingMana = 100;
        initArrays(startingHealth, startingMana);
        spells.add(new InvokeMana());
    }
}
