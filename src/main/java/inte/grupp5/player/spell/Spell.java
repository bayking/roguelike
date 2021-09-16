package inte.grupp5.player.spell;

import inte.grupp5.player.Player;

import java.util.Objects;

public abstract class Spell {
    protected int manaCost, lvlReq;
    protected int id;

    public int getManaCost() {
        return manaCost;
    }

    public int getLvlReq() {
        return lvlReq;
    }

    public int getId() {
        return id;
    }

    public abstract boolean cast(Player caster);

    public abstract boolean cast(Player caster, Player target);

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Spell))
            return false;
        Spell other = (Spell) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
