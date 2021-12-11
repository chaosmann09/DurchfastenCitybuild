package de.durchfasten.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.durchfasten.utils.Manager;

public class JoinListener implements Listener{
	
	@EventHandler
    public void onjoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        
	if (!p.hasPlayedBefore()) {
            p.getInventory().addItem(new ItemStack(Material.BOOK, 1));
        }
	    
        for (Player all : Bukkit.getOnlinePlayers()) {
            Manager.updateScoreboard(all);
        }
	    
	
    }

}
