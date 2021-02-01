package de.durchfasten.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
	
	@EventHandler
    public void onjoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
    }

}
