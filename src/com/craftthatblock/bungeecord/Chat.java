package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;

import com.google.common.eventbus.Subscribe;

public class Chat implements Listener {

	@Subscribe
	public void onChat(ChatEvent e) {
		String m = e.getMessage();

		if (e.getSender() instanceof ProxiedPlayer) {
			if (m.startsWith("#")) {

				// Enter code to remove #

				m = m.replaceFirst("#", "");

				ProxiedPlayer pl = (ProxiedPlayer) e.getSender();

				String msg;
				String player = CTBBCCrossChat.getName(pl);

				if (pl.hasPermission("chat.owner")) {
					String m1 = CTBBCCrossChat.colorize(m);
					msg = (ChatColor.GRAY + "[" + ChatColor.AQUA + "Owner"
							+ ChatColor.GRAY + "]" + ChatColor.GOLD + player
							+ ChatColor.DARK_AQUA + "> " + ChatColor.RESET
							+ ChatColor.YELLOW + m1);
				} else if (pl.hasPermission("chat.admin")) {
					String m1 = CTBBCCrossChat.colorize(m);
					msg = (ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Admin"
							+ ChatColor.GRAY + "]" + ChatColor.GOLD + player
							+ ChatColor.DARK_AQUA + "> " + ChatColor.RESET
							+ ChatColor.WHITE + m1);

				} else if (pl.hasPermission("chat.mod")) {
					msg = (ChatColor.GRAY + "[" + ChatColor.RED + "Mod"
							+ ChatColor.GRAY + "]" + ChatColor.YELLOW + player
							+ ChatColor.DARK_AQUA + "> " + ChatColor.RESET
							+ ChatColor.WHITE + m);

				} else if (pl.hasPermission("chat.cmod")) {
					msg = (ChatColor.GRAY + "[" + ChatColor.RED + "Chat-Mod"
							+ ChatColor.GRAY + "]" + ChatColor.YELLOW + player
							+ ChatColor.DARK_AQUA + "> " + ChatColor.RESET
							+ ChatColor.WHITE + m);
				}

				else if (pl.hasPermission("chat.minivip")) {
					msg = (ChatColor.GRAY + "[" + ChatColor.GREEN + "Mini-VIP"
							+ ChatColor.GRAY + "]" + ChatColor.DARK_GREEN
							+ player + ChatColor.DARK_AQUA + "> "
							+ ChatColor.RESET + ChatColor.WHITE + m);

				} else if (pl.hasPermission("chat.vip")) {
					msg = (ChatColor.GRAY + "[" + ChatColor.GREEN + "VIP"
							+ ChatColor.GRAY + "]" + ChatColor.DARK_GREEN
							+ player + ChatColor.DARK_AQUA + "> "
							+ ChatColor.RESET + ChatColor.WHITE + m);

				} else if (pl.hasPermission("chat.vip+")) {
					String m1 = CTBBCCrossChat.colorize(m);
					msg = (ChatColor.GRAY + "[" + ChatColor.GREEN + "VIP+"
							+ ChatColor.GRAY + "]" + ChatColor.DARK_GREEN
							+ player + ChatColor.DARK_AQUA + "> "
							+ ChatColor.RESET + ChatColor.WHITE + m1);

				} else if (pl.hasPermission("chat.premium")) {
					String m1 = CTBBCCrossChat.colorize(m);
					msg = (ChatColor.GRAY + "[" + ChatColor.YELLOW
							+ ChatColor.BOLD + "Premium" + ChatColor.RESET
							+ ChatColor.GRAY + "]" + ChatColor.GREEN + player
							+ ChatColor.DARK_AQUA + "> " + ChatColor.RESET
							+ ChatColor.WHITE + m1);

				}

				else {
					msg = (ChatColor.DARK_GRAY + player + ChatColor.DARK_AQUA
							+ "> " + ChatColor.RESET + ChatColor.GRAY + m);

				}

				msg = msg.replace("fuck", "****");
				msg = msg.replace("bitch", "*****");
				msg = msg.replace("nigger", "******");
				msg = msg.replace("ass", "***");
				msg = msg.replace("dick", "****");
				// msg.replace("fuck", "****");
				// msg.replace("fuck", "****");
				// msg.replace("fuck", "****");

				for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
					if (p.getServer().getInfo().getName() != pl.getServer()
							.getInfo().getName()) {

						p.sendMessage(ChatColor.RED + "#>" + ChatColor.RESET
								+ msg);
					}
				}
			}
		}
	}
}