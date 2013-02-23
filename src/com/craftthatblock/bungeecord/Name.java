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

}
