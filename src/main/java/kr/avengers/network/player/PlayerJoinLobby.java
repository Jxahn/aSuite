package kr.avengers.network.player;

import com.lunarclient.bukkitapi.LunarClientAPI;
import com.lunarclient.bukkitapi.title.LCTitleBuilder;
import com.lunarclient.bukkitapi.title.TitleType;
import me.qiooip.lazarus.lunarclient.LunarClientManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.Duration;

public class PlayerJoinLobby implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (LunarClientAPI.getInstance().isRunningLunarClient(player.getUniqueId())) {
            LCTitleBuilder.of(ChatColor.DARK_BLUE + "Avengers").displayFor(Duration.ofSeconds(5)).sendAndBuild(e.getPlayer());
            LCTitleBuilder.of(ChatColor.GRAY + "Beta Map", TitleType.SUBTITLE).displayFor(Duration.ofSeconds(5)).sendAndBuild(e.getPlayer());
        } else {
            player.sendMessage(ChatColor.RED + "You are not using LunarClient! Please use LunarClient");
        }
    }
}
