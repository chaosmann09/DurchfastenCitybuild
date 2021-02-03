package de.durchfasten.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

public class FirtJoinEvent implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerLoginEvent event) {
        Player p = event.getPlayer();
        if (!p.hasPlayedBefore()) {
            p.getInventory().addItem(new ItemStack(Material.BOOK, 1));
        }
    }
}
