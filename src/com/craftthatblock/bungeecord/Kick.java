package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Kick extends Command {
	String name;

	public Kick(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		// Maybe add a reason? If you want that, tell it to me, I could add it
		String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "CTB"
				+ ChatColor.GRAY + "]" + ChatColor.RESET + " ";
		if (sender.hasPermission("chat.kick") || sender.hasPermission("chat.*")) {
			if (sender instanceof ProxiedPlayer) {
				if (args.length == 1) {
					ProxiedPlayer p = ProxyServer.getInstance().getPlayer(
							args[0]);

					if (p != null) {
						p.disconnect(ChatColor.RED + "Disconnected.");
					} else {
						sender.sendMessage(prefix + "Could not find player "
								+ args[0]);
					}
				} else {
					sender.sendMessage(prefix + "Usage: /kick <player>");
				}
			} else {

			}
		} else {
			// If player has no permission.
		}
	}
}
