package me.Asylx.Commands.Misc;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class hi extends Command {

    public hi() {
        super("hi");
    }



    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
        }

        ProxiedPlayer p = (ProxiedPlayer) sender;
        p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&dHello!")));
    }

}
