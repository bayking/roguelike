package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Chest {

    private static final String[] staffNames = {"Staff", "Staff of storms", "Wabbajack"};
    private static final String[] swordNames = {"Sword", "Sword of pain", "Sting"};
    private static final String[] lightArmorNames = {"Light armor", "Leather armor", "Fur armor"};
    private static final String[] heavyArmorNames = {"Heavy armor", "Steel armor", "Dragonplate armor"};
    private static final String[] healthPotionNames = {"Health potion", "Draught of health", "Elixir of Health"};
    private static final String[] levelPotionNames = {"Level potion", "Rare candy", "Draught of experience"};
    private static final String[] manaPotionNames = {"Mana potion", "Elixir of mana"};

    private final ArrayList<Item> items = new ArrayList<>();

    private void generateItemsFromFile(Player player) {
        // Add default items
        items.add(new Potion(getHealthPotionName(), getPotionWeight(), Potion.PotionType.HEALTH_POTION));
        items.add(new Potion(getLevelPotionName(), getPotionWeight(), Potion.PotionType.LEVEL_POTION));
        try {
            String playerType = player.getKlass().getClass().getName();
            String[] splitType = playerType.split("\\.");
            playerType = splitType[splitType.length - 1];
            FileReader fileReader = new FileReader("src/main/java/resources/" + playerType + "ChestGenerator.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] split;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                split = line.split(",");
                // compares Player level to first int in each row.
                // If level < int, read next int on that row
                // Set weapon damage to second int
                // Set armor rating to third int
                if (player.getLevel() < Integer.parseInt(split[0])) {
                    if (player.getKlass() instanceof Mage) {
                        items.add(new Potion
                                (getManaPotionName(), getPotionWeight(), Potion.PotionType.MANA_POTION));
                        items.add(new Weapon
                                (getStaffName(), getStaffWeight(), Integer.parseInt(split[1]), Weapon.WeaponType.STAFF));
                        items.add(new Armor
                                (getLightArmorName(), getLightArmorWeight(), Integer.parseInt(split[2]), Armor.ArmorType.LIGHT_ARMOR, getEnchantment()));
                    } else if (player.getKlass() instanceof Paladin) {
                        items.add(new Potion
                                (getHealthPotionName(), getPotionWeight(), Potion.PotionType.HEALTH_POTION));
                        items.add(new Weapon
                                (getSwordName(), getSwordWeight(), Integer.parseInt(split[1]), Weapon.WeaponType.SWORD));
                        items.add(new Armor
                                (getHeavyArmorName(), getHeavyArmorWeight(), Integer.parseInt(split[2]), Armor.ArmorType.HEAVY_ARMOR, getEnchantment()));
                    }
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File " + e.getLocalizedMessage() + "not found!");
        } catch (IOException e) {
            System.err.println("ERROR: I/O error " + e.getMessage());
        }
    }

    public ArrayList<Item> openChest(Player player) {
        items.clear();
        generateItemsFromFile(player);
        return items;
    }

    private Gear.Enchantment getEnchantment() {

        int rng = ThreadLocalRandom.current().nextInt(100);

        if (rng > 0 && rng <= 70) {
            return Gear.Enchantment.NONE;
        } else if (rng > 70 && rng <= 80) {
            return Gear.Enchantment.QUAD_DAMAGE;
        } else if (rng > 80 && rng <= 90) {
            return Gear.Enchantment.INVISIBILITY;
        } else return Gear.Enchantment.PROTECTION;
    }

    private int getSwordWeight() {
        int min = 7;
        int max = 16;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private String getManaPotionName() {
        int rng = ThreadLocalRandom.current().nextInt(0, manaPotionNames.length);
        return manaPotionNames[rng];
    }

    private int getPotionWeight() {
        int min = 1;
        int max = 3;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private String getLevelPotionName() {
        int rng = ThreadLocalRandom.current().nextInt(0, levelPotionNames.length);
        return levelPotionNames[rng];
    }

    private String getHealthPotionName() {
        int rng = ThreadLocalRandom.current().nextInt(0, healthPotionNames.length);
        return healthPotionNames[rng];
    }

    private int getLightArmorWeight() {
        int min = 5;
        int max = 10;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private int getHeavyArmorWeight() {
        int min = 15;
        int max = 20;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private int getStaffWeight() {
        int min = 1;
        int max = 8;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private String getSwordName() {
        int rng = ThreadLocalRandom.current().nextInt(0, swordNames.length);
        return swordNames[rng];
    }

    private String getStaffName() {
        int rng = ThreadLocalRandom.current().nextInt(0, staffNames.length);
        return staffNames[rng];
    }

    private String getLightArmorName() {
        int rng = ThreadLocalRandom.current().nextInt(0, lightArmorNames.length);
        return lightArmorNames[rng];
    }

    private String getHeavyArmorName() {
        int rng = ThreadLocalRandom.current().nextInt(0, heavyArmorNames.length);
        return heavyArmorNames[rng];
    }

}
