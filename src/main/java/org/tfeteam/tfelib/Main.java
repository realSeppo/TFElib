package org.tfeteam.tfelib;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        System.out.println("TFElib включен.");
    }

    @Override
    public void onDisable() {
        System.out.println("TFElib корректно выключен.");
    }
}
