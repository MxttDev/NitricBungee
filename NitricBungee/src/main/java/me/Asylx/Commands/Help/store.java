package me.Asylx.Commands.Help;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class store extends Command {
    public store() {
        super("store");
    }



    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
        } else {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            String smessage = "&7Click here to visit our &bStore&7!";
            TextComponent discordmsg = new TextComponent(ChatColor.translateAlternateColorCodes('&', smessage));

            discordmsg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://nitricmc.tebex.io/"));
            discordmsg.setColor(ChatColor.AQUA);
            discordmsg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));
            p.sendMessage(new TextComponent(" "));
            p.sendMessage(discordmsg);
            p.sendMessage(new TextComponent(" "));

        }
    }
}