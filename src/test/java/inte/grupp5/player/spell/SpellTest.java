package inte.grupp5.player.spell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SpellTest {
    InvokeMana invokeMana = new InvokeMana();

    @Test
    void getManaCost() {
        assertEquals(0, invokeMana.getManaCost());
    }

    @Test
    void getLvlReq() {
        assertEquals(10, invokeMana.getLvlReq());
    }

    @Test
    void getId() {
        assertEquals(1, invokeMana.getId());
    }

    @Test
    void testEqualsDifferentInstances() {
        InvokeMana mana = new InvokeMana();
        InvokeMana mana1 = new InvokeMana();
        assertEquals(mana1, mana);
    }

    @Test
    void testEqualsSameInstance() {
        InvokeMana mana = new InvokeMana();
        assertEquals(mana, mana);
    }

    @Test
    void testEqualsNotSameClassSameParent() {
        FlashOfLight flashOfLight = new FlashOfLight();
        InvokeMana invokeMana = new InvokeMana();
        assertFalse(invokeMana.equals(flashOfLight));
    }

    @Test
    void testEqualsNotSameClass() {
        String str = "str";
        InvokeMana invokeMana = new InvokeMana();
        assertFalse(invokeMana.equals(str));
    }

    @Test
    void testHashCode() {
        InvokeMana mana = new InvokeMana();
        InvokeMana mana1 = new InvokeMana();
        assertEquals(mana1.hashCode(), mana.hashCode());
    }
}