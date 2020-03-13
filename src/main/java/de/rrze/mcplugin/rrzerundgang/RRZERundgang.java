package de.rrze.mcplugin.rrzerundgang;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class RRZERundgang extends JavaPlugin {
    private File imageConfigFile;
    private FileConfiguration imageConfig;


    @Override
    public void onEnable() {
        createImageConfig();
        getServer().getPluginManager().registerEvents(new MyListener(), this);
    }

    @Override
    public void onDisable() {
    }

    public FileConfiguration getImageConfig() {
        return this.imageConfig;
    }

    private void createImageConfig() {
        imageConfigFile = new File(getDataFolder(), "image.yml");
        if (!imageConfigFile.exists()) {
            imageConfigFile.getParentFile().mkdirs();
            saveResource("image.yml", false);
        }
        imageConfig = new YamlConfiguration();
        try {
            imageConfig.load(imageConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reloadImageConfig() {
        imageConfig = YamlConfiguration.loadConfiguration(imageConfigFile);
    }
}
