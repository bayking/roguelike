package inte.grupp5.item;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ChestTest {

    private final String[] staffNames = {"Staff", "Staff of storms", "Wabbajack"};
    private final String[] swordNames = {"Sword", "Sword of pain", "Sting"};
    private final String[] lightArmorNames = {"Light armor", "Leather armor", "Fur armor"};
    private final String[] heavyArmorNames = {"Heavy armor", "Steel armor", "Dragonplate armor"};
    private final String[] healthPotionNames = {"Health potion", "Draught of health", "Elixir of Health"};
    private final String[] levelPotionNames = {"Level potion", "Rare candy", "Draught of experience"};
    private final String[] manaPotionNames = {"Mana potion", "Elixir of mana"};

    final Mage MAGE = new Mage("Gandalf");
    final Paladin PALADIN = new Paladin("Paladin");

    final Player LEVEL_5_MAGE = new Player("Level 5", MAGE, 5);
    final Player LEVEL_15_MAGE = new Player("Level 15", MAGE, 15);
    final Player LEVEL_25_MAGE = new Player("Level 25", MAGE, 25);
    final Player LEVEL_35_MAGE = new Player("Level 35", MAGE, 35);
    final Player LEVEL_45_MAGE = new Player("Level 45", MAGE, 45);
    final Player LEVEL_55_MAGE = new Player("Level 55", MAGE, 55);
    final Player LEVEL_60_MAGE = new Player("Level 60", MAGE, 60);

    final Player LEVEL_5_PALADIN = new Player("Level 5", PALADIN, 5);
    final Player LEVEL_15_PALADIN = new Player("Level 15", PALADIN, 15);
    final Player LEVEL_25_PALADIN = new Player("Level 25", PALADIN, 25);
    final Player LEVEL_35_PALADIN = new Player("Level 35", PALADIN, 35);
    final Player LEVEL_45_PALADIN = new Player("Level 45", PALADIN, 45);
    final Player LEVEL_55_PALADIN = new Player("Level 55", PALADIN, 55);
    final Player LEVEL_60_PALADIN = new Player("Level 60", PALADIN, 60);

    final Chest LEVEL_5_MAGE_CHEST = new Chest();
    final Chest LEVEL_15_MAGE_CHEST = new Chest();
    final Chest LEVEL_25_MAGE_CHEST = new Chest();
    final Chest LEVEL_35_MAGE_CHEST = new Chest();
    final Chest LEVEL_45_MAGE_CHEST = new Chest();
    final Chest LEVEL_55_MAGE_CHEST = new Chest();
    final Chest LEVEL_60_MAGE_CHEST = new Chest();

    final Chest LEVEL_5_PALADIN_CHEST = new Chest();
    final Chest LEVEL_15_PALADIN_CHEST = new Chest();
    final Chest LEVEL_25_PALADIN_CHEST = new Chest();
    final Chest LEVEL_35_PALADIN_CHEST = new Chest();
    final Chest LEVEL_45_PALADIN_CHEST = new Chest();
    final Chest LEVEL_55_PALADIN_CHEST = new Chest();
    final Chest LEVEL_60_PALADIN_CHEST = new Chest();

    final Potion HEALTH_POTION = new Potion("Health potion", 2, Potion.PotionType.HEALTH_POTION);
    final Potion LEVEL_POTION = new Potion("Level potion", 1, Potion.PotionType.LEVEL_POTION);
    final Potion MANA_POTION = new Potion("Mana potion", 2, Potion.PotionType.MANA_POTION);

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
    @DisplayName("openChest() generates items and returns them as ArrayList")
    void methodOpenChestGeneratesItemsAndReturnsThemAsArrayList() {
        ArrayList<Item> testItems = new ArrayList<>();
        testItems.add(HEALTH_POTION);
        testItems.add(LEVEL_POTION);
        testItems.add(MANA_POTION);
        testItems.add(new Weapon
                ("Staff", 3, 5, Weapon.WeaponType.STAFF));
        testItems.add(new Armor
                ("Light armor", 7, 5, Armor.ArmorType.LIGHT_ARMOR));

        assertEquals(testItems.toString(), LEVEL_5_MAGE_CHEST.openChest(LEVEL_5_MAGE).toString());
    }

    @ParameterizedTest
    @CsvSource({
            "6, 5, 5", "11, 10, 10", "21, 20, 20", "31, 30, 30", "41, 40, 40",
            "51, 50, 50", "60 , 60, 60"
    })
    void openChestMethodReadsItemsFromMageCsvSource(int level, int damage, int armorRating) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(HEALTH_POTION);
        items.add(LEVEL_POTION);
        items.add(MANA_POTION);
        items.add(new Weapon("Staff", 3, damage, Weapon.WeaponType.STAFF));
        items.add(new Armor("Light armor", 7, armorRating, Armor.ArmorType.LIGHT_ARMOR));

        assertEquals(items.toString(), new Chest().openChest(new Player("Mage", MAGE, level)).toString());
    }

    @ParameterizedTest
    @CsvSource({
            "6, 5, 10", "11, 10, 20", "21, 20, 30", "31, 30, 40", "41, 40, 50",
            "51, 50, 60", "60 , 60, 70"
    })
    void openChestMethodReadsItemsFromPaladinCsvSource(int level, int damage, int armorRating) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(HEALTH_POTION);
        items.add(LEVEL_POTION);
        items.add(HEALTH_POTION);
        items.add(new Weapon("Sword", 5, damage, Weapon.WeaponType.SWORD));
        items.add(new Armor("Heavy armor", 10, armorRating, Armor.ArmorType.HEAVY_ARMOR));

        assertEquals(items.toString(), new Chest().openChest(new Player("Paladin", PALADIN, level)).toString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/MageChestGeneratorTest.csv")
    void openChestMethodCreatesCSVFileBasedOnClassAndLevel(int level, int damage, int armorRating) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(HEALTH_POTION);
        items.add(LEVEL_POTION);
        items.add(HEALTH_POTION);
        items.add(new Weapon("Sword", 5, damage, Weapon.WeaponType.SWORD));
        items.add(new Armor("Heavy armor", 10, armorRating, Armor.ArmorType.HEAVY_ARMOR));

        assertEquals(items.toString(), new Chest().openChest(new Player("Paladin", PALADIN, level)).toString());
    }

    @RepeatedTest(value = 10)
    void generateChestForPaladin() {
        Player p1 = new Player("Paladin", PALADIN, 25);

        assertTrue(Arrays.asList(healthPotionNames).contains(p1.getItem(0).getName()));
        assertTrue(1 <= p1.getItem(0).getWeight() && p1.getItem(0).getWeight() <= 3);

        assertTrue(Arrays.asList(levelPotionNames).contains(p1.getItem(1).getName()));
        assertTrue(1 <= p1.getItem(1).getWeight() && p1.getItem(1).getWeight() <= 3);

        assertTrue(Arrays.asList(healthPotionNames).contains(p1.getItem(2).getName()));
        assertTrue(1 <= p1.getItem(2).getWeight() && p1.getItem(2).getWeight() <= 3);

        assertTrue(Arrays.asList(swordNames).contains(p1.getItem(3).getName()));
        assertTrue(7 <= p1.getItem(3).getWeight() && p1.getItem(3).getWeight() <= 16);

        assertTrue(Arrays.asList(heavyArmorNames).contains(p1.getItem(4).getName()));
        assertTrue(15 <= p1.getItem(4).getWeight() && p1.getItem(4).getWeight() <= 20);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5, 10, 20, 30, 40, 50, 60"
    })
    void generateChestForPaladinDifferentLevels(int level) {

        Chest c1 = new Chest();
        Player p1 = new Player("Paladin", PALADIN, level);
        //c1.openChestUpdated(p1);

        assertTrue(Arrays.asList(healthPotionNames).contains(p1.getItem(0).getName()));
        assertTrue(1 <= p1.getItem(0).getWeight() && p1.getItem(0).getWeight() <= 3);

        assertTrue(Arrays.asList(levelPotionNames).contains(p1.getItem(1).getName()));
        assertTrue(1 <= p1.getItem(1).getWeight() && p1.getItem(1).getWeight() <= 3);

        assertTrue(Arrays.asList(healthPotionNames).contains(p1.getItem(2).getName()));
        assertTrue(1 <= p1.getItem(2).getWeight() && p1.getItem(2).getWeight() <= 3);

        assertTrue(Arrays.asList(swordNames).contains(p1.getItem(3).getName()));
        assertTrue(7 <= p1.getItem(3).getWeight() && p1.getItem(3).getWeight() <= 16);

        assertTrue(Arrays.asList(heavyArmorNames).contains(p1.getItem(4).getName()));
        assertTrue(15 <= p1.getItem(4).getWeight() && p1.getItem(4).getWeight() <= 20);
    }

    @RepeatedTest(value = 1)
    void generateChestFromCsvFileForMage() {
        Chest c1 = new Chest();
        Player p1 = new Player("Mage", MAGE, 5);
        //c1.openChestUpdated(p1);
        assertEquals(p1.getItem(0).getName(), new Potion("Potion", 1, Potion.PotionType.HEALTH_POTION).getName());
        assertEquals(p1.getItem(0).getWeight(), new Potion("Potion", 1, Potion.PotionType.HEALTH_POTION).getWeight());
    }


}
