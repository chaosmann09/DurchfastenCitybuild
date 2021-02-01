package de.durchfasten.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.durchfasten.cmd.Kopf_CMD;
import de.durchfasten.listeners.JoinListener;
import de.durchfasten.utils.Manager;

public class Main extends JavaPlugin {

    private static Main plugin;

    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Manager.PREFIX + "§7Citybuild wurde geladen");
        register();
        loadlistener(Bukkit.getPluginManager());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
    public void register() {
        Bukkit.getPluginCommand("kopf").setExecutor(new Kopf_CMD());

    }

    public void loadlistener(PluginManager pm) {
        pm.registerEvents(new JoinListener(), this);
    }
}
