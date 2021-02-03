package de.durchfasten.cmd;

import de.durchfasten.utils.Manager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiniCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("craft") || cmd.getName().equalsIgnoreCase("wb")) {
            p.openWorkbench(p.getLocation(), true);
            return true;

        }else if(cmd.getName().equalsIgnoreCase("day")) {
            if(sender instanceof Player) {
                if(p.hasPermission("durchfasten.day")) {
                    p.getLocation().getWorld().setTime(1000);
                    p.sendMessage(Manager.PREFIX + "§eDu hast in §cworld §edie zeit auf Tag gesetzt!");
                }else {
                    sender.sendMessage(Manager.NO_PERMS);
                }
            }
        }else if(cmd.getName().equalsIgnoreCase("night")) {
            if(sender instanceof Player) {
                if(p.hasPermission("durchfasten.night")) {
                    p.getLocation().getWorld().setTime(9000);
                    p.sendMessage(Manager.PREFIX + "§eDu hast in §cworld §edie zeit auf Nacht gesetzt!");
                }else {
                    sender.sendMessage(Manager.NO_PERMS);
                }
            }
        }

        return false;
    }
}