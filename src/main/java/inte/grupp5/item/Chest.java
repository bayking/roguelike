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

    private void readItemsFromCsvFile(Player player) {

        // Add default items
        items.add(new Potion(getHealthPotionName(), getPotionWeight(), Potion.PotionType.HEALTH_POTION));
        items.add(new Potion(getLevelPotionName(), getPotionWeight(), Potion.PotionType.LEVEL_POTION));

        try {
            String playerType = player.getKlass().getClass().getName();
            String[] splitType = playerType.split("\\.");
            playerType = splitType[splitType.length - 1];
            FileReader fileReader = new FileReader( "src/main/java/resources/" + playerType + "ChestGenerator.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] split;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                split = line.split(",");
                //TODO: compare Player level to first int in each row.
                // If level < int read next int on that row
                // Set weapon damage to second int
                // Set armor rating to third/last int
                if (player.getLevel() < Integer.parseInt(split[0])) {
                    // TODO: if mage add staff and light armor
                    //  if paladin add sword and heavy armor
                    if (player.getKlass() instanceof Mage) {
                        items.add(new Potion
                                (getManaPotionName(), getPotionWeight(), Potion.PotionType.MANA_POTION));
                        items.add(new Weapon
                                (getStaffName(), getStaffWeight(), Integer.parseInt(split[1]), Weapon.WeaponType.STAFF));
                        items.add(new Armor
                                (getLightArmorName(), getLightArmorWeight(), Integer.parseInt(split[2]), Armor.ArmorType.LIGHT_ARMOR));
                    } else if (player.getKlass() instanceof Paladin) {
                        items.add(new Potion
                                (getHealthPotionName(), getPotionWeight(), Potion.PotionType.HEALTH_POTION));
                        items.add(new Weapon
                                (getSwordName(), getSwordWeight(), Integer.parseInt(split[1]), Weapon.WeaponType.SWORD));
                        items.add(new Armor
                                (getHeavyArmorName(), getHeavyArmorWeight(), Integer.parseInt(split[2]), Armor.ArmorType.HEAVY_ARMOR));
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

    public void generateItems(Player player) {

        // Variable declaration
        int WEAPON_DMG_LVL_1 = 5;
        int WEAPON_DMG_LVL_10 = 10;
        int WEAPON_DMG_LVL_20 = 20;
        int WEAPON_DMG_LVL_30 = 30;
        int WEAPON_DMG_LVL_40 = 40;
        int WEAPON_DMG_LVL_50 = 50;
        int WEAPON_DMG_LVL_60 = 60;

        int SWORD_WEIGHT = 5;
        int STAFF_WEIGHT = 3;
        int BOW_WEIGHT = 3;

        int LIGHT_ARMOR_WEIGHT = 7;
        int HEAVY_ARMOR_WEIGHT = 10;

        int LGT_ARM_RTG_LVL_1 = 5;
        int LGT_ARM_RTG_LVL_10 = 10;
        int LGT_ARM_RTG_LVL_20 = 20;
        int LGT_ARM_RTG_LVL_30 = 30;
        int LGT_ARM_RTG_LVL_40 = 40;
        int LGT_ARM_RTG_LVL_50 = 50;
        int LGT_ARM_RTG_LVL_60 = 60;

        int HVY_ARM_RTG_LVL_1 = 10;
        int HVY_ARM_RTG_LVL_10 = 20;
        int HVY_ARM_RTG_LVL_20 = 30;
        int HVY_ARM_RTG_LVL_30 = 40;
        int HVY_ARM_RTG_LVL_40 = 50;
        int HVY_ARM_RTG_LVL_50 = 60;
        int HVY_ARM_RTG_LVL_60 = 70;

        String SWORD_STR = "Sword";
        String BOW_STR = "Bow";
        String STAFF_STR = "Staff";

        String MANA_POTION_STR = "Mana potion";
        String HEALTH_POTION_STR = "Health potion";
        String LEVEL_POTION_STR = "Level potion";

        String LIGHT_ARMOR_STR = "Light armor";
        String HEAVY_ARMOR_STR = "Heavy armor";

        // Adds a health potion and a level potion to every chest.
        items.add(new Potion(HEALTH_POTION_STR, 2, Potion.PotionType.HEALTH_POTION));
        items.add(new Potion(LEVEL_POTION_STR, 1, Potion.PotionType.LEVEL_POTION));

        // TODO: make this read from a CSV-file that depends on player level and class.
        // If player is of class Mage
        if (player.getKlass() instanceof Mage) {

            // Every chest has a mana potion when you are a mage.
            items.add(new Potion(MANA_POTION_STR, 2, Potion.PotionType.MANA_POTION));

            // Based on player level, adds Staff with increasing damage,
            // and Light armor with increasing armor rating.
            if (player.getLevel() <= 10) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_1, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_1, Armor.ArmorType.LIGHT_ARMOR));
            } else if (player.getLevel() > 10 && player.getLevel() <= 20) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_10, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_10, Armor.ArmorType.LIGHT_ARMOR));
            } else if (player.getLevel() > 20 && player.getLevel() <= 30) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_20, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_20, Armor.ArmorType.LIGHT_ARMOR));
            } else if (player.getLevel() > 30 && player.getLevel() <= 40) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_30, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_30, Armor.ArmorType.LIGHT_ARMOR));
            } else if (player.getLevel() > 40 && player.getLevel() <= 50) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_40, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_40, Armor.ArmorType.LIGHT_ARMOR));
            } else if (player.getLevel() > 50 && player.getLevel() < 60) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_50, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_50, Armor.ArmorType.LIGHT_ARMOR));
            } else if (player.getLevel() == 60) {
                items.add(new Weapon
                        (STAFF_STR, STAFF_WEIGHT, WEAPON_DMG_LVL_60, Weapon.WeaponType.STAFF));
                items.add(new Armor
                        (LIGHT_ARMOR_STR, LIGHT_ARMOR_WEIGHT, LGT_ARM_RTG_LVL_60, Armor.ArmorType.LIGHT_ARMOR));
            }
        } else if (player.getKlass() instanceof Paladin) {

            // Adds extra health potion if you are not a mage.
            items.add(new Potion(HEALTH_POTION_STR, 2, Potion.PotionType.HEALTH_POTION));

            // Based on player level, adds Sword with increasing damage,
            // and Heavy armor with increasing armor rating.
            if (player.getLevel() <= 10) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_1, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_1, Armor.ArmorType.HEAVY_ARMOR));
            } else if (player.getLevel() > 10 && player.getLevel() <= 20) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_10, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_10, Armor.ArmorType.HEAVY_ARMOR));
            } else if (player.getLevel() > 20 && player.getLevel() <= 30) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_20, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_20, Armor.ArmorType.HEAVY_ARMOR));
            } else if (player.getLevel() > 30 && player.getLevel() <= 40) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_30, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_30, Armor.ArmorType.HEAVY_ARMOR));
            } else if (player.getLevel() > 40 && player.getLevel() <= 50) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_40, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_40, Armor.ArmorType.HEAVY_ARMOR));
            } else if (player.getLevel() > 50 && player.getLevel() < 60) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_50, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_50, Armor.ArmorType.HEAVY_ARMOR));
            } else if (player.getLevel() == 60) {
                items.add(new Weapon
                        (SWORD_STR, SWORD_WEIGHT, WEAPON_DMG_LVL_60, Weapon.WeaponType.SWORD));
                items.add(new Armor(HEAVY_ARMOR_STR, HEAVY_ARMOR_WEIGHT, HVY_ARM_RTG_LVL_60, Armor.ArmorType.HEAVY_ARMOR));
            }
        }
    }

    public ArrayList<Item> openChest(Player player) {
        items.clear();
        //generateItems(player);
        readItemsFromCsvFile(player);
        return items;
    }

    public ArrayList<Item> openChestUpdated(Player player) {
        items.clear();
        readItemsFromCsvFile(player);
        return items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
