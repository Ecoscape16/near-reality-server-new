package com.zenyte.game.packet.out;

import com.near_reality.game.packet.out.chat_channel.ChatChannelType;
import com.zenyte.game.packet.GamePacketEncoder;
import com.zenyte.game.util.Utils;
import com.zenyte.game.world.entity.masks.ChatMessage;
import com.zenyte.game.world.entity.player.LogLevel;
import com.zenyte.game.world.entity.player.Player;
import com.zenyte.net.game.ServerProt;
import com.zenyte.net.game.packet.GamePacketOut;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

public final class MessageClanChannel implements GamePacketEncoder {

    private final ChatChannelType type;
    private final String sender;
    private final ChatMessage message;

    @Override
    public void log(@NotNull final Player player) {
        log(player, "Type: " + type + ", Sender: " + sender + ", message: " + message.getChatText());
    }

    public MessageClanChannel(ChatChannelType type, String sender, ChatMessage message) {
        this.type = type;
        this.sender = sender;
        message.retain();
        this.message = message;
    }

    @Override
    public GamePacketOut encode() {
        try (message) {
            final GamePacketOut buffer = ServerProt.MESSAGE_CLANCHANNEL.gamePacketOut();
            buffer.writeByte(type.getPacketIdentifier());
            buffer.writeString(sender);
            for (int i = 0; i < 5; i++) {
                buffer.writeByte(Utils.random(255));
            }
            buffer.writeByte(0);
            final ByteBuf huffmanBuf = message.content();
            buffer.writeBytes(huffmanBuf, 0, huffmanBuf.readableBytes());
            return buffer;
        }
    }

    @Override
    public LogLevel level() {
        return LogLevel.HIGH_PACKET;
    }

}
