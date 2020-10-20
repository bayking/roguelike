package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;

import java.util.ArrayList;

public class Chest {

    private ArrayList<Item> items = new ArrayList<>();

    // TODO: Implement for all the Player Classes.
    public void generateItems(Player player) {
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

        String SWORD = "Sword";
        String BOW = "Bow";
        String STAFF = "Staff";

        String MANA_POTION = "Mana potion";
        String HEALTH_POTION = "Health potion";
        String LEVEL_POTION = "Level potion";

        // Adds a health potion and a level potion to every chest.
        items.add(new Potion(HEALTH_POTION, 2, Potion.PotionType.HEALTH_POTION));
        items.add(new Potion(LEVEL_POTION, 1, Potion.PotionType.LEVEL_POTION));

        if (player.getKlass() instanceof Mage) {

            // Every chest has a mana potion when you are a mage.
            items.add(new Potion(MANA_POTION, 2, Potion.PotionType.MANA_POTION));

            // Based on player level, adds Staff with different damage.
            if (player.getLevel() <= 10) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_1, Weapon.WeaponType.STAFF));
            } else if (player.getLevel() > 10 && player.getLevel() <= 20) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_10, Weapon.WeaponType.STAFF));
            } else if (player.getLevel() > 20 && player.getLevel() <= 30) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_20, Weapon.WeaponType.STAFF));
            } else if (player.getLevel() > 30 && player.getLevel() <= 40) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_30, Weapon.WeaponType.STAFF));
            } else if (player.getLevel() > 40 && player.getLevel() <= 50) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_40, Weapon.WeaponType.STAFF));
            } else if (player.getLevel() > 50 && player.getLevel() < 60) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_50, Weapon.WeaponType.STAFF));
            } else if (player.getLevel() == 60) {
                items.add(new Weapon
                        (STAFF, STAFF_WEIGHT, WEAPON_DMG_LVL_60, Weapon.WeaponType.STAFF));
            }
        } else {
            // Adds extra health potion if you are not a mage.
            items.add(new Potion(HEALTH_POTION, 2, Potion.PotionType.HEALTH_POTION));

            // Based on player level, adds Sword with different damage.
            if (player.getLevel() <= 10) {
                items.add(new Weapon
                        (SWORD, SWORD_WEIGHT, WEAPON_DMG_LVL_10, Weapon.WeaponType.SWORD));
            } else if (player.getLevel() > 10 && player.getLevel() <= 20) {
                items.add(new Weapon
                        (SWORD, SWORD_WEIGHT, WEAPON_DMG_LVL_20, Weapon.WeaponType.SWORD));
            } else if (player.getLevel() > 20 && player.getLevel() <= 30) {
                items.add(new Weapon
                        (SWORD, SWORD_WEIGHT, WEAPON_DMG_LVL_30, Weapon.WeaponType.SWORD));
            } else if (player.getLevel() > 30 && player.getLevel() <= 40) {
                items.add(new Weapon
                        (SWORD, SWORD_WEIGHT, WEAPON_DMG_LVL_40, Weapon.WeaponType.SWORD));
            } else if (player.getLevel() > 40 && player.getLevel() <= 50) {
                items.add(new Weapon
                        (SWORD, SWORD_WEIGHT, WEAPON_DMG_LVL_50, Weapon.WeaponType.SWORD));
            } else if (player.getLevel() > 50 && player.getLevel() <= 60) {
                items.add(new Weapon
                        (SWORD, SWORD_WEIGHT, WEAPON_DMG_LVL_60, Weapon.WeaponType.SWORD));
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
