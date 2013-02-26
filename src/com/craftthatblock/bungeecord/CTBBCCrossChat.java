package com.craftthatblock.bungeecord;

import java.net.InetSocketAddress;
import java.util.Collection;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class CTBBCCrossChat extends Plugin implements Listener {
	public static CTBBCCrossChat plugin;

	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager()
				.registerListener(new Chat());
		ProxyServer.getInstance().getPluginManager()
				.registerListener(new JoinQuit());
		ProxyServer.getInstance().getPluginManager()
				.registerCommand(new Kick("bckick"));
		ProxyServer.getInstance().getPluginManager()
				.registerCommand(new Lobby("lobby"));
		ProxyServer.getInstance().getPluginManager()
				.registerCommand(new Info("info"));
		ProxyServer.getInstance().getPluginManager()
				.registerCommand(new GSay("gsay"));
	}

	
	
	
	static String prefix = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "CTB"
			+ ChatColor.GRAY + "]" + ChatColor.RESET + " ";
	
	public static CTBBCCrossChat getInstance() {
		return plugin;
	}

	public static String getName(ProxiedPlayer player) {
		return player.getName().toString();
	}

	public InetSocketAddress getIP(ProxiedPlayer player) {
		return player.getAddress();
	}

	public void connect(ProxiedPlayer player, ServerInfo server) {
		player.connect(server);
	}

	public static ServerInfo getServerInfo(String server) {
		return ProxyServer.getInstance().getServerInfo(server);
	}

	public static String colorize(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	public static Collection<ProxiedPlayer> getPlayerList() {
		return ProxyServer.getInstance().getPlayers();
	}

	public static ProxiedPlayer getProxiedPlayed(String player) {
		return ProxyServer.getInstance().getPlayer(player);
	}

	public static ProxiedPlayer getProxiedPlayed(CommandSender player) {
		String pl = player.getName().toString();
		return getProxiedPlayed(pl);
	}

	public static void broadcast(String msg) {
		for (ProxiedPlayer pp : ProxyServer.getInstance().getPlayers()) {
			pp.sendMessage(msg);
		}
	}

}
