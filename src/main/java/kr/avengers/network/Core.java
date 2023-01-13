package kr.avengers.network;

import kr.avengers.network.player.SetPlayerMaxHealth;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    Core instance;

    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("aSuite Enabled.");
        getLogger().info("Made for Avengers.mcv.kr");
        getLogger().info(" ");
        onLoad();
        getLogger().info("Loaded all necessities!");
    }


    public void onLoad() {
        registerCommands();
        registerListeners();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new SetPlayerMaxHealth(), this);
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
