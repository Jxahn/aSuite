package kr.avengers.network.player;

import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.classes.event.PvpClassEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.UUID;

public class SetPlayerMaxHealth implements Listener {

    @EventHandler(priority= EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.setMaxHealth(40D);
        player.setHealth(40D);
    }

    @EventHandler(priority= EventPriority.LOWEST)
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        player.setMaxHealth(40D);
        player.setHealth(40D);
    }

    @EventHandler(priority= EventPriority.LOWEST)
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.setMaxHealth(40D);
        player.setHealth(40D);
    }

    @EventHandler(priority= EventPriority.LOWEST)
    public void onEquip(PvpClassEquipEvent e) {
        UUID uuid = e.getPlayer();
        Player player = Bukkit.getPlayer(uuid);
        player.setMaxHealth(40D);
        player.setHealth(40D);
    }
}
