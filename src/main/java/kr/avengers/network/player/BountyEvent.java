package kr.avengers.network.player;

import me.qiooip.lazarus.Lazarus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BountyEvent implements Listener {

    public static ArrayList<UUID> bounty = new ArrayList<UUID>();
    public static Map<UUID, Integer> killstreak = new HashMap<UUID, Integer>();

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        Player victim = e.getEntity();
        if (!(killer == victim)) {
            if (killer == null) {
                killstreak.remove(victim.getUniqueId());
            } else {
                if (bounty.contains(victim.getUniqueId())) {
                    bounty.remove(victim.getUniqueId());
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "현상금 사냥꾼 " + ChatColor.RED + ChatColor.BOLD.toString() + killer.getName() + ChatColor.YELLOW + "님이 " + ChatColor.RED + ChatColor.BOLD.toString() + victim.getName() + ChatColor.YELLOW + "님을 죽였습니다!");
                    new Lazarus().getEconomyManager().addBalance(killer, 80);
                }
                killstreak.remove(victim.getUniqueId());

                if (!killstreak.containsKey(killer.getUniqueId())) {
                    killstreak.put(killer.getUniqueId(), 1);
                }

                if (killstreak.containsKey(killer.getUniqueId())) {

                    int streakcount = killstreak.get(killer.getUniqueId());
                    killstreak.put(killer.getUniqueId(), streakcount + 1);
                    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
                    ItemStack web = new ItemStack(Material.WEB, 16);
                    if (streakcount == 10) {
                        bounty.add(killer.getUniqueId());
                        Bukkit.getServer().broadcastMessage(ChatColor.RED + ChatColor.BOLD.toString() + killer.getName() + ChatColor.YELLOW + " 님이 " + ChatColor.LIGHT_PURPLE + "10" + ChatColor.YELLOW + "연킬 중입니다!");
                        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "현상금 " + ChatColor.RED + ChatColor.BOLD.toString() + "80" + ChatColor.YELLOW + " 원!");
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
