package inte.grupp5.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getNameTest() {
        Item item = new Item("Potion of health");
        assertEquals("Potion of health", item.getName());
    }
}