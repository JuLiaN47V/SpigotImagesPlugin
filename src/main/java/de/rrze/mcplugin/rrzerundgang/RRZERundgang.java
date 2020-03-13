package de.rrze.mcplugin.rrzerundgang;

import org.bukkit.plugin.java.JavaPlugin;

public final class RRZERundgang extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        this.getCommand("map").setExecutor(new MapCommand());
    }

    @Override
    public void onDisable() {
    }

}

