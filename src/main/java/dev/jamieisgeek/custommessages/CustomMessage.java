package dev.jamieisgeek.custommessages;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CustomMessage {

    private static CustomMessage customMessage;
    private final Plugin plugin = CustomMessages.getPlugin(CustomMessages.class);
    private final FileConfiguration config = plugin.getConfig();
    private static final String prefix = ChatColor.WHITE + "[" + ChatColor.AQUA + "CustomMessages" + ChatColor.WHITE + "] ";


    public void setJoinMessage(Player p, String[] args) {

        if(argsToString(args).contains("{player}")) {
            String string = argsToString(args);
            config.set(p.getUniqueId() + ".joinMessage", playerToName(string, p));
        } else {
            config.set(p.getUniqueId() + ".joinMessage", argsToString(args));
        }
        plugin.saveConfig();
        p.sendMessage(prefix + "Set join message!");
    }

    public void setLeaveMessage(Player p, String[] args) {

        if(argsToString(args).contains("{player}")) {
            String string = argsToString(args);
            config.set(p.getUniqueId() + ".leaveMessage", playerToName(string, p));
        } else {
            config.set(p.getUniqueId() + ".leaveMessage", argsToString(args));
        }

        plugin.saveConfig();
        p.sendMessage(prefix + "Set leave message!");
    }

    public String colourize(String preColour) {
        return ChatColor.translateAlternateColorCodes('&', preColour);
    }

    private String playerToName(String string, Player p) {
        return string.replace("{player}", p.getName());
    }

    private @NotNull String argsToString(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
        }
        return sb.toString();
    }

    public static String getPrefix() {
        return prefix;
    }

    public CustomMessage() {
        customMessage = this;
    }

    public static CustomMessage getCustomMessage() {
        return customMessage;
    }
}
