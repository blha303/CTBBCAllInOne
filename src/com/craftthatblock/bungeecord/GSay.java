package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GSay extends Command {
	CTBBCCrossChat plugin = CTBBCCrossChat.getInstance();
	String name;

	public GSay(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		String prefix = CTBBCCrossChat.prefix;
		
		if (sender.hasPermission("chat.gsay") || sender.hasPermission("chat.*")) {

			if (args.length == 0) {
				sender.sendMessage(prefix + "Usage: /gsay <message>");
			} else {
				StringBuilder builder = new StringBuilder();

				for (String s : args) {
					builder.append(ChatColor.translateAlternateColorCodes('&',
							s));
					builder.append(" ");
				}

				String message = builder.substring(0, builder.length() - 1);

				String msg;
				if (message.startsWith("&h")) {
					message.replaceFirst("&h", "");
					msg = message;
				} else {
					msg = prefix + message;
				}

				for (ProxiedPlayer player : ProxyServer.getInstance()
						.getPlayers()) {
					player.sendMessage(msg);
				}
			}

		} else {
			// If player has no permission.
		}
	}
}
