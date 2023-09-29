package team.expandsurvival;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import team.expandsurvival.Listeners.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public final class Expandsurvival extends JavaPlugin {


    @Override
    public void onEnable() {
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
        recipe.setIngredient('I', Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
        Bukkit.addRecipe(recipe);



    }

    @Override
    public void onDisable() {
        getLogger().info("ExpandSurvival disabling.....");
    }
}
