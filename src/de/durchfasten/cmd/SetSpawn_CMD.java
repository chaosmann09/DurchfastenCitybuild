package de.durchfasten.cmd;

import de.durchfasten.utils.Manager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetSpawn_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            return true;
        }
        Player p = (Player) sender;

        if (!(p.hasPermission("durchfasten.setspawn"))) {
            p.sendMessage(Manager.NO_PERMS);
            return true;
        }
        File ordner = new File("plugins//Durchfasten");
        File file = new File("plugins//Durchfasten//spawn.yml");

        if (!ordner.exists()) {
            ordner.mkdirs();
        }
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Location loc = p.getLocation();

        double x = loc.getX();
        double y = loc.getX();
        double z = loc.getX();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();
        String weltname = loc.getWorld().getName();

        cfg.set("Spawns.Spawn.X", x);
        cfg.set("Spawns.Spawn.Y", y);
        cfg.set("Spawns.Spawn.Z", z);
        cfg.set("Spawns.Spawn.Yaw", yaw);
        cfg.set("Spawns.Spawn.Pitch", pitch);
        cfg.set("Spawns.Spawn.Weltname", weltname);

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        p.sendMessage(Manager.PREFIX + "§7Du hast den zum §aSpawn §7gesetzt");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);

        return false;
    }
}
