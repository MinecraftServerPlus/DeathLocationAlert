package io.github.vitelotte.deathlocationalert.commands;

import io.github.vitelotte.deathlocationalert.DeathLocationAlert;
import io.github.vitelotte.deathlocationalert.enums.DeathLocationDisplay;
import io.github.vitelotte.deathlocationalert.utils.DeathLocationAlertUtil;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class AlertCommand implements BasicCommand {
    Plugin plugin;
    public AlertCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(@NotNull CommandSourceStack stack, @NotNull String[] args) {
        Player player = (Player) stack.getSender();

        if (Objects.isNull(player)) {
            // TODO: alert message for command alert
            return;
        }

        if (args.length == 0) {
            // TODO: help message for command alert
            return;
        }

        if (args.length != 1) {
            // TODO: error message for command alert
            return;
        }

        switch (args[0]) {
            case "msg":
            case "message":
            case "chat":
                DeathLocationAlertUtil.setDisplayType(plugin, player, DeathLocationDisplay.MESSAGE);
                // TODO: notify the player that the display type of player's death location was successfully changed
                return;
            case "sidebar":
            case "side":
                DeathLocationAlertUtil.setDisplayType(plugin, player, DeathLocationDisplay.SIDEBAR);
                // TODO: notify the player that the display type of player's death location was successfully changed
                return;
            case "none":
                DeathLocationAlertUtil.setDisplayType(plugin, player, DeathLocationDisplay.NONE);
                // TODO: notify the player that the display type of player's death location was successfully changed
                return;
            default:
                // TODO: error message for command alert
        }

    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args) {


        return BasicCommand.super.suggest(commandSourceStack, args);
    }
}
