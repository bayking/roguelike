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
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 5, Weapon type: STAFF]", LEVEL_5_MAGE_CHEST.getItems().get(3).toString());
        // TODO: Workaround to check damage, since value is calculated by adding damage and weight.
        assertEquals(8, LEVEL_5_MAGE_CHEST.getItems().get(3).getValue());


        LEVEL_15_MAGE_CHEST.generateItems(LEVEL_15_MAGE);
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 10, Weapon type: STAFF]", LEVEL_15_MAGE_CHEST.getItems().get(3).toString());

        LEVEL_25_MAGE_CHEST.generateItems(LEVEL_25_MAGE);
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 20, Weapon type: STAFF]", LEVEL_25_MAGE_CHEST.getItems().get(3).toString());

        LEVEL_35_MAGE_CHEST.generateItems(LEVEL_35_MAGE);
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 30, Weapon type: STAFF]", LEVEL_35_MAGE_CHEST.getItems().get(3).toString());

        LEVEL_45_MAGE_CHEST.generateItems(LEVEL_45_MAGE);
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 40, Weapon type: STAFF]", LEVEL_45_MAGE_CHEST.getItems().get(3).toString());

        LEVEL_55_MAGE_CHEST.generateItems(LEVEL_55_MAGE);
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 50, Weapon type: STAFF]", LEVEL_55_MAGE_CHEST.getItems().get(3).toString());

        LEVEL_60_MAGE_CHEST.generateItems(LEVEL_60_MAGE);
        assertEquals("[Name: Staff, Weight: 3.00, Damage: 60, Weapon type: STAFF]", LEVEL_60_MAGE_CHEST.getItems().get(3).toString());
    }

    @Test
    void generatedChestHas4ItemsForMages() {
        LEVEL_25_MAGE_CHEST.generateItems(LEVEL_25_MAGE);
        assertEquals(4, LEVEL_25_MAGE_CHEST.getItems().size());
    }
}
