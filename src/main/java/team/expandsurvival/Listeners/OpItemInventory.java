package team.expandsurvival.Listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpItemInventory implements Listener {



    @EventHandler
    public void onPlayerClickSBWS(PlayerInteractEvent e) {
        // 인벤셋
        Inventory inv = Bukkit.createInventory(null, 36, "강화"+ChatColor.WHITE+"\uF808\uF808\uF801\uEff1");
            // 아이템 설정 //


            Player p = e.getPlayer();

            if (e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;
            if (e.getItem() == null) return;

            if (e.getHand() == EquipmentSlot.OFF_HAND) return;
            /* GUI 열기 및 lore 설정*/
            if (e.getClickedBlock().getType().equals(Material.STRUCTURE_BLOCK)) {

                if (e.getItem().getType().equals(Material.IRON_SWORD) || e.getItem().getType().equals(Material.WOODEN_SWORD) || e.getItem().getType().equals(Material.STONE_SWORD) || e.getItem().getType().equals(Material.GOLDEN_SWORD) || e.getItem().getType().equals(Material.DIAMOND_SWORD) || e.getItem().getType().equals(Material.NETHERITE_SWORD)) {
                    ItemStack k = e.getItem();
                    if (k.getItemMeta().getLore() != null) {
                        String lore = k.getItemMeta().getLore().toString();
                        if (lore.contains("✪")) {
                            return;
                        }
                    }
                    int havda = 0;
                    for (int t=64; t>0;t--) {
                        ItemStack i = new ItemStack(Material.IRON_NUGGET, t);
                        ItemMeta no1Meta = i.getItemMeta();
                        no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE+"");
                        no1Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
                        i.setItemMeta(no1Meta);
                        if (p.getInventory().contains(i)) {
                            havda=t;
                            break;
                        }
                    }

                    if (havda == 0) {
                        return;
                    }
                    ItemStack i = new ItemStack(Material.IRON_NUGGET, havda);
                    ItemMeta no1Meta = i.getItemMeta();
                    no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE+"");
                    no1Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
                    i.setItemMeta(no1Meta);
                    p.getInventory().removeItem(i);
                    inv.setItem(21, i);



                    e.setCancelled(true);
                    p.openInventory(inv);
                    ItemStack it = new ItemStack(Material.AIR);
                    int slot = p.getInventory().getHeldItemSlot();
                    ItemStack air = new ItemStack(Material.AIR);
                    p.getInventory().setItem(slot, air);

                    inv.setItem(24, k);
                    inv.setItem(19, k);
                    ItemStack kp = inv.getItem(24);

                    ItemMeta swordMeta = kp.getItemMeta();   //검의 메타데이터
                    swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    int pt = 0;
                    if (swordMeta.getLore() != null) {
                        String lore = swordMeta.getLore().toString();
                        lore = lore.replaceAll("[^☆✪★]", "");


                        if (lore.contains("★☆☆☆☆☆☆☆☆☆")) {
                            pt = 1;
                        } else if (lore.contains("★★☆☆☆☆☆☆☆☆")) {
                            pt = 2;
                        } else if (lore.contains("★★★☆☆☆☆☆☆☆")) {
                            pt = 3;
                        } else if (lore.contains("★★★★☆☆☆☆☆☆")) {
                            pt = 4;
                        } else if (lore.contains("★★★★★☆☆☆☆☆")) {
                            pt = 5;
                        } else if (lore.contains("★★★★★★☆☆☆☆")) {
                            pt = 6;
                        } else if (lore.contains("★★★★★★★☆☆☆")) {
                            pt = 7;
                        } else if (lore.contains("★★★★★★★★☆☆")) {
                            pt = 8;
                        } else if (lore.contains("★★★★★★★★★☆")) {
                            pt = 9;
                        } else if (lore.contains("✪")) {
                            p.closeInventory();
                        }



                    } else {
                        pt = 0;
                    }
                    double tjdrhd = 100-8.5*pt;
                    double dbwl = 4*pt;
                    double vkrhl = 4.5*pt;
                    switch (pt) {
                        case 0:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"★☆☆☆☆☆☆☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 1:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"★★☆☆☆☆☆☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 2:
                            swordMeta.setLore(Arrays.asList(ChatColor.STRIKETHROUGH+(ChatColor.GOLD+"★★★☆☆☆☆☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 3:
                            swordMeta.setLore(Arrays.asList(ChatColor.UNDERLINE+(ChatColor.GOLD+"★★★★☆☆☆☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 4:
                            swordMeta.setLore(Arrays.asList(ChatColor.MAGIC+(ChatColor.GOLD+"★★★★★☆☆☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 5:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"★★★★★★☆☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 6:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"★★★★★★★☆☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 7:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"★★★★★★★★☆☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 8:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"★★★★★★★★★☆"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;
                        case 9:
                            swordMeta.setLore(Arrays.asList(ChatColor.ITALIC+(ChatColor.GOLD+"✪"), ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                            break;


                    }



                    kp.setItemMeta(swordMeta);
                    inv.setItem(24, kp);




                }

        }
    }

    }
