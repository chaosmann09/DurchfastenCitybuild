package de.durchfasten.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;

import net.md_5.bungee.api.ChatColor;

public class Manager {
	
	public static String PREFIX = "§6§lDURCHFASTEN §8» §7";

    public static String NO_PERMS = "§6§lDURCHFASTEN §8» §cDazu hast du keinen Zugriff!";

    public static void updateScoreboard(Player p) {

        ScoreboardManager sm = Bukkit.getScoreboardManager();
        final Scoreboard board = (Scoreboard) sm.getNewScoreboard();
        final Objective obj = ((org.bukkit.scoreboard.Scoreboard) board).registerNewObjective("aaa", "dummy");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6§lDURCHFASTEN");
        obj.getScore("§f ").setScore(10);
        obj.getScore("§8» §6§lServer").setScore(9);
        obj.getScore(Bukkit.getServer().getName()).setScore(8);
        obj.getScore("§d ").setScore(7);
        obj.getScore("§8» §6§lSpieler").setScore(6);
        obj.getScore(Bukkit.getOnlinePlayers() + "§7/" + Bukkit.getMaxPlayers()).setScore(5);
        obj.getScore("§b ").setScore(4);
        obj.getScore("§8» §6§lKonto").setScore(3);
        obj.getScore("0€").setScore(2);
        obj.getScore("§a ").setScore(1);


        p.setScoreboard(board);
    }

}
