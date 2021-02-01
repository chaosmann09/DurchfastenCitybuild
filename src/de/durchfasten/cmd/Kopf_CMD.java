package de.durchfasten.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.durchfasten.utils.Manager;

public class Kopf_CMD implements CommandExecutor{
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("durchfasten.kopf")) {
                if(args.length == 1) {
                    @SuppressWarnings("deprecation")
					OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                    ItemStack head = new ItemStack(Material.SKULL_ITEM,1, (short) 3);
                    SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                    headMeta.setOwningPlayer(offlinePlayer);
                    head.setItemMeta(headMeta);

                    p.getInventory().addItem(head);

                }else
                    p.sendMessage(Manager.PREFIX + "§cBenutze: /kopf <Name>");
            }else
                p.sendMessage(Manager.NO_PERMS);
        }
        return false;
    }

}
