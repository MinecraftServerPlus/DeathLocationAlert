package io.github.vitelotte.deathlocationalert.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MessageUtil {

    public static Component getLocationComponent(Location location) {

        return Component.text(location.getWorld().getName())
                .append(Component.text("의 "))
                .append(Component.text("("))
                .append(Component.text(location.getBlockX()))
                .append(Component.text(", "))
                .append(Component.text(location.getBlockY()))
                .append(Component.text(", "))
                .append(Component.text(location.getBlockZ()))
                .append(Component.text(")"));
    }

    public static void sendDeathLocation(Player player) {
        Location location = player.getLastDeathLocation();
        player.sendMessage(
                Component.text("마지막으로 사망한 위치 : ")
                        .append(getLocationComponent(location))

        );
    }
}
