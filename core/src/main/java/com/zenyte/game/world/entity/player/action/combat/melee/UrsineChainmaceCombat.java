package com.zenyte.game.world.entity.player.action.combat.melee;

import com.zenyte.game.world.entity.Entity;
import com.zenyte.game.world.entity.npc.NPC;
import com.zenyte.game.world.entity.player.Player;
import com.zenyte.game.world.entity.player.action.combat.MeleeCombat;

public class UrsineChainmaceCombat extends MeleeCombat {
    public UrsineChainmaceCombat(Entity target) {
        super(target);
    }

    @Override
    public int getAccuracy(Player player, Entity target, double resultModifier) {
        int baseAccuracy = super.getAccuracy(player, target, resultModifier);
        if(player.getWeapon().getCharges() > 1 && target instanceof NPC && ((NPC) target).isInWilderness()) {
            return (int) (baseAccuracy * 1.5);
        }
        return baseAccuracy;
    }

    @Override
    public int getMaxHit(Player player, double passiveModifier, double activeModifier, boolean ignorePrayers) {
        int base = super.getMaxHit(player, passiveModifier, activeModifier, ignorePrayers);
        if(player.getWeapon().getCharges() > 1 && target instanceof NPC && ((NPC) target).isInWilderness()) {
            return (int) (base * 1.5);
        }
        return base;
    }
}
