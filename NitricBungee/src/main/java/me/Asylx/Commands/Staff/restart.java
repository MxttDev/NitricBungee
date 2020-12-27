package me.Asylx.Commands.Staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class restart extends Command {

    public restart() {
        super("restart");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        if (p.hasPermission("Nitric.Admin")) {
            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                player.sendMessage(new TextComponent(" "));
                player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&c[SERVER RESTART] &eGlobal server restat. Please rejoin the server!")));
                player.sendMessage(new TextComponent(" "));

            }
        } else {
            p.sendMessage(new TextComponent(ChatColor.RED+"Insufficient Permissions!"));
        }




    }

}
