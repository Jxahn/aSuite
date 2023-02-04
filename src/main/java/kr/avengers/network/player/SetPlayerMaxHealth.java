package kr.avengers.network.player;

import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.classes.event.PvpClassEquipEvent;
import me.qiooip.lazarus.classes.event.PvpClassUnequipEvent;
import me.qiooip.lazarus.handlers.logger.CombatLogger;
import me.qiooip.lazarus.handlers.logger.CombatLoggerHandler;
import me.qiooip.lazarus.handlers.timer.CombatTagHandler;
import me.qiooip.lazarus.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.UUID;

public class SetPlayerMaxHealth implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.setMaxHealth(40D);
        player.setHealth(PlayerStatics.Health);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        PlayerStatics.Health = player.getHealth();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onUnEquip(PvpClassUnequipEvent e) {
        UUID uuid = e.getPlayer();
        Player player = Bukkit.getPlayer(uuid);
        player.setMaxHealth(40D);
        PlayerStatics.Health2 = player.getHealth();

        if (PlayerStatics.Health2 <= 0) {
            player.setMaxHealth(40D);
            PlayerStatics.Health2 = 40D;
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEquip(PvpClassEquipEvent e) {
        UUID uuid = e.getPlayer();
        Player player = Bukkit.getPlayer(uuid);

        player.setMaxHealth(40D);
        player.setHealth(PlayerStatics.Health2);
    }
}
