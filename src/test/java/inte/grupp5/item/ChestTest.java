package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ChestTest {

    Mage MAGE = new Mage("Gandalf");
    Paladin PALADIN = new Paladin("Paladin");

    Player LEVEL_5_MAGE = new Player("Level 5", MAGE, 5);
    Player LEVEL_15_MAGE = new Player("Level 15", MAGE, 15);
    Player LEVEL_25_MAGE = new Player("Level 25", MAGE, 25);
    Player LEVEL_35_MAGE = new Player("Level 35", MAGE, 35);
    Player LEVEL_45_MAGE = new Player("Level 45", MAGE, 45);
    Player LEVEL_55_MAGE = new Player("Level 55", MAGE, 55);
    Player LEVEL_60_MAGE = new Player("Level 60", MAGE, 60);

    Player LEVEL_5_PALADIN = new Player("Level 5", PALADIN, 5);
    Player LEVEL_15_PALADIN = new Player("Level 15", PALADIN, 15);
    Player LEVEL_25_PALADIN = new Player("Level 25", PALADIN, 25);
    Player LEVEL_35_PALADIN = new Player("Level 35", PALADIN, 35);
    Player LEVEL_45_PALADIN = new Player("Level 45", PALADIN, 45);
    Player LEVEL_55_PALADIN = new Player("Level 55", PALADIN, 55);
    Player LEVEL_60_PALADIN = new Player("Level 60", PALADIN, 60);

    Chest LEVEL_5_MAGE_CHEST = new Chest();
    Chest LEVEL_15_MAGE_CHEST = new Chest();
    Chest LEVEL_25_MAGE_CHEST = new Chest();
    Chest LEVEL_35_MAGE_CHEST = new Chest();
    Chest LEVEL_45_MAGE_CHEST = new Chest();
    Chest LEVEL_55_MAGE_CHEST = new Chest();
    Chest LEVEL_60_MAGE_CHEST = new Chest();

    Chest LEVEL_5_PALADIN_CHEST = new Chest();
    Chest LEVEL_15_PALADIN_CHEST = new Chest();
    Chest LEVEL_25_PALADIN_CHEST = new Chest();
    Chest LEVEL_35_PALADIN_CHEST = new Chest();
    Chest LEVEL_45_PALADIN_CHEST = new Chest();
    Chest LEVEL_55_PALADIN_CHEST = new Chest();
    Chest LEVEL_60_PALADIN_CHEST = new Chest();

    @Test
    void chestGeneratesWeaponWithDamageBasedOnLevelForMages() {
        LEVEL_5_MAGE_CHEST.generateItems(LEVEL_5_MAGE);
        Weapon LEVEL_5_MAGE_WEAPON = (Weapon) LEVEL_5_MAGE_CHEST.getItems().get(3);
        assertEquals(5, LEVEL_5_MAGE_WEAPON.getDamage());

        LEVEL_15_MAGE_CHEST.generateItems(LEVEL_15_MAGE);
        Weapon LEVEL_15_MAGE_WEAPON = (Weapon) LEVEL_15_MAGE_CHEST.getItems().get(3);
        assertEquals(10, LEVEL_15_MAGE_WEAPON.getDamage());

        LEVEL_25_MAGE_CHEST.generateItems(LEVEL_25_MAGE);
        Weapon LEVEL_25_MAGE_WEAPON = (Weapon) LEVEL_25_MAGE_CHEST.getItems().get(3);
        assertEquals(20, LEVEL_25_MAGE_WEAPON.getDamage());

        LEVEL_35_MAGE_CHEST.generateItems(LEVEL_35_MAGE);
        Weapon LEVEL_35_MAGE_WEAPON = (Weapon) LEVEL_35_MAGE_CHEST.getItems().get(3);
        assertEquals(30, LEVEL_35_MAGE_WEAPON.getDamage());

        LEVEL_45_MAGE_CHEST.generateItems(LEVEL_45_MAGE);
        Weapon LEVEL_45_MAGE_WEAPON = (Weapon) LEVEL_45_MAGE_CHEST.getItems().get(3);
        assertEquals(40, LEVEL_45_MAGE_WEAPON.getDamage());

        LEVEL_55_MAGE_CHEST.generateItems(LEVEL_55_MAGE);
        Weapon LEVEL_55_MAGE_WEAPON = (Weapon) LEVEL_55_MAGE_CHEST.getItems().get(3);
        assertEquals(50, LEVEL_55_MAGE_WEAPON.getDamage());

        LEVEL_60_MAGE_CHEST.generateItems(LEVEL_60_MAGE);
        Weapon LEVEL_60_MAGE_WEAPON = (Weapon) LEVEL_60_MAGE_CHEST.getItems().get(3);
        assertEquals(60, LEVEL_60_MAGE_WEAPON.getDamage());
    }

    @Test
    void chestGeneratesLightArmorWithArmorRatingBasedOnLevelForMages() {
        LEVEL_5_MAGE_CHEST.generateItems(LEVEL_5_MAGE);
        Armor LEVEL_5_MAGE_ARMOR = (Armor) LEVEL_5_MAGE_CHEST.getItems().get(4);
        assertEquals(5, LEVEL_5_MAGE_ARMOR.getArmorRating());

        LEVEL_15_MAGE_CHEST.generateItems(LEVEL_15_MAGE);
        Armor LEVEL_15_MAGE_ARMOR = (Armor) LEVEL_15_MAGE_CHEST.getItems().get(4);
        assertEquals(10, LEVEL_15_MAGE_ARMOR.getArmorRating());

        LEVEL_25_MAGE_CHEST.generateItems(LEVEL_25_MAGE);
        Armor LEVEL_25_MAGE_ARMOR = (Armor) LEVEL_25_MAGE_CHEST.getItems().get(4);
        assertEquals(20, LEVEL_25_MAGE_ARMOR.getArmorRating());

        LEVEL_35_MAGE_CHEST.generateItems(LEVEL_35_MAGE);
        Armor LEVEL_35_MAGE_ARMOR = (Armor) LEVEL_35_MAGE_CHEST.getItems().get(4);
        assertEquals(30, LEVEL_35_MAGE_ARMOR.getArmorRating());

        LEVEL_45_MAGE_CHEST.generateItems(LEVEL_45_MAGE);
        Armor LEVEL_45_MAGE_ARMOR = (Armor) LEVEL_45_MAGE_CHEST.getItems().get(4);
        assertEquals(40, LEVEL_45_MAGE_ARMOR.getArmorRating());

        LEVEL_55_MAGE_CHEST.generateItems(LEVEL_55_MAGE);
        Armor LEVEL_55_MAGE_ARMOR = (Armor) LEVEL_55_MAGE_CHEST.getItems().get(4);
        assertEquals(50, LEVEL_55_MAGE_ARMOR.getArmorRating());

        LEVEL_60_MAGE_CHEST.generateItems(LEVEL_60_MAGE);
        Armor LEVEL_60_MAGE_ARMOR = (Armor) LEVEL_60_MAGE_CHEST.getItems().get(4);
        assertEquals(60, LEVEL_60_MAGE_ARMOR.getArmorRating());
    }

    @Test
    void chestGeneratesWeaponWithDamageBasedOnLevelForPaladins() {
        LEVEL_5_PALADIN_CHEST.generateItems(LEVEL_5_PALADIN);
        Weapon LEVEL_5_PALADIN_WEAPON = (Weapon) LEVEL_5_PALADIN_CHEST.getItems().get(3);
        assertEquals(5, LEVEL_5_PALADIN_WEAPON.getDamage());

        LEVEL_15_PALADIN_CHEST.generateItems(LEVEL_15_PALADIN);
        Weapon LEVEL_15_PALADIN_WEAPON = (Weapon) LEVEL_15_PALADIN_CHEST.getItems().get(3);
        assertEquals(10, LEVEL_15_PALADIN_WEAPON.getDamage());

        LEVEL_25_PALADIN_CHEST.generateItems(LEVEL_25_PALADIN);
        Weapon LEVEL_25_PALADIN_WEAPON = (Weapon) LEVEL_25_PALADIN_CHEST.getItems().get(3);
        assertEquals(20, LEVEL_25_PALADIN_WEAPON.getDamage());

        LEVEL_35_PALADIN_CHEST.generateItems(LEVEL_35_PALADIN);
        Weapon LEVEL_35_PALADIN_WEAPON = (Weapon) LEVEL_35_PALADIN_CHEST.getItems().get(3);
        assertEquals(30, LEVEL_35_PALADIN_WEAPON.getDamage());

        LEVEL_45_PALADIN_CHEST.generateItems(LEVEL_45_PALADIN);
        Weapon LEVEL_45_PALADIN_WEAPON = (Weapon) LEVEL_45_PALADIN_CHEST.getItems().get(3);
        assertEquals(40, LEVEL_45_PALADIN_WEAPON.getDamage());

        LEVEL_55_PALADIN_CHEST.generateItems(LEVEL_55_PALADIN);
        Weapon LEVEL_55_PALADIN_WEAPON = (Weapon) LEVEL_55_PALADIN_CHEST.getItems().get(3);
        assertEquals(50, LEVEL_55_PALADIN_WEAPON.getDamage());

        LEVEL_60_PALADIN_CHEST.generateItems(LEVEL_60_PALADIN);
        Weapon LEVEL_60_PALADIN_WEAPON = (Weapon) LEVEL_60_PALADIN_CHEST.getItems().get(3);
        assertEquals(60, LEVEL_60_PALADIN_WEAPON.getDamage());
    }

    @Test
    void generatedChestHas5Items() {
        LEVEL_25_MAGE_CHEST.generateItems(LEVEL_25_MAGE);
        assertEquals(5, LEVEL_25_MAGE_CHEST.getItems().size());
    }

    @Test
    void methodOpenChestGeneratesItemsAndReturnsThemAsArrayList() {
        ArrayList<Item> testItems = new ArrayList<>();
        testItems.add(new Potion
                ("Health potion", 2, Potion.PotionType.HEALTH_POTION));
        testItems.add(new Potion
                ("Level potion", 1, Potion.PotionType.LEVEL_POTION));
        testItems.add(new Potion
                ("Mana potion", 2, Potion.PotionType.MANA_POTION));
        testItems.add(new Weapon
                ("Staff", 3, 5, Weapon.WeaponType.STAFF));
        testItems.add(new Armor
                ("Light armor", 7, 5, Armor.ArmorType.LIGHT_ARMOR));

        assertEquals(testItems.toString(), LEVEL_5_MAGE_CHEST.openChest(LEVEL_5_MAGE).toString());
    }
}
