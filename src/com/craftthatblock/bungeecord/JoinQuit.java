package com.craftthatblock.bungeecord;


import com.google.common.eventbus.Subscribe;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;

@SuppressWarnings("unused")
public class JoinQuit implements Listener {


@Subscribe
public void onDisconnect(PlayerDisconnectEvent e) {
	ProxiedPlayer pl = (ProxiedPlayer)e.getPlayer();
    for (ProxiedPlayer pp : ProxyServer.getInstance().getPlayers()) {
    	if(!(pl.getServer() == pp.getServer())) {
    		pp.sendMessage("hi");
    	}
	}  	
}
@Subscribe
public void onConnect(ServerConnectedEvent e) {
	ProxiedPlayer pl = (ProxiedPlayer)e.getPlayer();
	for (ProxiedPlayer pp : ProxyServer.getInstance().getPlayers()) {
		if(!(pl.getServer() == pp.getServer())) {
			
			pp.sendMessage("hi");
		}
	}  	
}
	
}
