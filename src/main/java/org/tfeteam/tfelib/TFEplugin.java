package org.tfeteam.tfelib;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public abstract class TFEplugin extends JavaPlugin {
    public void saveConfigIfNotExist(@NotNull String config, String path) {
        saveConfigIfNotExist(config, path, null);
    }
    public void saveConfigIfNotExist(@NotNull String name, String path, String text) {
        if(getConfig(path + "/" + name + ".yml") == null) saveConfig(name, path, text);
    }

    public void saveConfig(@NotNull String name, String path, String text){
        FileConfiguration configuration;
        if(text == null) configuration = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource(name + ".yml")));
        else configuration = YamlConfiguration.loadConfiguration(new StringReader(text));
        try {
            configuration.save(getDataFolder() + path + "/" + name + ".yml");
        } catch (IOException e) {}
    }
    public void saveConfig(@NotNull String config, String path){
        saveConfig(config, path, null);
    }

    public FileConfiguration getConfig(String path) {
        File file = new File(path);
        return YamlConfiguration.loadConfiguration(file);
    }
}