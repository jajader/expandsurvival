package team.expandsurvival.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Light;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;
import java.util.UUID;

public class CoolDown implements Listener {
    private final HashMap<UUID, Long> Cooldown = new HashMap<>();





    @EventHandler
    public void Cooldown(PlayerInteractEvent e)
    {

        //interactive block이 exclude 되었다고 가정하면
        if (e.getItem() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;


        if (e.getHand() == EquipmentSlot.OFF_HAND) return;
        if (!this.Cooldown.containsKey(e.getPlayer().getUniqueId())) {
            this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
            e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);

        } else {
            long taketime = System.currentTimeMillis() - Cooldown.get(e.getPlayer().getUniqueId());
            if (taketime < 10000) {
                e.getPlayer().sendMessage(ChatColor.RED + "쿨타임 : " + ChatColor.RED + ((10000-taketime)/1000)+ChatColor.RED + "초");
            } else {
                this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);

            }
        }




    }
}
