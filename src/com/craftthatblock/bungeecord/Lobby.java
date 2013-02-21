package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {
	CTBBCCrossChat plugin = CTBBCCrossChat.getInstance();
	String name;

	public Lobby(String name) {
		super(name);
		this.name = name;
	}

	String lobby = "Lobby";

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer) sender;

		if (!p.getServer().getInfo().getName().equals(lobby)) {
			if (ProxyServer.getInstance().getServers().containsKey(lobby)) {
				p.connect(ProxyServer.getInstance().getServerInfo(lobby));
			} else {
			}
		} else {
		}

	}
}
