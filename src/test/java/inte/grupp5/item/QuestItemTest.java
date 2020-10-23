package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestItemTest {

    QuestItem questItem = new QuestItem("Key", 2);

    @Test
    void nameMatches() {
        assertEquals("Key", questItem.getName());
    }

    @Test
    void toStringMatches() {
        assertEquals("[Name: Key, Weight: 2.00, Value: 100.00]", questItem.toString());
    }

}