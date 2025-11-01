package team.expandsurvival.Listeners;

import org.bukkit.*;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import team.expandsurvival.Expandsurvival;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class CoolDown implements Listener {
    private final HashMap<UUID, Double> Cooldownarrow = new HashMap<>();
    private final HashMap<UUID, Double> Cooldownthrow = new HashMap<>();
    private final HashMap<UUID, Double> Cooldownaspect = new HashMap<>();
    private final HashMap<UUID, Double> Cooldownresi = new HashMap<>();
    private final HashMap<UUID, Double> resi = new HashMap<>();
    JavaPlugin plugin;
    private Vector getDir(double yaw, double dirY, double angleAdd) //바라보는 방향을 벡터로 가져오는 함수
    {
        double dirX = Math.cos(Math.toRadians(yaw + 90 + angleAdd));
        double dirZ = Math.sin(Math.toRadians(yaw + 90 + angleAdd));
        return new Vector(dirX, dirY, dirZ);
    }





    //@EventHandler
    //public void Cooldown2(PlayerInteractEvent e)
    //{
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
    //    if (e.getHand() == EquipmentSlot.OFF_HAND) return;
    //    if (ChatColor.stripColor(String.valueOf(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore())).contains("Arrow Of Explosion")) {
//
    //        Player player = e.getPlayer();
    //        if (!this.Cooldown.containsKey(e.getPlayer().getUniqueId())) {
    //            this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
    //            //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
//
    //            //Random random = new Random();
    //            //Arrow pr = player.launchProjectile(Arrow.class);
    //            //pr.setCustomName("shotgun");
    //            //pr.setCritical(true);   //화살의 이펙트를 위해 크리티컬 판정을 설정
    //            //pr.setDamage(3);
    //        } else {
    //            long taketime = System.currentTimeMillis() - Cooldown.get(e.getPlayer().getUniqueId());
    //            if (taketime < 10000) {
    //                e.getPlayer().sendMessage(ChatColor.RED + "쿨타임 : " + ChatColor.RED + ((10000 - taketime) / 1000) + ChatColor.RED + "초");
    //            } else {
    //                this.Cooldown.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
    //                //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
    //                //Random random = new Random();
    //                //Arrow pr = player.launchProjectile(Arrow.class);
    //                //pr.setCustomName("shotgun");
    //                //pr.setCritical(true);   //화살의 이펙트를 위해 크리티컬 판정을 설정
    //                //pr.setDamage(3);
    //
    //
    //            }
    //        }
    //    }
    //}






    @EventHandler
    public void Skills(PlayerInteractEvent e)
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
        String skill = "";
        if (ChatColor.stripColor(String.valueOf(e.getPlayer().getInventory().
                getItemInMainHand().getItemMeta().getLore())).contains("Arrow Of Explosion")) {
            skill = "Arrow";
        }
        if (ChatColor.stripColor(String.valueOf(e.getPlayer().getInventory().
                getItemInMainHand().getItemMeta().getLore())).contains("척도")) {
            skill = "척도";

        }
        if (ChatColor.stripColor(String.valueOf(e.getPlayer().getInventory().
                getItemInMainHand().getItemMeta().getLore())).contains("공간 도약")) {
            skill = "공간 도약";

        }
        if (ChatColor.stripColor(String.valueOf(e.getPlayer().getInventory().
                getItemInMainHand().getItemMeta().getLore())).contains("Deathless in Death")) {
            skill = "Deathless in Death";

        }

            Player player = e.getPlayer();

        //this.Cooldownarrow.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
        //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
        if (skill  == "Arrow") {

            if (this.Cooldownarrow.containsKey(e.getPlayer().getUniqueId())) {
                double taketime = System.currentTimeMillis() - Cooldownarrow.get(e.getPlayer().getUniqueId());
                if (taketime < 2000) {
                    e.getPlayer().sendMessage(ChatColor.RED + "Arrow Of Explosion 스킬의 쿨타임 : " + ChatColor.RED + ((2000 - taketime) / 1000) + ChatColor.RED + "초");
                } else {
                    this.Cooldownarrow.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                    //e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
                    Arrow pr = player.launchProjectile(Arrow.class);
                    pr.setCustomName("shotgun");
                    pr.setCritical(true);   //화살의 이펙트를 위해 크리티컬 판정을 설정
                    pr.setDamage(0.5);
                }
            } else {
                this.Cooldownarrow.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                Arrow pr = player.launchProjectile(Arrow.class);
                pr.setCustomName("shotgun");
                pr.setCritical(true);   //화살의 이펙트를 위해 크리티컬 판정을 설정
                pr.setDamage(0.5);

            }
        } else if (skill == "척도") {

            if (this.Cooldownthrow.containsKey(e.getPlayer().getUniqueId())) {
                double taketime = System.currentTimeMillis() - Cooldownthrow.get(e.getPlayer().getUniqueId());
                if (taketime < 15000) {
                    e.getPlayer().sendMessage(ChatColor.RED + "척도 스킬의 쿨타임 : " + ChatColor.RED + ((15000 - taketime) / 1000) + ChatColor.RED + "초");
                } else {
                    this.Cooldownthrow.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                    sword(player);
                }
            } else {
                this.Cooldownthrow.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                sword(player);

            }
        } else if (skill == "공간 도약") {

            if (this.Cooldownaspect.containsKey(e.getPlayer().getUniqueId())) {
                double taketime = System.currentTimeMillis() - Cooldownaspect.get(e.getPlayer().getUniqueId());
                if (taketime < 1000) {
                    e.getPlayer().sendMessage(ChatColor.RED + "공간 도약 스킬의 쿨타임 : " + ChatColor.RED + ((1000 - taketime) / 1000) + ChatColor.RED + "초");
                } else {
                    this.Cooldownaspect.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                    player.setVelocity(player.getLocation().getDirection().setY(0).multiply(7));
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 30.0F, 0.0F);
                }
            } else {
                this.Cooldownaspect.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());

                player.setVelocity(player.getLocation().getDirection().setY(0).multiply(7));
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 30.0F, 0.0F);

            }
        } else if (skill == "Deathless in Death") {

            if (this.Cooldownresi.containsKey(e.getPlayer().getUniqueId())) {
                double taketime = System.currentTimeMillis() - Cooldownresi.get(e.getPlayer().getUniqueId());
                if (taketime < 50000) {
                    e.getPlayer().sendMessage(ChatColor.RED + "Deathless in Death 스킬의 쿨타임 : " + ChatColor.RED + ((50000 - taketime) / 1000) + ChatColor.RED + "초");
                } else {
                    this.Cooldownresi.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                    Death(player);
                }
            } else {
                this.Cooldownresi.put(e.getPlayer().getUniqueId(), (double) System.currentTimeMillis());
                Death(player);


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

    public void Death(Player p) {
        p.setGlowing(true);
        p.setInvulnerable(true);
        p.getLocation().getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 250, 2,2, 2);
        p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 40.0F, 0.0F);
        double start = (double) System.currentTimeMillis();

        BukkitRunnable brun = new BukkitRunnable() {
            public void run() {
                if (((double) System.currentTimeMillis()) - start > 5000) {
                    p.setGlowing(false);
                    p.setInvulnerable(false);
                    cancel();
                }


            }
        };
        brun.runTaskTimer(Expandsurvival.getPlugin(), 0L, 0L);
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        if (e.getPlayer().isInvulnerable()) {
            e.getPlayer().setInvulnerable(false);
            e.getPlayer().setGlowing(false);
        }
    }

    @EventHandler
    public void quit(PlayerJoinEvent e) {
        if (e.getPlayer().isInvulnerable()) {
            e.getPlayer().setInvulnerable(false);
            e.getPlayer().setGlowing(false);
        }
    }





    public void sword(Player p) {
        final ArmorStand Ar = p.getLocation().getWorld().spawn(p.getLocation(), ArmorStand.class, Arr -> {
            Arr.setVisible(false);
        });
        Ar.setArms(true);
        Ar.setRightArmPose(new EulerAngle(0.0D, 0.0D, 0.0D));
        Ar.setVelocity(p.getLocation().getDirection().multiply(3));
        ItemStack dia = p.getInventory().getItemInMainHand();
        Ar.setItemInHand(dia);
        Ar.addScoreboardTag("sword");
        Ar.setGravity(false);
        Ar.setCanPickupItems(false);
        //e.setCancelled(true);
        Ar.setMarker(true);
        BukkitRunnable brun = new BukkitRunnable() {
            public void run() {
                Ar.teleport(Ar.getLocation().add(Ar.getVelocity().multiply(0.5D)));
                double ax = Ar.getLocation().getX();
                double ay = Ar.getLocation().getY();
                double az = Ar.getLocation().getZ();
                ay++;
                Location loc = new Location(Ar.getWorld(), ax, ay, az);
                if (loc.getBlock().getType() != Material.AIR && loc.getBlock().getType() != Material.WATER) {
                    p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_RETURN, 30.0F, 0.0F);
                    cancel();
                    Ar.remove();
                }
                if (loc.getY() >= 500) {
                    cancel();
                    Ar.remove();
                }
                if (Math.abs(Ar.getVelocity().getX())<0.5)  {
                    if (Math.abs(Ar.getVelocity().getY())<0.5)  {
                        if (Math.abs(Ar.getVelocity().getZ())<0.5)  {
                            cancel();
                            Ar.remove();
                        }
                    }
                }
                for (World w : Bukkit.getWorlds()) {
                    if (w != p.getWorld()) return;
                    for (Entity en : w.getEntities()) {
                        if (en.getWorld() != Ar.getWorld()) return;
                        if (en instanceof LivingEntity &&
                                en.getLocation().distance(Ar.getLocation()) <= 1.0D) {
                            ((LivingEntity)en).damage(60.0D, p);
                            if (!(en instanceof ArmorStand))
                                en.setVelocity(p.getLocation().getDirection().normalize().multiply(1));
                        }
                    }
                }
            }
        };
        brun.runTaskTimer(Expandsurvival.getPlugin(), 0L, 0L);

    }

}
