package kr.avengers.network;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    Core instance;

    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("aSuite Enabled.");
        getLogger().info("Made for Avengers.mcv.kr");
        getLogger().info(" ");
    }

    public void onLoad() {
        registerCommands();
        registerListeners();
    }

    public void registerListeners() {
        // #Register Listeners here
    }

    public void registerCommands() {

    }

    public void onDisable() {
        getLogger().info(" ");
        getLogger().info("aSuite Disabled.");
        getLogger().info(" ");
    }

    public Core getInstance() {
        return instance;
    }
}
