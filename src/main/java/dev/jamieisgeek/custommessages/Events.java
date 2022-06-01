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
        if(config.contains(p.getUniqueId() + ".joinmessage")) {
            e.setJoinMessage(customMessage.colourize(Objects.requireNonNull(config.get(p.getUniqueId() + ".joinmessage")).toString()));
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(config.contains(p.getUniqueId() + ".leavemessage")) {
            e.setQuitMessage(customMessage.colourize(Objects.requireNonNull(config.get(p.getUniqueId() + ".leavemessage")).toString()));
        }
    }
}
