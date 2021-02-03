package de.durchfasten.cmd;

import de.durchfasten.utils.HomeManager;
import de.durchfasten.utils.Manager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHome_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;

        Player p = (Player)sender;

        if(args.length == 0) {
            p.sendMessage(Manager.PREFIX + "§c/sethome <name>");
            return true;
        }
        if(args.length == 1) {
            HomeManager manager = new HomeManager(p.getUniqueId());

            manager.addHome(p.getLocation(), args[0]);

            p.sendMessage(Manager.PREFIX + "§7Du hast dein Home §e" + args[0] + " §aerfolgreich §7gesetzt!");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,3,3);
            return true;
        }
        return false;
    }
}
