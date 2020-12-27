package me.Asylx.Events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class connectToLobby implements Listener {

    String Lobby = "Hub"; // Lobby name

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        ProxiedPlayer p = event.getPlayer();
        ServerInfo target = ProxyServer.getInstance().getServerInfo(Lobby);
        p.connect(target);
    }


}
