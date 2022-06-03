package dev.jamieisgeek.custommessages;

import dev.jamieisgeek.custommessages.Commands.SetJoinMessage;
import dev.jamieisgeek.custommessages.Commands.SetLeaveMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CustomMessages extends JavaPlugin {

    private final Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new CustomMessage();
        getCommand("setjoinmessage").setExecutor(new SetJoinMessage());
        getCommand("setleavemessage").setExecutor(new SetLeaveMessage());
        getServer().getPluginManager().registerEvents(new Events(), this);

        logger.info("");
        logger.info("=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        logger.info("CustomMessage has Enabled!");
        logger.info("Version 1.0");
        logger.info("=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        logger.info("");
    }

    @Override
    public void onDisable() {
        saveConfig();

        logger.info("");
        logger.info("=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        logger.info("CustomMessage has Disabled!");
        logger.info("Version 1.0");
        logger.info("=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        logger.info("");
    }
}
