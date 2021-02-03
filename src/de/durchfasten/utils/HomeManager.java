package de.durchfasten.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Set;
import java.util.UUID;

public class HomeManager {
	
	private FileBuilder fb;
    private Location loc;

    public HomeManager(UUID uuid) {
        fb = new FileBuilder("plugins//Durchfasten//HomeManager//", uuid.toString() + ".yml");
    }

    public void addHome(Location loc, String name) {
        fb.setValue(name + ".world", loc.getWorld().getName());
        fb.setValue(name + ".x", loc.getX());
        fb.setValue(name + ".y", loc.getY());
        fb.setValue(name + ".z", loc.getZ());
        fb.setValue(name + ".yaw", loc.getYaw());
        fb.setValue(name + ".pitch", loc.getPitch());

        fb.save();
    }

    public boolean exist(String name) {
        return fb.getString(name) != null;
    }
    public Location getLocation(String name) {
        return new Location(Bukkit.getWorld(fb.getString(name +".world")), fb.getDouble(name + ".x"), fb.getDouble(name + ".y"), fb.getDouble(name + ".z"), (float) fb.getDouble(name + ".yaw"), (float) fb.getDouble(name + ".pitch"));
    }

    public void delHome(String name) {
        fb.setValue(name, null);
        fb.save();
    }
    public Set<String> getHome() {
        return fb.getKeys(false);
    }
}


