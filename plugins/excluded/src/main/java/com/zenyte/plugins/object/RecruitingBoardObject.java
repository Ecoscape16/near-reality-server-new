package com.zenyte.plugins.object;

import com.zenyte.game.content.chambersofxeric.party.RaidingPartiesInterface;
import com.zenyte.game.world.entity.player.Player;
import com.zenyte.game.world.object.ObjectAction;
import com.zenyte.game.world.object.ObjectId;
import com.zenyte.game.world.object.WorldObject;


public final class RecruitingBoardObject implements ObjectAction {

    @Override
    public void handleObjectAction(final Player player, final WorldObject object, final String name, final int optionId, final String option) {
        // Ensure the player is always aware of raid layouts
        player.addAttribute("aware of raids layouts", 1);

        // Refresh the Raiding Parties Interface
        RaidingPartiesInterface.refresh(player);
    }

    @Override
    public Object[] getObjects() {
        return new Object[] { ObjectId.RECRUITING_BOARD };
    }
}
