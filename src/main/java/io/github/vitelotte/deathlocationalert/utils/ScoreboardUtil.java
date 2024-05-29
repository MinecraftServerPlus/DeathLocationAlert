package io.github.vitelotte.deathlocationalert.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Objects;

public class ScoreboardUtil {

    public static void initScoreboard(Player player) {
        if (!player.getScoreboard().equals(Bukkit.getServer().getScoreboardManager().getMainScoreboard()))
            return;

        Scoreboard scoreboard = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        Component deathLocationComponent = Component.text("사망한 좌표");
        scoreboard.registerNewObjective("DeathLocation", Criteria.DUMMY, deathLocationComponent);
        scoreboard.getObjective("DeathLocation").setDisplaySlot(DisplaySlot.SIDEBAR);
        ScoreboardUtil.updateDeathLocationObjective(player);
    }

    public static void updateDeathLocationObjective(Player player) {
        Location location = player.getLastDeathLocation();
        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("DeathLocation");

        if (Objects.isNull(location) || Objects.isNull(objective))
            return;

        {
            objective.getScore("World : " + location.getWorld().getName()).setScore(3);
            objective.getScore("x : " + Objects.toString(location.getBlockX())).setScore(2);
            objective.getScore("y : " + Objects.toString(location.getBlockY())).setScore(1);
            objective.getScore("z : " + Objects.toString(location.getBlockZ())).setScore(0);
        }
    }
}
