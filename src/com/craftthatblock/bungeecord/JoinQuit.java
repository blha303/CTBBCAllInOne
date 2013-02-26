package com.craftthatblock.bungeecord;

import com.google.common.eventbus.Subscribe;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;

public class JoinQuit implements Listener {

	public static String loginMSG(String player) {

		ProxiedPlayer ppl = ProxyServer.getInstance().getPlayer(player);

		String loginmsg = (ChatColor.BLUE + "> + " + ChatColor.WHITE + player
				+ ChatColor.LIGHT_PURPLE + " joined " + ChatColor.WHITE
				+ ppl.getServer().getInfo().getName().toString()
				+ ChatColor.LIGHT_PURPLE + "!");

		return loginmsg;

	}

	public static String logoutMSG(String player) {
		String logoutmsg = (ChatColor.BLUE + "> - " + ChatColor.WHITE + player
				+ ChatColor.LIGHT_PURPLE + " left the server!");

		return logoutmsg;

	}

	@Subscribe
	public void onDisconnect(PlayerDisconnectEvent e) {
		String pl = e.getPlayer().getName().toString();

		CTBBCCrossChat.broadcast(logoutMSG(pl));
	}

	@Subscribe
	public void onConnect(LoginEvent e) {
		String pl = e.getConnection().getName().toString();

		CTBBCCrossChat.broadcast(loginMSG(pl));

	}

}
