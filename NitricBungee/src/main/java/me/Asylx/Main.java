package me.Asylx;

import me.Asylx.Commands.Help.discord;
import me.Asylx.Commands.Help.store;
import me.Asylx.Commands.Misc.creep;
import me.Asylx.Commands.Misc.hi;
import me.Asylx.Commands.Server.find;
import me.Asylx.Commands.Server.hub;
import me.Asylx.Commands.Server.server;
import me.Asylx.Commands.Staff.restart;
import me.Asylx.Commands.Staff.staffchat;
import me.Asylx.Events.connectToLobby;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    private static Main instance;

    @Override
    public void onEnable() {
        setInstance(this);
        getLogger().info("[BUNGEECORD] Loaded");

        SetupCmds();

    }
    public static Main getInstance() {
        return instance;
    }

    private void SetupCmds() {
        getProxy().getPluginManager().registerCommand(this, new server()); // /SERVER (NAME)
        getProxy().getPluginManager().registerCommand(this, new hub()); // /HUB
        getProxy().getPluginManager().registerCommand(this, new discord()); // /DISCORD
        getProxy().getPluginManager().registerCommand(this, new find());
        getProxy().getPluginManager().registerCommand(this, new store());
        getProxy().getPluginManager().registerCommand(this, new staffchat());
        getProxy().getPluginManager().registerCommand(this, new restart());
        getProxy().getPluginManager().registerCommand(this, new hi());
        getProxy().getPluginManager().registerCommand(this, new creep());
    }

    private void SetupEvents() {
        getProxy().getPluginManager().registerListener(this, new connectToLobby());
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }


}
