package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Msg extends Command {
	CTBBCCrossChat plugin = CTBBCCrossChat.getInstance();
	String name;

	public Msg(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		String prefix = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "CTB"
				+ ChatColor.GRAY + "]" + ChatColor.RESET + " ";

		if (args.length > 2) {
			sender.sendMessage(prefix + "Usage: /msg <player> <message>");
		} else {
			StringBuilder builder = new StringBuilder();

			String rec = args[0];

			args[0] = "";

			for (String s : args) {
				builder.append(ChatColor.translateAlternateColorCodes('&', s));
				builder.append(" ");
			}

			String message = builder.substring(0, builder.length() - 1);

			ProxiedPlayer recppl = ProxyServer.getInstance().getPlayer(rec);
			recppl.sendMessage(ChatColor.GOLD + "[" + ChatColor.WHITE + sender
					+ ChatColor.GOLD + " -> me] " + ChatColor.RESET + message);

		}

	}
}
