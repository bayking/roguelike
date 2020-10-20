package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;

import java.util.ArrayList;

public class Chest {

    private ArrayList<Item> items = new ArrayList<>();

    // TODO: Implement for all the Player Classes.
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

        if (player.getKlass() instanceof Mage) {

            // Every chest has a mana potion when you are a mage.
            items.add(new Potion(MANA_POTION_STR, 2, Potion.PotionType.MANA_POTION));

            // Based on player level, adds Staff with different damage,
            // and Light armor with different armor rating.
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
        } else {
            // Adds extra health potion if you are not a mage.
            items.add(new Potion(HEALTH_POTION_STR, 2, Potion.PotionType.HEALTH_POTION));

            // Based on player level, adds Sword with different damage,
            // and Heavy armor with different armor rating.
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
            } else if (player.getLevel() > 50 && player.getLevel() <= 60) {
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

    // TODO: This method should be in the Player class.
    public ArrayList<Item> openChest(Player player) {
        generateItems(player);
        return getItems();
    }

    // Todo: This method is public until openChest() gets implemented in Player.
    public ArrayList<Item> getItems() {
        return items;
    }

}
