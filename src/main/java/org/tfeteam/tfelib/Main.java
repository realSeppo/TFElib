package org.tfeteam.tfelib;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        System.out.println("TFElib включен.");

        saveDefaultConfig();
        FileConfiguration config = getConfig();
        PrefixManager.setPrefix(config.getString("prefix"));
    }

    @Override
    public void onDisable() {
        System.out.println("TFElib корректно выключен.");
    }
}
