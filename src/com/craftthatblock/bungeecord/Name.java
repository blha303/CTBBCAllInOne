package com.craftthatblock.bungeecord;

import net.md_5.bungee.api.connection.ProxiedPlayer;

//WIP
//WIP
//WIP

public class Name {

	final String msgnormal = "&8<player>&3> <msg>";
	final String msgowner = "&7[&bOwner&7]&6<player>&3> &e<msg>";

	public String getMSG(String pl, String msg) {

		ProxiedPlayer ppl = CTBBCCrossChat.getProxiedPlayed(pl);
		String finalmsg = null;
		if (ppl.hasPermission("ctbbc.owner")) {
			String msgowner1 = msgowner;
			msgowner1.replace("<player>", pl);
			msgowner1.replace("<msg>", msg);
			finalmsg = (msgowner1);
		} else {
			finalmsg = "";
		}

		return finalmsg;
	}

	public String getDisplay(String pl) {
		String prefix = getDisplay(pl, false);

		return prefix;

	}
	

	public String getDisplay(String pl, Boolean chatcolor) {
		ProxiedPlayer ppl = CTBBCCrossChat.getProxiedPlayed(pl);
		String prefix;
		String color;
		if (ppl.hasPermission("prefix.owner")) {
			prefix = "&7[&bOwner&7]&6<player>";
			color = "&3";
			prefix.replace("<player>", pl);
		} else if (ppl.hasPermission("prefix.admin")) {
			prefix = "&7[&4Admin&7]&e<player>";
			prefix.replace("<player>", pl);
			color = "&f";
		} else {
			prefix = "&8<player>";
			prefix.replace("<player>", pl);
			color = "&7";
		}

		if (chatcolor) {
			return CTBBCCrossChat.colorize(color);
		} else {
			return CTBBCCrossChat.colorize(prefix);
		}

	}

}
