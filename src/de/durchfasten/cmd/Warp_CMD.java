package de.durchfasten.cmd;

import de.durchfasten.main.Main;
import de.durchfasten.utils.Manager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp_CMD implements CommandExecutor{
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Manager.PREFIX + "§c/warp <name>");
        } else if (args.length == 1) {
            String Warpname = args[0];

            Location loc = (Location) Main.getInstance().getConfig().get("Warps." + Warpname);

            p.teleport(loc);
            p.sendMessage(Manager.PREFIX + "§7Du hast dich zu §e" + Warpname + "§7teleportiert!");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("set")) {
                String Warpname = args[1];
                Location loc = p.getLocation();

                Main.getInstance().getConfig().set("Warps." + Warpname, loc);
                Main.getInstance().saveConfig();

                p.sendMessage(Manager.PREFIX + "§7Du hast den WarpPunkt §e" + Warpname + "§7erstellt");
                p.teleport(loc);
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);

            }
        }
        return true;
    }

}
