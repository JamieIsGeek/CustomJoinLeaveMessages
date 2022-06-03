package dev.jamieisgeek.custommessages;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class Events implements Listener {

    private final Plugin plugin = CustomMessages.getPlugin(CustomMessages.class);
    private final FileConfiguration config = plugin.getConfig();
    private final CustomMessage customMessage = CustomMessage.getCustomMessage();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        String joinMessage = customMessage.getJoinMessage(p);

        if(joinMessage.equals(null) || joinMessage.isEmpty()) {
            return;
        } else {
            e.setJoinMessage(joinMessage);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        String leaveMessage = customMessage.getQuitMessage(p);

        if(leaveMessage.equals(null) || leaveMessage.isEmpty()) {
            return;
        } else {
            e.setQuitMessage(leaveMessage);
        }
    }
}
