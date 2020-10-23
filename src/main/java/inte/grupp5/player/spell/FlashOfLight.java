package inte.grupp5.player.spell;

import inte.grupp5.player.Player;
import inte.grupp5.player.classes.Paladin;

//A spell only usable by paladins. Heals for 50HP.
public class FlashOfLight extends Spell{
    public FlashOfLight() {
        manaCost = 25;
        lvlReq = 1;
        id = 2;
    }

    @Override
    public boolean cast(Player caster) {
        if (caster.getKlass() instanceof Paladin && caster.getLevel() >= 1 && caster.hasManaForSpell(manaCost)) {
            if (caster.heal(50)) {
                caster.setCurrentManaPoints(caster.getCurrentManaPoints()-25);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cast(Player caster, Player target) {
        if (caster.getKlass() instanceof Paladin && caster.getLevel() >= 1 && caster.hasManaForSpell(manaCost)) {
            if (target.heal(50)) {
                caster.setCurrentManaPoints(caster.getCurrentManaPoints()-25);
                return true;
            }
        }
        return false;
    }
}
