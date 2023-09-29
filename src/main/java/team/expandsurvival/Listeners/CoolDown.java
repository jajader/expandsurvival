package team.expandsurvival.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class CoolDown implements Listener {
    private final HashMap<UUID, Long> Cooldown = new HashMap<>();

    private Vector getDir(double yaw, double dirY, double angleAdd) //바라보는 방향을 벡터로 가져오는 함수
    {
        double dirX = Math.cos(Math.toRadians(yaw + 90 + angleAdd));
        double dirZ = Math.sin(Math.toRadians(yaw + 90 + angleAdd));
        return new Vector(dirX, dirY, dirZ);
    }





            //@EventHandler
            //public void Cooldown(PlayerInteractEvent e)
            //{
        //
            //    if (e.getItem() == null) return;
            //    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
            //    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;
            //    if (e.getAction() == Action.LEFT_CLICK_BLOCK) return;
            //    if (e.getAction() == Action.LEFT_CLICK_AIR) return;
            //    if (!(e.getClickedBlock() == null)) {
            //        if (e.getClickedBlock().getType().isInteractable()) {
            //            if (!e.getPlayer().isSneaking()) {
            //                return;
            //            }
            //        }
            //    }
        //
            //    if (e.getHand() == EquipmentSlot.OFF_HAND) return;
            //    Player player = e.getPlayer();
            //    if (!this.Cooldown.containsKey(e.getPlayer().getUniqueId())) {
            //        this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
            //        //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
            //        player.sendMessage("1");
        //
        //
            //    } else {
            //        player.sendMessage("2");
            //        long taketime = System.currentTimeMillis() - Cooldown.get(e.getPlayer().getUniqueId());
            //        if (taketime < 10000) {
            //            e.getPlayer().sendMessage(ChatColor.RED + "쿨타임 : " + ChatColor.RED + ((10000-taketime)/1000)+ChatColor.RED + "초");
            //        } else {
            //            player.sendMessage("3");
            //            this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
            //            //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
        //
        //
        //
            //        }
            //    }
        //
        //
        //
        //
            //}


    @EventHandler
    public void on(PlayerInteractEntityEvent e)
    {
        if (e.getPlayer().getInventory().getItemInMainHand() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;
        if (!e.getPlayer().isSneaking()) return;

        if (e.getHand() == EquipmentSlot.OFF_HAND) return;
        Player player = e.getPlayer();
        if (!this.Cooldown.containsKey(e.getPlayer().getUniqueId())) {
            this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
            //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
            player.sendMessage("1");

            Vector direction = e.getPlayer().getLocation().toVector().subtract(e.getRightClicked().getLocation().toVector()).normalize();
            direction.multiply(3);
            e.getRightClicked().setVelocity(direction);

        } else {
            player.sendMessage("2");
            long taketime = System.currentTimeMillis() - Cooldown.get(e.getPlayer().getUniqueId());
            if (taketime < 10000) {
                e.getPlayer().sendMessage(ChatColor.RED + "쿨타임 : " + ChatColor.RED + ((10000-taketime)/1000)+ChatColor.RED + "초");
            } else {
                player.sendMessage("3");
                this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
                Vector direction = e.getPlayer().getLocation().toVector().subtract(e.getRightClicked().getLocation().toVector()).normalize();
                e.getRightClicked().setVelocity(direction);



            }
        }
    }
}
