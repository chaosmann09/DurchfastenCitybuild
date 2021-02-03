package de.durchfasten.cmd;

import de.durchfasten.utils.HomeManager;
import de.durchfasten.utils.Manager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelHome_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;

        Player p = (Player)sender;

        HomeManager manager = new HomeManager(p.getUniqueId());

        if(args.length == 0) {
            p.sendMessage(Manager.PREFIX + "§c/delhome <Name>");
            return true;
        }
        if(args.length == 1) {
            if(!manager.exist(args[0])){
                p.sendMessage(Manager.PREFIX + "§cDieses Home existiert nicht!");
                return true;
            }
            manager.delHome(args[0]);

            p.sendMessage(Manager.PREFIX + "Das Home §e" + args[0] + " §7wurde §aerfolgreich §7gelöscht!");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,3,3);
            return true;
        }
        return false;
    }
}
