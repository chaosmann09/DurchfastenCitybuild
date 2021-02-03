package de.durchfasten.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.durchfasten.cmd.DelHome_CMD;
import de.durchfasten.cmd.Home_CMD;
import de.durchfasten.cmd.Kopf_CMD;
import de.durchfasten.cmd.MiniCMD;
import de.durchfasten.cmd.SetHome_CMD;
import de.durchfasten.cmd.SetSpawn_CMD;
import de.durchfasten.cmd.Spawn_CMD;
import de.durchfasten.cmd.Warp_CMD;
import de.durchfasten.listeners.FirtJoinEvent;
import de.durchfasten.listeners.JoinListener;
import de.durchfasten.utils.Manager;

public class Main extends JavaPlugin {

    private static Main plugin;

    private static Main instance;

    public static Main getPlugin() {
        return plugin;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
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
        Bukkit.getPluginCommand("home").setExecutor(new Home_CMD());
        Bukkit.getPluginCommand("sethome").setExecutor(new SetHome_CMD());
        Bukkit.getPluginCommand("delhome").setExecutor(new DelHome_CMD());
        Bukkit.getPluginCommand("spawn").setExecutor(new Spawn_CMD());
        Bukkit.getPluginCommand("setspawn").setExecutor(new SetSpawn_CMD());
        Bukkit.getPluginCommand("warp").setExecutor(new Warp_CMD());
        Bukkit.getPluginCommand("craft").setExecutor(new MiniCMD());
        Bukkit.getPluginCommand("wb").setExecutor(new MiniCMD());
        Bukkit.getPluginCommand("day").setExecutor(new MiniCMD());
        Bukkit.getPluginCommand("night").setExecutor(new MiniCMD());

    }

    public void loadlistener(PluginManager pm) {
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new FirtJoinEvent(), this);
    }
}
