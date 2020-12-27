package me.Asylx.Commands.Staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class staffchat extends Command {

    public staffchat() {
        super("s");
    }

    @Override

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (p.hasPermission("Nitric.staff")) {
            if (args.length >= 1) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    str.append(args[i] + " ");
                }
                String msg = str.toString();


                for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) { //
                    if (player.hasPermission("Nitric.staff")) {
                        char char1;
                        String serv = p.getServer().getInfo().getName();
                        player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&c["+serv+"] &d"+p.getName()+":&e "+msg)));
                    }
                }

            } else {
                p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect usage: /s (message)"));
            }
        } else {
            p.sendMessage(new TextComponent(ChatColor.RED+"Insufficient Permissions!"));
        }

    }
}