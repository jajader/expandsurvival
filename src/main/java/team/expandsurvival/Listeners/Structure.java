package team.expandsurvival.Listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Structure implements Listener {

    @EventHandler
    public void onPlayerClickSBWT(PlayerInteractEvent e) {


        Player p = e.getPlayer();

        if (e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;


        //강화블럭 부수기
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType().equals(Material.STRUCTURE_BLOCK)) {
                Block b = e.getClickedBlock();
                ItemStack tp = new ItemStack(b.getType());
                b.breakNaturally();
                ItemStack tps = new ItemStack(Material.STRUCTURE_BLOCK);
                ItemMeta st = tps.getItemMeta();
                st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_BREAK, 0.5f, 1);
                tps.setItemMeta(st);
                b.getLocation().getWorld().dropItemNaturally(b.getLocation(), tps);
            }
            return;
        }
        if (e.getItem() == null) return;

        //우클릭한 아이템이 구조물블럭(강화블럭)인 경우
        if (e.getItem().getType().equals(Material.STRUCTURE_BLOCK)) {
            Block b = e.getClickedBlock();

            Location loc = b.getLocation();
            //강화블럭 설치 코드
            switch (String.valueOf(e.getBlockFace())) {
                case "UP":
                    loc.setY(loc.getY() + 1);
                    if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA) {
                        loc.getBlock().setType(Material.STRUCTURE_BLOCK);
                        ItemStack Struc = new ItemStack(Material.STRUCTURE_BLOCK, 1);
                        ItemMeta st = Struc.getItemMeta();
                        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                        Struc.setItemMeta(st);
                        p.getInventory().removeItem(Struc);
                        p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 0.5f, 1);
                        return;
                    }
                case "DOWN":
                    loc.setY(loc.getY() - 1);
                    if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA) {
                        loc.getBlock().setType(Material.STRUCTURE_BLOCK);
                        ItemStack Struc = new ItemStack(Material.STRUCTURE_BLOCK, 1);
                        ItemMeta st = Struc.getItemMeta();
                        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                        Struc.setItemMeta(st);
                        p.getInventory().removeItem(Struc);
                        p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 0.5f, 1);
                        return;
                    }
                case "WEST":
                    loc.setX(loc.getX() - 1);
                    if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA) {
                        loc.getBlock().setType(Material.STRUCTURE_BLOCK);
                        ItemStack Struc = new ItemStack(Material.STRUCTURE_BLOCK, 1);
                        ItemMeta st = Struc.getItemMeta();
                        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                        Struc.setItemMeta(st);
                        p.getInventory().removeItem(Struc);
                        p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 0.5f, 1);
                        return;
                    }
                case "EAST":
                    loc.setX(loc.getX() + 1);
                    if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA) {
                        loc.getBlock().setType(Material.STRUCTURE_BLOCK);
                        ItemStack Struc = new ItemStack(Material.STRUCTURE_BLOCK, 1);
                        ItemMeta st = Struc.getItemMeta();
                        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                        Struc.setItemMeta(st);
                        p.getInventory().removeItem(Struc);
                        p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 0.5f, 1);
                        return;
                    }
                case "SOUTH":
                    loc.setZ(loc.getZ() + 1);
                    if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA) {
                        loc.getBlock().setType(Material.STRUCTURE_BLOCK);
                        ItemStack Struc = new ItemStack(Material.STRUCTURE_BLOCK, 1);
                        ItemMeta st = Struc.getItemMeta();
                        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                        Struc.setItemMeta(st);
                        p.getInventory().removeItem(Struc);
                        p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 0.5f, 1);
                        return;
                    }
                case "NORTH":
                    loc.setZ(loc.getZ() - 1);
                    if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA) {
                        loc.getBlock().setType(Material.STRUCTURE_BLOCK);
                        ItemStack Struc = new ItemStack(Material.STRUCTURE_BLOCK, 1);
                        ItemMeta st = Struc.getItemMeta();
                        st.setDisplayName(ChatColor.LIGHT_PURPLE + "강화 블록");
                        Struc.setItemMeta(st);
                        p.getInventory().removeItem(Struc);
                        p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 0.5f, 1);
                        return;
                    }

            }
        }

        /* 여기까지 블럭 설치(강화 블럭) */

    }
}
