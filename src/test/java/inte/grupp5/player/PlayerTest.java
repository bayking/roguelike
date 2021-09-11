package inte.grupp5.player;

import inte.grupp5.item.Armor;
import inte.grupp5.item.Gear;
import inte.grupp5.player.classes.Mage;
import inte.grupp5.player.classes.Paladin;
import inte.grupp5.player.spell.InvokeMana;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final String[] lightArmorNames = {"Light armor", "Leather armor", "Fur armor"};

    Player player = new Player("Tester", new Mage("mage"), 1);

    @Test
    void playerTakesDamage() {
        player.takeDamage(50);
        assertEquals(50,player.getCurrentHealthPoints());
    }

    @Test
    void playerTakesDamageSetsToZeroIfDamageToHigh () {
        player.takeDamage(101);
        assertEquals(0,player.getCurrentHealthPoints());
    }

    @Test
    void playerTakesDamageThrowsIfDamageNegative () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.takeDamage(-100));
    }

    @Test
    void getItemsSizeReturnsCorrectSize () {
        assertEquals(5,player.getItemsSize());
    }

    @Test
    void getItemReturnsItem () {
        assertTrue(Arrays.asList(lightArmorNames).contains(player.getItem(4).getName()));
        //assertEquals("Light armor",player.getItem(4).getName());
    }

    @Test
    void getItemThrowsIfLessThanZero () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.getItem(-1));
    }
    @Test
    void getItemThrowsIfMoreThanSize () {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> player.getItem(10));
    }

    @Test
    void playerHasItemsWhenCreated() {
        assertEquals(5,player.getItemsSize());
    }

    @Test
    void setCurrentHealthPointsZero() {
        player.setCurrentHealthPoints(0);
        assertEquals(0, player.getCurrentHealthPoints());
    }

    @Test
    void setCurrentHealthPointsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setCurrentHealthPoints(-1));
    }

    @Test
    void setCurrentHealthPointsOverMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setCurrentHealthPoints(player.getMaxHealthPoints()+1));
    }
    @Test
    void setCurrentHealthPointsMax() {
        player.setCurrentHealthPoints(player.getMaxHealthPoints());
        assertEquals(player.getMaxHealthPoints(), player.getCurrentHealthPoints());
    }


    @Test
    void setCurrentManaPointsZero() {
        player.setCurrentManaPoints(0);
        assertEquals(0, player.getCurrentManaPoints());
    }

    @Test
    void setCurrentManaPointsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setCurrentManaPoints(-1));
    }

    @Test
    void setCurrentManaPointsOverMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setCurrentManaPoints(player.getMaxManaPoints()+1));
    }
    @Test
    void setCurrentManaPointsMax() {
        player.setCurrentManaPoints(player.getMaxManaPoints());
        assertEquals(player.getMaxManaPoints(), player.getCurrentManaPoints());
    }

    @Test
    void healHealthIsFull() {
        player.heal(20);
        assertEquals(100, player.getCurrentHealthPoints());
        assertFalse(player.heal(20));
    }

    @Test
    void healHasManaAndLowHP() {
        player.setCurrentHealthPoints(10);
        assertTrue(player.heal(20));
        assertEquals(30, player.getCurrentHealthPoints());
    }

    @Test
    void healHasManaButCloseToMaxHP() {
        player.setCurrentHealthPoints(player.getMaxHealthPoints()-8);
        assertTrue(player.heal(20));
        assertEquals(player.getMaxHealthPoints(), player.getCurrentHealthPoints());
    }

    @Test
    void setLevelZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setLevel(0));
    }

    @Test
    void setLevelNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setLevel(-1));
    }
    @Test
    void setLevelOver60() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setLevel(61));
    }
    @Test
    void setLevelInRange() {
        player.setLevel(35);
        assertEquals(35, player.getLevel());
    }

    @Test
    void hasManaForSpellZero() {
        assertTrue(player.hasManaForSpell(0));
    }

    @Test
    void hasManaForSpellNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.hasManaForSpell(-1));
    }

    @Test
    void hasManaForSpellMoreThanCurrentMana() {
        assertFalse(player.hasManaForSpell(player.getCurrentManaPoints() + 1));
    }

    @Test
    void hasManaForSpell() {
        assertTrue(player.hasManaForSpell(1));
    }

    @Test
    void getName() {
        String expected = "Tester";
        assertEquals(expected, player.getName());
    }

    @Test
    void setNameUnderRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setName("ab"));
    }

    @Test
    void setNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setName(""));
    }

    @Test
    void setNameInRange() {
        String expected = "Tester";
        player.setName(expected);
        assertEquals(expected, player.getName());
    }

    @Test
    void setNameAboveRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setName("123456789123456789123456789123456789"));
    }

    @Test
    void getKlass() {
        Mage mage = new Mage("mage");
        assertEquals(mage, player.getKlass());
    }

    @Test
    void getMaxHealthPoints() {
        assertEquals(100, player.getMaxHealthPoints());
    }

    @Test
    void getMaxManaPoints() {
        assertEquals(100, player.getMaxManaPoints());
    }


    @Test
    void setMaxHealthPointsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setMaxHealthPoints(0));
    }

    @Test
    void setMaxHealthPointsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setMaxHealthPoints(-1));
    }

    @Test
    void setMaxHealthPointsPositive() {
        player.setMaxHealthPoints(30000);
        assertEquals(30000, player.getMaxHealthPoints());
    }

    @Test
    void setMaxManaPointsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setMaxManaPoints(0));
    }

    @Test
    void setMaxManaPointsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.setMaxManaPoints(-1));
    }

    @Test
    void setMaxManaPointsPositive() {
        player.setMaxManaPoints(30000);
        assertEquals(30000, player.getMaxManaPoints());
    }

    @Test
    void castSpell() {
        Player caster = new Player("caster", new Mage("mage"), 10);
        InvokeMana invokeMana = new InvokeMana();
        caster.setCurrentManaPoints(5);
        assertTrue(caster.castSpell(invokeMana));
        assertEquals(caster.getCurrentManaPoints(), caster.getMaxManaPoints());
    }

    @Test
    void constructPlayer1() {
        Mage mage = new Mage("mage");
        Player player = new Player("Trollkarl",mage, 25);
        assertEquals(25, player.getLevel());
        assertEquals("Trollkarl", player.getName());
        assertEquals(mage, player.getKlass());
        assertEquals(2500, player.getCurrentHealthPoints());
        assertEquals(2500, player.getCurrentManaPoints());
        assertEquals(2500, player.getMaxManaPoints());
        assertEquals(2500, player.getMaxHealthPoints());
    }

    @Test
    void constructPlayer2() {
        Paladin paladin = new Paladin("paladin");
        Player player = new Player("Helig Man", paladin, 35);
        assertEquals(35, player.getLevel());
        assertEquals("Helig Man", player.getName());
        assertEquals(paladin, player.getKlass());
        assertEquals(3600, player.getCurrentHealthPoints());
        assertEquals(3480, player.getCurrentManaPoints());
        assertEquals(3480, player.getMaxManaPoints());
        assertEquals(3600, player.getMaxHealthPoints());
    }

    @Test
    void constructPlayer3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player("", new Mage("mage"), 20);
        });
    }

    @Test
    void constructPlayer4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player("ty", new Mage("mage"), 20);
        });
    }

    @Test
    void constructPlayer5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player("Wolfeschlegelsteinhausenbergerdorff", new Paladin("paladin"), 15);
        });
    }

    @Test
    void constructPlayer6() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player("Mustafa", new Mage("mage"), -4);
        });
    }

    @Test
    void constructPlayer7() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player("Tester", new Paladin("Paladin"), 61);
        });
    }

    @Test
    void queuingEnchantmentOnArmorWithNoEnchantmentThrowsISE() {
        Paladin PALADIN = new Paladin("Paladin");
        Player p1 = new Player("Player", PALADIN, 1);
        Assertions.assertThrows(IllegalStateException.class, () ->
                p1.queueEnchantment(new Armor("Gear", 1, 1, Armor.ArmorType.LIGHT_ARMOR, Gear.Enchantment.NONE)));
    }

}