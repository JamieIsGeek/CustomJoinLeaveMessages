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
    private final String prefix = ChatColor.WHITE + "[" + ChatColor.AQUA + "CustomMessages" + ChatColor.WHITE + "] ";


    public void setJoinMessage(Player p, String[] args) {
        String string = argsToString(args);
        config.set(p.getUniqueId() + ".joinMessage", playerToName(string, p));
        plugin.saveConfig();
        p.sendMessage(prefix + "Join message set!");
    }

    public void setLeaveMessage(Player p, String[] args) {

        String string = argsToString(args);
        config.set(p.getUniqueId() + ".leaveMessage", playerToName(string, p));
        plugin.saveConfig();
        p.sendMessage(prefix + "Leave message set!");
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

    public String getJoinMessage(Player p) {
        if(config.contains(p.getUniqueId() + ".joinMessage") && (!config.get(p.getUniqueId() + ".joinMessage").equals(null))) {
            String preColour = (String) config.get(p.getUniqueId() + ".joinMessage");
            return colourize(preColour);
        } else {
            return null;
        }
    }

    public String getQuitMessage(Player p) {
        if(config.contains(p.getUniqueId() + ".leaveMessage") && (config.get(p.getUniqueId() + ".leaveMessage") != null)) {
            String preColour = (String) config.get(p.getUniqueId() + ".leaveMessage");
            return colourize(preColour);
        } else {
            return null;
        }
    }

    public String getPrefix() {
        return prefix;
    }

    public CustomMessage() {
        customMessage = this;
    }

    public static CustomMessage getCustomMessage() {
        return customMessage;
    }
}
