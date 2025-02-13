package com.zenyte.game.packet.out;

import com.zenyte.game.packet.GamePacketEncoder;
import com.zenyte.game.world.entity.player.LogLevel;
import com.zenyte.game.world.entity.player.Player;
import com.zenyte.net.game.ServerProt;
import com.zenyte.net.game.packet.GamePacketOut;
import org.jetbrains.annotations.NotNull;

/**
 * @author Tommeh | 28 jul. 2018 | 19:07:03
 * @see <a href="https://www.rune-server.ee/members/tommeh/">Rune-Server profile</a>}
 */
public final class VarpLarge implements GamePacketEncoder {

    private final int config;
    private final int value;

    @Override
    public void log(@NotNull final Player player) {
        this.log(player, "Varp: " + config + ", value: " + value);
    }

    public VarpLarge(int config, int value) {
        this.config = config;
        this.value = value;
    }

    @Override
    public GamePacketOut encode() {
        final GamePacketOut buffer = ServerProt.VARP_LARGE.gamePacketOut();
        buffer.writeShort(config);
        buffer.writeIntLE(value);
        return buffer;
    }

    @Override
    public LogLevel level() {
        return LogLevel.LOW_PACKET;
    }

}
