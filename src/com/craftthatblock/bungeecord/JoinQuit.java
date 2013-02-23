package com.craftthatblock.bungeecord;

import com.google.common.eventbus.Subscribe;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;

public class JoinQuit implements Listener {

	public static String loginMSG(String player) {
		String loginmsg = (ChatColor.AQUA + "+ " + ChatColor.LIGHT_PURPLE
				+ player + ChatColor.AQUA + " joined the server!");

		return loginmsg;

	}

	public static String logoutMSG(String player) {
		String logoutmsg = (ChatColor.AQUA + "- " + ChatColor.LIGHT_PURPLE
				+ player + ChatColor.AQUA + " left the server!");

		return logoutmsg;

	}

	@Subscribe
	public void onDisconnect(PlayerDisconnectEvent e) {
		ProxiedPlayer ppl = (ProxiedPlayer) e.getPlayer();
		String pl = CTBBCCrossChat.getName(ppl);

		// pl = ProxiedPlayer

		CTBBCCrossChat.broadcast(logoutMSG(pl));
	}

	@Subscribe
	public void onConnect(LoginEvent e) {

		String pl = e.getConnection().getName().toString();

		CTBBCCrossChat.broadcast(loginMSG(pl));

	}

}
