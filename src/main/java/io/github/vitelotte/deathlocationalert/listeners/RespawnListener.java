package io.github.vitelotte.deathlocationalert.listeners;

import io.github.vitelotte.deathlocationalert.utils.DeathLocationAlertUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class RespawnListener implements Listener {
    Plugin plugin;

    public RespawnListener(Plugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        DeathLocationAlertUtil.updatePlayer(plugin, player);
    }

}
