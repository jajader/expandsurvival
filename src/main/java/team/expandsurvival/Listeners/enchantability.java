package team.expandsurvival.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;

public class enchantability implements Listener {

    HashMap<String, Boolean> Cooltime = new HashMap<>();



    //@EventHandler
    //public void on(PlayerInteractEvent e)
    //{
    //    e.getPlayer().sendMessage(String.valueOf(e.getAction()));
//
//
    //    //interactive block이 exclude 되었다고 가정하면
    //    String nameskill;
    //    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
    //    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;
    //    if (e.getItem() == null) return;
    //    //if (ChatColor.stripColor(String.valueOf(e.getItem().getItemMeta().getLore())).contains("Goat")) {
    //        nameskill = e.getPlayer().getDisplayName() + "Goat";
    //    //}
//
    //    if (e.getHand() == EquipmentSlot.OFF_HAND) return;
    //    if (!(Cooltime.get(nameskill) == null)) {
    //        if (Cooltime.get(nameskill)) {
    //            return;
    //        }
    //    }
    //    //ChatColor.stripColor(String.valueOf(e.getItem().getItemMeta().getLore())).contains("날카"))
    //    Cooltime.put(nameskill, true);
    //    e.getPlayer().getLocation().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.GOAT);
    //    try {
    //        Thread.sleep(5000);
    //    } catch (InterruptedException ef) {
    //    }
    //    Cooltime.put(nameskill, false);
//
//
    //}

    @EventHandler
    public void on(PlayerInteractEntityEvent e)
    {
        e.getPlayer().sendMessage(String.valueOf(e.getRightClicked()));
    }

    @EventHandler
    public void newore(BlockBreakEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
       if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
            return;
       }

       if (e.getBlock().getType() == Material.DEEPSLATE) {
           double i = Math.random();
           if (0<=i && i <= 0.09) {
               ItemStack newore = new ItemStack(Material.IRON_NUGGET);
               ItemMeta noMeta = newore.getItemMeta();
               noMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"이베르카늄");
               noMeta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
               newore.setItemMeta(noMeta);

               e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(),  newore);
           }
       }
        if (e.getBlock().getType() == Material.STONE) {
            double i = Math.random();
            if (0<=i && i <= 0.09) {
                ItemStack newore = new ItemStack(Material.IRON_NUGGET);
                ItemMeta noMeta = newore.getItemMeta();
                noMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"이베르카늄");
                noMeta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
                newore.setItemMeta(noMeta);

                e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(),  newore);
            }
        }

       if (!(e.getBlock().getType()== Material.DIAMOND_ORE || e.getBlock().getType()== Material.EMERALD_ORE|| e.getBlock().getType()== Material.GOLD_ORE|| e.getBlock().getType()== Material.IRON_ORE || e.getBlock().getType()== Material.DEEPSLATE_DIAMOND_ORE || e.getBlock().getType()== Material.DEEPSLATE_EMERALD_ORE|| e.getBlock().getType()== Material.DEEPSLATE_GOLD_ORE|| e.getBlock().getType()== Material.DEEPSLATE_IRON_ORE))
       {
           return;
       }
       double i = Math.random();
       if (0<=i && i <= 0.7) {
           ItemStack newore = new ItemStack(Material.IRON_NUGGET);
           ItemMeta noMeta = newore.getItemMeta();
           noMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"이베르카늄");
           noMeta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
           newore.setItemMeta(noMeta);

           e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(),  newore);
       }

    }

}
