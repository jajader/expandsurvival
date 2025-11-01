package team.expandsurvival;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import team.expandsurvival.Listeners.*;

import java.util.Arrays;

public final class Expandsurvival extends JavaPlugin implements Listener {

    private static Expandsurvival plugin;


    @Override
    public void onEnable() {
        setPlugin(this);
        // Plugin startup logic
        getLogger().info("ExpandSurvival Starting");
        ItemStack k = new ItemStack(Material.AIR);
        getServer().getPluginManager().registerEvents(new OpItemInventory(), this);
        getServer().getPluginManager().registerEvents(new Clickand(), this);
        getServer().getPluginManager().registerEvents(new EndEyes(), this);
        getServer().getPluginManager().registerEvents(new Structure(), this);
        getServer().getPluginManager().registerEvents(new SWPassive(), this);
        getServer().getPluginManager().registerEvents(new enchantability(), this);
        getServer().getPluginManager().registerEvents(new CoolDown(), this);
        getServer().getPluginManager().registerEvents(this,this);
        ItemStack Sb = new ItemStack(Material.STRUCTURE_BLOCK);
        ItemMeta st = Sb.getItemMeta();
        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
        Sb.setItemMeta(st);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "StructureBlock"), Sb);
        recipe.shape("ABC", "DEF", "GHI");
        recipe.setIngredient('A', Material.TORCHFLOWER);
        recipe.setIngredient('B', Material.NAME_TAG);
        recipe.setIngredient('C', Material.TURTLE_HELMET);
        recipe.setIngredient('D', Material.CALIBRATED_SCULK_SENSOR);
        recipe.setIngredient('E', Material.DIAMOND);
        recipe.setIngredient('F', Material.WAXED_EXPOSED_CUT_COPPER_SLAB);
        recipe.setIngredient('G', Material.NAUTILUS_SHELL);
        recipe.setIngredient('H', Material.BLUE_ICE);
        recipe.setIngredient('I', Material.HEART_OF_THE_SEA);
        Bukkit.addRecipe(recipe);


        ItemStack zeta = new ItemStack(Material.DISC_FRAGMENT_5);
        ItemMeta zetameta = zeta.getItemMeta();
        zetameta.setDisplayName(ChatColor.LIGHT_PURPLE + "제타석");
        zetameta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
        zeta.setItemMeta(zetameta);
        ShapedRecipe zetarecipe = new ShapedRecipe(new NamespacedKey(this, "zetastone"), zeta);
        zetarecipe.shape("KKK", "KJK", "KKK");
        zetarecipe.setIngredient('K', Material.REINFORCED_DEEPSLATE);
        zetarecipe.setIngredient('J', Material.IRON_INGOT);
        Bukkit.addRecipe(zetarecipe);


//

    }

    @Override
    public void onDisable() {
        getLogger().info("ExpandSurvival disabling.....");
    }


    public static Expandsurvival getPlugin() {
        return plugin;
    }

    public static void setPlugin(Expandsurvival plugin) {
        Expandsurvival.plugin = plugin;
    }

    //@EventHandler
    //public void sowrd(PlayerInteractEvent e) {
    //    final Player p = e.getPlayer();
    //    if (p.getItemInHand().getType().equals(Material.DIAMOND_SWORD) && (
    //            e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
    //        final ArmorStand Ar = (ArmorStand)p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
    //        Ar.setVisible(false);
    //        Ar.setArms(true);
    //        Ar.setRightArmPose(new EulerAngle(0.0D, 0.0D, 0.0D));
    //        Ar.setVelocity(p.getLocation().getDirection().multiply(5));
    //        ItemStack dia = new ItemStack(Material.DIAMOND_SWORD);
    //        Ar.setItemInHand(dia);
    //        Ar.addScoreboardTag("sword");
    //        Ar.setGravity(false);
    //        Ar.setCanPickupItems(false);
    //        e.setCancelled(true);
    //        Ar.setMarker(true);
    //        BukkitRunnable brun = new BukkitRunnable() {
    //            public void run() {
    //                Ar.teleport(Ar.getLocation().add(Ar.getVelocity().multiply(0.8D)));
    //                double ax = Ar.getLocation().getX();
    //                double ay = Ar.getLocation().getY();
    //                double az = Ar.getLocation().getZ();
    //                ay++;
    //                Location loc = new Location(Ar.getWorld(), ax, ay, az);
    //                if (loc.getBlock().getType() != Material.AIR) {
    //                    p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_RETURN, 44.0F, 0.0F);
    //                    cancel();
    //                    Ar.remove();
    //                }
    //                if (loc.getY() >= 500) {
    //                    cancel();
    //                    Ar.remove();
    //                }
    //                if (Math.abs(Ar.getVelocity().getX())<0.5)  {
    //                    if (Math.abs(Ar.getVelocity().getY())<0.5)  {
    //                        if (Math.abs(Ar.getVelocity().getZ())<0.5)  {
    //                            cancel();
    //                            Ar.remove();
    //                        }
    //                    }
    //                }
    //                for (World w : Bukkit.getWorlds()) {
    //                    if (w != p.getWorld()) return;
    //                    for (Entity en : w.getEntities()) {
    //                        if (en.getWorld() != Ar.getWorld()) return;
    //                        if (en instanceof LivingEntity &&
    //                                en.getLocation().distance(Ar.getLocation()) <= 1.0D) {
    //                            ((LivingEntity)en).damage(7.0D);
    //                            if (!(en instanceof ArmorStand))
    //                                en.setVelocity(p.getLocation().getDirection().normalize().multiply(1));
    //                        }
    //                    }
    //                }
    //            }
    //        };
    //        brun.runTaskTimer(this, 0L, 0L);
    //    }

            //@EventHandler
            //public void sowrd(PlayerInteractEvent e) {
            //    final Player p = e.getPlayer();
            //    if (p.getItemInHand().getType().equals(Material.DIAMOND_SWORD) && (
            //            e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            //                final ArmorStand Ar = (ArmorStand)p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
            //                Ar.setVisible(false);
            //                Ar.setArms(true);
            //                Ar.setRightArmPose(new EulerAngle(0.0D, 0.0D, 0.0D));
            //                Ar.setVelocity(p.getLocation().getDirection().multiply(5));
            //                ItemStack dia = new ItemStack(Material.DIAMOND_SWORD);
            //                Ar.setItemInHand(dia);
            //                Ar.addScoreboardTag("sword");
            //                Ar.setCanPickupItems(false);
            //                e.setCancelled(true);
            //                Ar.setMarker(true);
            //                double ax = Ar.getLocation().getX();
            //                double ay = Ar.getLocation().getY();
            //                double az = Ar.getLocation().getZ();
            //                ay++;
            //                Location loc = new Location(Ar.getWorld(), ax, ay, az);
        //
        //
            //                BukkitRunnable brun = new BukkitRunnable() {
            //                    public void run() {
            //                        for (World w : Bukkit.getWorlds()) {
            //                            if (w != p.getWorld()) return;
            //                            for (Entity en : w.getEntities()) {
            //                                if (en.getWorld() != Ar.getWorld()) return;
            //                                if (en instanceof LivingEntity &&
            //                                        en.getLocation().distance(Ar.getLocation()) <= 1.0D) {
            //                                    ((LivingEntity)en).damage(7.0D);
        //
            //                                }
            //                            }
            //                        }
        //
            //                    }
        //
        //
            //                };
            //                BukkitRunnable bbrun = new BukkitRunnable() {
            //                    public void run() {
            //                        if (loc.getBlock().getType() != Material.AIR &&  loc.getBlock().getType() != Material.LAVA &&  loc.getBlock().getType() != Material.WATER) {
            //                            p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_HIT_GROUND, 100.0F, 0.0F);
            //                            long time = System.currentTimeMillis();
            //                            cancel();
            //                            while (System.currentTimeMillis()  -time < 1500) {
            //                            }
            //                            Vector direction = e.getPlayer().getLocation().toVector().subtract(Ar.getLocation().toVector()).normalize();
            //                            Ar.setVelocity(direction);
        //
            //                        }
        //
            //                    }
        //
        //
            //                };
        //
            //            brun.runTaskTimer((Plugin)this, 0L, 0L);
            //            bbrun.runTaskTimer((Plugin)this, 0L, 0L);
            //    }
            //}
}





