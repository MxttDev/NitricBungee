package me.Asylx.Commands.Misc;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.HashMap;
import java.util.Map;

public class creep extends Command {

    public creep() {
        super("creep");
    } // CREEP <PLAYER>

    String Creep1 = "You feel an evil presence watching you...";
    String Creep2 = "You feel vibrations from deep below...";
    String Creep3 = "You feel a quaking from deep underground...";

    int cooldownTime = 30; // IN SECONDS
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>(); // PLAYER DATA

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
            return;
        }

        ProxiedPlayer p = (ProxiedPlayer) sender;

        if (args.length == 1) {
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (!(target instanceof ProxiedPlayer)) {
                p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found: "+args[0])));
                return;
            }

            if(cooldowns.containsKey(p.getName())) {
                long secondsLeft = ((cooldowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                if(secondsLeft>0) {
                    p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&cYou cant use that commands for another &e"+ secondsLeft +"&c seconds!")));
                    return;
                }
            }

            if (target.getName() == p.getName()) {
                p.sendMessage(new TextComponent(ChatColor.RED+"You cannot send this message to yourself!"));
                return;
            }
            cooldowns.put(p.getName(), System.currentTimeMillis());

            int min = 1;
            int max = 3;
            int randomInt = (int)(Math.random() * (max - min + 1) + min);
            if (randomInt == 1) {
                target.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&9" + Creep1)));
            } else if (randomInt == 2) {
                target.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&9" + Creep2)));
            } else if (randomInt == 3) {
                target.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&9" + Creep3)));
            }


            p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&7You sent a creep message to: &b"+args[0]+"&b!")));

        } else {
            p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect usage: /creep (player)"));
        }
    }
}
