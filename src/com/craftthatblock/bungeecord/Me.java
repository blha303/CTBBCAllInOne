package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Me extends Command {
	CTBBCCrossChat plugin = CTBBCCrossChat.getInstance();
	String name;

	public Me(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "CTB"
				+ ChatColor.GRAY + "]" + ChatColor.RESET + " ";
		if (sender.hasPermission("chat.me") || sender.hasPermission("chat.*")) {
			if (sender instanceof ProxiedPlayer) {
				if (args.length == 0) {
					sender.sendMessage(prefix + "Usage: /me <message>");
				} else {
					StringBuilder builder = new StringBuilder();

					for (String s : args) {
						builder.append(ChatColor.translateAlternateColorCodes(
								'&', s));
						builder.append(" ");
					}

					String message = builder.substring(0, builder.length() - 1);
					for (ProxiedPlayer player : ProxyServer.getInstance()
							.getPlayers()) {
						player.sendMessage(ChatColor.LIGHT_PURPLE
								+ sender.getName().toString() + " "
								+ ChatColor.RESET + message);
					}
				}
			} else {

			}
		} else {
			// If player has no permission.
		}
	}
}
