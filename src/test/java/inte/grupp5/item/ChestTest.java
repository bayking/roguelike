package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO: Since Player only has one Class (klass),
//  only chests for Mages can be tested.
public class ChestTest {

    Mage MAGE = new Mage("Gandalf");

    Player LEVEL_5_MAGE = new Player("Level 5", MAGE, 5);
    Player LEVEL_15_MAGE = new Player("Level 15", MAGE, 15);
    Player LEVEL_25_MAGE = new Player("Level 25", MAGE, 25);
    Player LEVEL_35_MAGE = new Player("Level 35", MAGE, 35);
    Player LEVEL_45_MAGE = new Player("Level 45", MAGE, 45);
    Player LEVEL_55_MAGE = new Player("Level 55", MAGE, 55);
    Player LEVEL_60_MAGE = new Player("Level 60", MAGE, 60);

    Chest LEVEL_5_MAGE_CHEST = new Chest();
    Chest LEVEL_15_MAGE_CHEST = new Chest();
    Chest LEVEL_25_MAGE_CHEST = new Chest();
    Chest LEVEL_35_MAGE_CHEST = new Chest();
    Chest LEVEL_45_MAGE_CHEST = new Chest();
    Chest LEVEL_55_MAGE_CHEST = new Chest();
    Chest LEVEL_60_MAGE_CHEST = new Chest();

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
    void generatedChestHas5Items() {
        LEVEL_25_MAGE_CHEST.generateItems(LEVEL_25_MAGE);
        assertEquals(5, LEVEL_25_MAGE_CHEST.getItems().size());
    }
}
