// Copyright (c) 2014, Christopher "blay09" Baker
// All rights reserved.
package net.blay09.mods.eirairc.api.event;


import net.blay09.mods.eirairc.api.irc.IRCChannel;
import net.blay09.mods.eirairc.api.irc.IRCConnection;
import net.blay09.mods.eirairc.api.irc.IRCMessage;
import net.blay09.mods.eirairc.api.irc.IRCUser;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * This event is published on the MinecraftForge.EVENTBUS bus whenever a message was sent to an IRC channel EiraIRC is in.
 * If this event is cancelled, EiraIRC will not post the message in chat.
 */
@Cancelable
public class IRCChannelChatEvent extends IRCEvent {

	/**
	 * the channel this IRC message came from
	 */
	public final IRCChannel channel;

	/**
	 * the user that sent this IRC message
	 */
	public final IRCUser sender;

	/**
	 * the raw IRC message that was sent
	 */
	public IRCMessage rawMessage;

	/**
	 * the message that was sent
	 */
	public final String message;

	/**
	 * true, if this message is an emote
	 */
	public final boolean isEmote;

	/**
	 * true, fi this message was sent as a NOTICE
	 */
	public final boolean isNotice;

	/**
	 * INTERNAL EVENT. YOU SHOULD NOT POST THIS YOURSELF.
	 * @param connection the connection this IRC message came from
	 * @param channel the channel this IRC message came from
	 * @param sender the user that sent this IRC message
	 * @param rawMessage the raw IRC message that was sent
	 * @param message the message that was sent
	 * @param isEmote true, if this message is an emote
	 * @param isNotice true, if this message was sent as a NOTICE
	 */
	public IRCChannelChatEvent(IRCConnection connection, IRCChannel channel, IRCUser sender, IRCMessage rawMessage, String message, boolean isEmote, boolean isNotice) {
		super(connection);
		this.channel = channel;
		this.sender = sender;
		this.rawMessage = rawMessage;
		this.message = message;
		this.isEmote = isEmote;
		this.isNotice = isNotice;
	}
}
