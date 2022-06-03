package dev.jamieisgeek.custommessages.Commands;

import dev.jamieisgeek.custommessages.CustomMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetJoinMessage implements CommandExecutor {

    CustomMessage customMessage = CustomMessage.getCustomMessage();
    String prefix = customMessage.getPrefix();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("messages.setjoin")) {

                if(args.length == 0) {
                    p.sendMessage(prefix + ChatColor.RED + "Please provide a join message!");
                } else {
                    customMessage.setJoinMessage(p, args);
                }
            } else {
                p.sendMessage(prefix + ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            Bukkit.getLogger().warning("You must run this command in-game!");
        }

        return true;
    }
}
