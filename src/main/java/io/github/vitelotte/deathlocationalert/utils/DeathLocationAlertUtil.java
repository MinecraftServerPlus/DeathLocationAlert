package io.github.vitelotte.deathlocationalert.utils;

import io.github.vitelotte.deathlocationalert.enums.DeathLocationDisplay;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class DeathLocationAlertUtil {

    public static void setDisplayType(Plugin plugin, Player player, DeathLocationDisplay deathLocationDisplay) {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "display");
        pdc.set(key, PersistentDataType.BYTE, (byte) deathLocationDisplay.ordinal());
    }

    public static DeathLocationDisplay getDisplayType(Plugin plugin, Player player) {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "display");
        return DeathLocationDisplay.values()[pdc.getOrDefault(key, PersistentDataType.BYTE, (byte) 0)];
    }

    public static void initPlayer(Plugin plugin, Player player) {
        switch (getDisplayType(plugin, player)) {
            case UNDEFINED -> setDisplayType(plugin, player, DeathLocationDisplay.MESSAGE);
            case SIDEBAR -> ScoreboardUtil.initScoreboard(player);
        }
    }

    public static void updatePlayer(Plugin plugin, Player player) {
        switch (getDisplayType(plugin, player)) {
            case SIDEBAR -> ScoreboardUtil.updateDeathLocationObjective(player);
            case MESSAGE -> MessageUtil.sendDeathLocation(player);
        }
    }
}
