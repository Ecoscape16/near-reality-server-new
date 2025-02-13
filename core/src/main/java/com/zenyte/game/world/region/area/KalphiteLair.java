package com.zenyte.game.world.region.area;

import com.zenyte.game.world.entity.player.Player;
import com.zenyte.game.world.region.PolygonRegionArea;
import com.zenyte.game.world.region.RSPolygon;

/**
 * @author Kris | 21/04/2019 14:18
 * @see <a href="https://www.rune-server.ee/members/kris/">Rune-Server profile</a>
 */
public class KalphiteLair extends PolygonRegionArea {
    @Override
    public RSPolygon[] polygons() {
        return new RSPolygon[] {
                new RSPolygon(new int[][]{
                        { 3456, 9536 },
                        { 3456, 9472 },
                        { 3520, 9472 },
                        { 3520, 9536 }
                })
        };
    }

    @Override
    public void enter(final Player player) {

    }

    @Override
    public void leave(final Player player, final boolean logout) {

    }

    @Override
    public String name() {
        return "Kalphite Lair";
    }
}
