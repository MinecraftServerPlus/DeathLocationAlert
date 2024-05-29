package io.github.vitelotte.deathlocationalert.listeners;

import io.github.vitelotte.deathlocationalert.utils.DeathLocationAlertUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class JoinListener implements Listener {
    Plugin plugin;

    public JoinListener(Plugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        DeathLocationAlertUtil.initPlayer(plugin, player);
    }
}
