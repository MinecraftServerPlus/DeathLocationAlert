package io.github.vitelotte.deathlocationalert;

import io.github.vitelotte.deathlocationalert.commands.AlertCommand;
import io.github.vitelotte.deathlocationalert.listeners.JoinListener;
import io.github.vitelotte.deathlocationalert.listeners.RespawnListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocationAlert extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new RespawnListener(this), this);
        manager.registerEvents(new JoinListener(this), this);
        // TODO: AlertCommand 등록
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
