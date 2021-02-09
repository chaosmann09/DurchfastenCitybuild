package de.durchfasten.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class Fly_CMD implements CommandExecutor{
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("cb.fly")) {
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§7Flugmodus §8» §cDeaktiviert").create());

                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§7Flugmodus §8» §aAktiviert").create());
                }

            }

        }
        return false;
    }
}


