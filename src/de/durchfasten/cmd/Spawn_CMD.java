package de.durchfasten.cmd;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.durchfasten.utils.Manager;

public class Spawn_CMD implements Listener{
	
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            return true;
        }
        Player p = (Player) sender;

        File file = new File("plugins//DurchfastenCitybuild//spawn.yml");

        if(!(file.exists())) {
            p.sendMessage(Manager.PREFIX + "§cDer Spawn konnte nicht gesetzt werden!");
            return true;
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location loc = p.getLocation();

        loc.setX(cfg.getDouble("Spawns.Spawn.X"));
        loc.setY(cfg.getDouble("Spawns.Spawn.Y"));
        loc.setZ(cfg.getDouble("Spawns.Spawn.Z"));

        double yaw = cfg.getDouble("Spawns.Spawn.Yaw");
        double pitch = cfg.getDouble("Spawns.Spawn.Pitch");
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);

        World welt = Bukkit.getWorld(cfg.getString("Spawns.Spawn.World"));
        loc.setWorld(welt);

        p.teleport(loc);

        p.sendMessage(Manager.PREFIX + "§7Du wurdest erfolgreich zum §bSpawn §7teleportiert!");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,3,3);

        return false;
    }

}
