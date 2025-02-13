package com.zenyte.game.packet.in.decoder;

import com.zenyte.game.packet.ClientProtDecoder;
import com.zenyte.game.packet.in.event.EventMouseIdleEvent;
import com.zenyte.net.io.RSBuffer;

/**
 * @author Tommeh | 28 jul. 2018 | 19:55:49
 * @see <a href="https://www.rune-server.ee/members/tommeh/">Rune-Server profile</a>}
 */
public class EventMouseIdleDecoder implements ClientProtDecoder<EventMouseIdleEvent> {

	@Override
	public EventMouseIdleEvent decode(int opcode, RSBuffer buffer) {
		return new EventMouseIdleEvent();
	}
}
