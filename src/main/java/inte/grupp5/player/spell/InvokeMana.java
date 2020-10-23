package inte.grupp5.player.spell;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Mage;


// A spell only usable by level 10 mages. Refills mana.
public class InvokeMana extends Spell{
    public InvokeMana() {
        manaCost = 0;
        lvlReq = 10;
        id = 1;
    }

    @Override
    public boolean cast(Player caster, Player target) {
        if (caster.getKlass() instanceof Mage && caster.getLevel() >= 10) {
            target.setCurrentManaPoints(target.getMaxManaPoints());
            return true;
        }
        return false;
    }

    @Override
    public boolean cast(Player caster) {
        if (caster.getKlass() instanceof Mage && caster.getLevel() >= 10) {
            caster.setCurrentManaPoints(caster.getMaxManaPoints());
            return true;
        }
        return false;
    }
}
