package com.zenyte.net

import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext

/**
 * @author Tommeh | 27 jul. 2018 | 19:10:00
 * @author Jire
 */
enum class ClientResponse(val id: Int) {

    SUCCESSFUL(0),
    DISPLAY_ADVERTISEMENT(1),
    LOGIN_OK(2),
    INVALID_USERNAME_OR_PASSWORD(3),
    BANNED(4),
    ALREADY_ONLINE(5),
    SERVER_UPDATED(6),
    WORLD_FULL(7),
    LOGIN_SERVER_OFFLINE(8),
    TOO_MANY_CONNECTIONS(9),
    BAD_SESSION_ID(10),
    CREDENTIALS_UNSECURE(11),
    MEMBERS_WORLD(12),
    LOGIN_INCOMPLETE(13),
    UPDATE_IN_PROGRESS(14),
    RECONNECT_OK(15), // skip ISAAC/modlevel/playerindex etc. - just send player info
    LOGIN_EXCEEDED(16),
    IN_MEMBERS_AREA(17),
    ACCOUNT_LOCKED(18),
    CLOSED_BETA(19),
    INVALID_LOGIN_SERVER_REQUEST(20),
    JUST_LEFT_WORLD(21),
    MALFORMED_LOGIN_PACKET(22),
    NO_REPLY_FROM_LOGINSERVER(23),
    ERROR_LOADING_PROFILE(24),
    UNEXPECTED_LOGINSERVER_RESPONSE(25),
    COMPUTER_ADDRESS_BLOCKED(26),
    SERVICE_UNAVAILABLE(27),
    CUSTOM_LOGIN_MESSAGE(29), // var short packet, 3 strings of the custom login lines
    MUST_SET_DISPLAYNAME(31),
    ACCOUNT_BILLING_ISSUE(32),
    ACCOUNT_INACCESSIBLE(37),
    MUST_VOTE_FIRST(38),
    CLIENT_UPDATED(39),
    ACCOUNT_DOES_NOT_EXIST(40),
    ACCOUNT_INELIGIBLE_PRIVACY_POLICY(55),
    PROMPT_AUTHENTICATOR(56),
    WRONG_AUTHENICATOR_CODE(57),
    PROMPT_DATE_OF_BIRTH(61),
    LOGIN_ATTEMPT_TIMED_OUT(62),
    YOU_WERE_SIGNED_OUT(63),
    PROOF_OF_WORK_OK(64),
    FAILED_TO_LOGIN_TRY_AGAIN(65),
    FAILED_TO_LOGIN_TRY_AGAIN_2(67),
    MOBILE_CLIENT_UPDATED(68),
    PROOF_OF_WORK(69),
    PROBLEM_UPDATING_DATE_OF_BIRTH(71),
    OPEN_DATE_OF_BIRTH_WEBSITE(72),
    DATE_OF_BIRTH_NEEDS_REVIEW(73);

    fun writeAndClose(ctx: ChannelHandlerContext) {
        ctx.writeAndFlush(
            ctx.alloc().buffer(1, 1).writeByte(id)
        ).addListener(ChannelFutureListener.CLOSE)
    }

}
