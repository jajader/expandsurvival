package team.expandsurvival.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class enchantability implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e)
    {
        e.getPlayer().sendMessage(String.valueOf(e.getAction()));
    }

    @EventHandler
    public void newore(BlockBreakEvent e) {
       if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
            return;
       }

       if (e.getBlock().getType() == Material.DEEPSLATE) {
           double i = Math.random();
           if (0<=i && i <= 0.09) {
               ItemStack newore = new ItemStack(Material.IRON_NUGGET);
               ItemMeta noMeta = newore.getItemMeta();
               noMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"");
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
                noMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"");
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
           noMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"");
           noMeta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
           newore.setItemMeta(noMeta);

           e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(),  newore);
       }

    }

}
