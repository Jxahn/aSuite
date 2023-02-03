package kr.avengers.network;

import kr.avengers.network.player.PlayerJoinLobby;
import kr.avengers.network.player.SetPlayerMaxHealth;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    Core instance;
    private int noDamageTicks = 20;

    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("aSuite Enabled.");
        getLogger().info("Made for Avengers.mcv.kr");
        getLogger().info(" ");
        onLoad();
        getLogger().info("Loaded all necessities!");

        getServer().getScheduler().runTaskTimer(this, this::resetHitDelays, 11L, 20L);
    }


    public void onLoad() {
        registerCommands();
        registerListeners();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new SetPlayerMaxHealth(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinLobby(), this);
        }

    public void registerCommands() {

    }

    public void onDisable() {
        getLogger().info(" ");
        getLogger().info("aSuite Disabled.");
        getLogger().info(" ");
    }

    private void resetHitDelays() {
        for (Player player : getServer().getOnlinePlayers()) {
            player.setMaximumNoDamageTicks(noDamageTicks);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("pmchitdelay.use")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSorry, you cannot use this."));
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cWrong usage"));
            return true;
        }
        try {
            noDamageTicks = Integer.parseInt(args[0]);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aChanged to " + args[0]));

        } catch (NumberFormatException ex) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNot a number"));
        }
        return true;
    }

    public Core getInstance() {
        return instance;
    }
}
