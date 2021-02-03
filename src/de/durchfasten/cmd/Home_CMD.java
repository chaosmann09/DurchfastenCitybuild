package de.durchfasten.cmd;

import de.durchfasten.utils.HomeManager;
import de.durchfasten.utils.Manager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;

        Player p = (Player)sender;

        HomeManager manager = new HomeManager(p.getUniqueId());

        if(args.length == 0) {
            if(manager.getHome() == null) {
                p.sendMessage(Manager.PREFIX + "§cDu hast keine Homes!");
                return true;
            }
            String out = "";
            for(String s: manager.getHome()) {
                out = out + "§7 §e" + s;
            }

            out = out.trim();

            p.sendMessage(Manager.PREFIX + "§7Deine Homes §8:" + out);
        }
        if(args.length == 1) {
            if(!manager.exist(args[0])){
                p.sendMessage(Manager.PREFIX + "§cDieses Home exetiert nicht!");
                return true;
            }
            p.teleport(manager.getLocation(args[0]));

            p.sendMessage(Manager.PREFIX + "Du wurdest zu deinem Home §e" + args[0] + " §7teleportiert!");

            return true;
        }
        return false;
    }
}
