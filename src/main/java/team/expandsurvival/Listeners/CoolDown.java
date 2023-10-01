package team.expandsurvival.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
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
    JavaPlugin plugin;
    private Vector getDir(double yaw, double dirY, double angleAdd) //바라보는 방향을 벡터로 가져오는 함수
    {
        double dirX = Math.cos(Math.toRadians(yaw + 90 + angleAdd));
        double dirZ = Math.sin(Math.toRadians(yaw + 90 + angleAdd));
        return new Vector(dirX, dirY, dirZ);
    }





    @EventHandler
    public void Cooldown(PlayerInteractEvent e)
    {
        if (e.getItem() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) return;
        if (e.getAction() == Action.LEFT_CLICK_AIR) return;
        if (!(e.getClickedBlock() == null)) {
            if (e.getClickedBlock().getType().isInteractable()) {
                if (!e.getPlayer().isSneaking()) {
                    return;
                }
            }
        }
        if (e.getHand() == EquipmentSlot.OFF_HAND) return;
        if (ChatColor.stripColor(String.valueOf(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore())).contains("Arrow Of Explosion")) {

            Player player = e.getPlayer();
            if (!this.Cooldown.containsKey(e.getPlayer().getUniqueId())) {
                this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);

                Random random = new Random();
                Arrow pr = player.launchProjectile(Arrow.class);
                pr.setCustomName("shotgun");
                pr.setCritical(true);   //화살의 이펙트를 위해 크리티컬 판정을 설정
                pr.setDamage(3);
            } else {
                long taketime = System.currentTimeMillis() - Cooldown.get(e.getPlayer().getUniqueId());
                if (taketime < 10000) {
                    e.getPlayer().sendMessage(ChatColor.RED + "쿨타임 : " + ChatColor.RED + ((10000 - taketime) / 1000) + ChatColor.RED + "초");
                } else {
                    this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                    //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
                    Random random = new Random();
                    Arrow pr = player.launchProjectile(Arrow.class);
                    pr.setCustomName("shotgun");
                    pr.setCritical(true);   //화살의 이펙트를 위해 크리티컬 판정을 설정
                    pr.setDamage(3);
                }
            }
        }
    }

    @EventHandler
    public void shotgun(ProjectileHitEvent e) {
        if (e.getEntity().getCustomName() == null) return;
        if (e.getEntity().getCustomName().contains("shotgun")) {
            //arrow.getWorld().createExplosion(arrow.getLocation(), 1);   //화살의 착탄 위치에 폭발 생성

            Arrow arrow = (Arrow)e.getEntity(); //객체를 화살로 변환
            arrow.getWorld().createExplosion(arrow.getLocation(), 1,false,false);   //화살의 착탄 위치에 폭발 생성
            arrow.remove(); //화살 삭제
        }
    }


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


            Vector direction = e.getPlayer().getLocation().toVector().subtract(e.getRightClicked().getLocation().toVector()).normalize();
            e.getRightClicked().setVelocity(direction);

        } else {
            long taketime = System.currentTimeMillis() - Cooldown.get(e.getPlayer().getUniqueId());
            if (taketime < 10000) {
                e.getPlayer().sendMessage(ChatColor.RED + "쿨타임 : " + ChatColor.RED + (((10000-taketime)/1000))+ChatColor.RED + "초");
            } else {
                this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
                Vector direction = e.getPlayer().getLocation().toVector().subtract(e.getRightClicked().getLocation().toVector()).normalize();
                e.getRightClicked().setVelocity(direction);



            }
        }
    }
}
