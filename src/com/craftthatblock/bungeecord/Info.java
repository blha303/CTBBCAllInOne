package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Info extends Command {
	String name;

	public Info(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		// Maybe add a reason? If you want that, tell it to me, I could add it
		String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "CTB"
				+ ChatColor.GRAY + "]" + ChatColor.RESET + " ";
		if (sender.hasPermission("chat.info") || sender.hasPermission("chat.*")) {
			// if (sender instanceof ProxiedPlayer) {
			if (args.length == 1) {
				ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);

				if (p != null) {

					sender.sendMessage(ChatColor.BLUE + "Info about "
							+ p.getName().toString() + ":");
					sender.sendMessage("IP: " + p.getAddress().toString());
					sender.sendMessage("Server: "
							+ p.getServer().getInfo().getName().toString());
					sender.sendMessage("Ping: " + p.getPing());

				} else {
					sender.sendMessage(prefix + "Could not find player "
							+ args[0]);
				}
			} else {
				sender.sendMessage(prefix + "Usage: /info <player>");
			}
			// } else {
			//
			// }
		} else {
			// If player has no permission.
		}
	}
}
