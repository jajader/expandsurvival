package team.expandsurvival.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

public class SWPassive implements Listener {

    @EventHandler
    public void SWPassive(PlayerInteractEvent e) {
        Inventory inv = Bukkit.createInventory(null, 27, "기본 능력치 마법 부여"+ ChatColor.WHITE+"\uF808\uF808\uF808\uF808\uF808\uF808\uF808\uF808\uF808\uF808\uF804\uF801\uEff2");
        // 아이템 설정 //


        Player p = e.getPlayer();

        if (e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;
        if (e.getItem() == null) return;

        if (e.getHand() == EquipmentSlot.OFF_HAND) return;
        /* GUI 열기 및 lore 설정*/
        if (e.getClickedBlock().getType().equals(Material.STRUCTURE_BLOCK)) {

            if (e.getItem().getType().equals(Material.IRON_SWORD) || e.getItem().getType().equals(Material.WOODEN_SWORD) || e.getItem().getType().equals(Material.STONE_SWORD) || e.getItem().getType().equals(Material.GOLDEN_SWORD) || e.getItem().getType().equals(Material.DIAMOND_SWORD) || e.getItem().getType().equals(Material.NETHERITE_SWORD)) {
                ItemStack k = e.getItem();
                if (k.getItemMeta().getLore() == null) {
                    return;
                }
                if (k.getItemMeta().getLore() != null) {
                    String lore = k.getItemMeta().getLore().toString();
                    if (!lore.contains("✪")) {
                        return;
                    }
                }

                int havda = 0;
                for (int t = 64; t > 0; t--) {
                    ItemStack i = new ItemStack(Material.DISC_FRAGMENT_5, t);
                    ItemMeta zetameta = i.getItemMeta();
                    zetameta.setDisplayName(ChatColor.LIGHT_PURPLE + "제타석");
                    zetameta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
                    i.setItemMeta(zetameta);
                    if (p.getInventory().contains(i)) {
                        havda = t;
                        break;
                    }
                }

                if (havda == 0) {
                    return;
                }
                ItemStack i = new ItemStack(Material.DISC_FRAGMENT_5, havda);
                ItemMeta no1Meta = i.getItemMeta();
                no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "제타석");
                no1Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
                i.setItemMeta(no1Meta);
                p.getInventory().removeItem(i);
                inv.setItem(20, i);

                int slot = p.getInventory().getHeldItemSlot();
                ItemStack air = new ItemStack(Material.AIR);
                p.getInventory().setItem(slot, air);
                ItemStack sword = e.getItem();
                inv.setItem(19, sword);

                ItemStack shar6 = sword.clone();
                ItemStack shar7 = sword.clone();
                ItemStack shar8 = sword.clone();
                ItemStack shar9 = sword.clone();
                ItemStack shar10 = sword.clone();
                ItemStack aoe = sword.clone();
                ItemStack ts  = sword.clone();
                ItemStack aote  = sword.clone();
                ItemStack Did  = sword.clone();

                ItemMeta shar6Meta = shar6.getItemMeta();
                ItemMeta shar7Meta = shar7.getItemMeta();
                ItemMeta shar8Meta = shar8.getItemMeta();
                ItemMeta shar9Meta = shar9.getItemMeta();
                ItemMeta shar10Meta = shar10.getItemMeta();
                ItemMeta aoeMeta = aoe.getItemMeta();
                ItemMeta tsMeta = ts.getItemMeta();
                ItemMeta aoteMeta = ts.getItemMeta();
                ItemMeta didMeta = Did.getItemMeta();

                int ss = sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL);




                if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
                    shar6Meta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
                    shar6Meta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 VI"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+(6-ss)));
                    shar6.setItemMeta(shar6Meta);
                    inv.setItem(4, shar6);
                }

                if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 6 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
                    shar7Meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
                    shar7Meta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 VII"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+(7-ss)));
                    shar7.setItemMeta(shar7Meta);
                    inv.setItem(5, shar7);
                }

                if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 7 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 6 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
                    shar8Meta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
                    shar8Meta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 VIII"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+(8-ss)));
                    shar8.setItemMeta(shar8Meta);
                    inv.setItem(6, shar8);
                }

                if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 8 ||sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 7 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 6 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
                    shar9Meta.addEnchant(Enchantment.DAMAGE_ALL, 9, true);
                    shar9Meta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 IX"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+(9-ss)));
                    shar9.setItemMeta(shar9Meta);
                    inv.setItem(7, shar9);
                }

                if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 9 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 8 ||sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 7 ||sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 6 || sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) == 5) {
                    shar10Meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
                    shar10Meta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 X"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+(10-ss)));
                    shar10.setItemMeta(shar10Meta);
                    inv.setItem(8, shar10);
                }
                if (!ChatColor.stripColor(sword.getItemMeta().getLore().toString()).contains("Arrow Of Explosion")) {
                    if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                        aoeMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    }
                    aoeMeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"Arrow Of Explosion"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+3));
                    aoe.setItemMeta(aoeMeta);
                    inv.setItem(13, aoe);
                }

                if (!ChatColor.stripColor(sword.getItemMeta().getLore().toString()).contains("척도")) {
                    if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                        tsMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    }
                    tsMeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"척도"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+3));
                    ts.setItemMeta(tsMeta);
                    inv.setItem(15, ts);
                }

                if (!ChatColor.stripColor(sword.getItemMeta().getLore().toString()).contains("공간 도약")) {
                    if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                        aoteMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    }
                    aoteMeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"공간 도약"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+3));
                    aote.setItemMeta(aoteMeta);
                    inv.setItem(17, aote);
                }

                if (!ChatColor.stripColor(sword.getItemMeta().getLore().toString()).contains("공간 도약")) {
                    if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                        aoteMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    }
                    aoteMeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"공간 도약"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+3));
                    aote.setItemMeta(aoteMeta);
                    inv.setItem(17, aote);
                }

                if (!ChatColor.stripColor(sword.getItemMeta().getLore().toString()).contains("Deathless in Death")) {
                    if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                        didMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    }
                    aoteMeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"Deathless in Death"+ChatColor.WHITE+" ]", ChatColor.RED+"마법 부여 비용: "+ChatColor.RED+ChatColor.WHITE+3));
                    aote.setItemMeta(aoteMeta);
                    inv.setItem(23, aote);
                }


                p.openInventory(inv);

            }



        }

    }




    @EventHandler
    public void close(InventoryCloseEvent e) {
        if (!ChatColor.stripColor(e.getView().getTitle()).contains("능력치")) return;
        Player p = (Player) e.getPlayer();
        if (e.getInventory().getItem(19) == null) {
            ItemStack n = e.getInventory().getItem(20);
            if (n != null) {
                p.getLocation().getWorld().dropItem(p.getLocation(), n);
            }
            return;
        }
        ItemStack q = e.getInventory().getItem(19);
        p.getLocation().getWorld().dropItem(p.getLocation(), q);

        ItemStack n = e.getInventory().getItem(20);
        if (n != null) {
            p.getLocation().getWorld().dropItem(p.getLocation(), n);
        }


    }


    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) { //인벤토리 드래그 시
        if (ChatColor.stripColor(e.getView().getTitle()).equals("능력치")) {  //만약 드래그된 인벤토리가 이 인벤토리라면
            e.setCancelled(true);   //위치 변경 취소
        }
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {   //인벤토리 클릭 시
        Player p = (Player) e.getWhoClicked();
        if (!ChatColor.stripColor(e.getView().getTitle()).contains("능력치")) return;    //이 인벤토리를 클릭한게 아니라면 취소



        e.setCancelled(true);
        ItemStack c = e.getCurrentItem();
        if (c==null) return;
        Vector dir = p.getEyeLocation().getDirection();



        if (!c.getItemMeta().getLore().toString().contains("마법 능력")) return;


        //if (e.getSlot() != 16 &&  !(e.getSlot() < 63 && 26<e.getSlot())) {
        //    e.setCancelled(true);
        //}
        if (e.getSlot() == 19) return;
        if (c.getItemMeta().getLore() == null) return;
        ItemStack dia = e.getInventory().getItem(20);

        ItemStack sword = e.getInventory().getItem(19);

        int willbere = 1;
        int typelevel;
        int ss = sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
        if (c.getItemMeta().getLore().toString().contains("X")) {
            if (c.getItemMeta().getLore().toString().contains("IX")) {
                //9
                typelevel = 9;
                willbere = 9-ss;

            } else {
                //10
                typelevel = 10;
                willbere = 10-ss;

            }
        } else {
            if (c.getItemMeta().getLore().toString().contains("VIII")) {
                //8
                typelevel = 8;
                willbere = 8-ss;
            } else if (c.getItemMeta().getLore().toString().contains("VII")) {
                //7
                typelevel = 7;
                willbere = 7-ss;
            } else if (c.getItemMeta().getLore().toString().contains("VI")) {
                //6
                typelevel = 6;
                willbere = 6-ss;
            } else {
                //5
                typelevel = 5;
                willbere = 5-ss;
            }
        }


        if (c.getItemMeta().getLore().toString().contains("Arrow Of Explosion")) {
            typelevel = 11;
            willbere = 3;
        }

        if (c.getItemMeta().getLore().toString().contains("척도")) {
            typelevel = 12;
            willbere = 3;
        }

        if (c.getItemMeta().getLore().toString().contains("공간 도약")) {
            typelevel = 13;
            willbere = 3;
        }

        if (c.getItemMeta().getLore().toString().contains("Deathless in Death")) {
            typelevel = 14;
            willbere = 3;
        }


        if (willbere > dia.getAmount()) {
            regen(p, e.getInventory(), willbere-dia.getAmount());
            return;
        } else {
            dia.setAmount(dia.getAmount()-willbere);
        }

        ItemMeta realcmeta = c.getItemMeta();
        if (typelevel == 6) {
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 VI"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 7) {
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 VII"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 8) {
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 VIII"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 9) {
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 IX"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 10) {
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"날카로움 X"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 11) {
            if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                realcmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            }
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"Arrow Of Explosion"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 12) {
            if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                realcmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            }
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"척도"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 13) {
            if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                realcmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            }
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"공간 도약"+ChatColor.WHITE+" ]"));
        } else if (typelevel == 14) {
            if (sword.getEnchantmentLevel(Enchantment.DAMAGE_ALL) >= 6) {
                realcmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            }
            realcmeta.setLore(Arrays.asList(ChatColor.GOLD + "✪", ChatColor.YELLOW+"마법 능력: "+ChatColor.WHITE+"[ " +ChatColor.GOLD+"Deathless in Death"+ChatColor.WHITE+" ]"));
        }
        c.setItemMeta(realcmeta);
        e.getInventory().setItem(19, c);
        p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 0.5f, 1);
        p.closeInventory();






        }


        public void regen(Player p, Inventory inv, int needdia) {
            ItemStack dia = inv.getItem(20);

            int havda = 0;
            for (int t = 64; t > 0; t--) {
                ItemStack i = new ItemStack(Material.DISC_FRAGMENT_5, t);
                ItemMeta no1Meta = i.getItemMeta();
                no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "제타석");
                no1Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
                i.setItemMeta(no1Meta);
                if (p.getInventory().contains(i)) {
                    havda = t;
                    break;
                }
            }

            if (havda+dia.getAmount() < needdia) {
                return;
            }
            ItemStack i = new ItemStack(Material.DISC_FRAGMENT_5, havda);
            ItemMeta no1Meta = i.getItemMeta();
            no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "제타석");
            no1Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
            i.setItemMeta(no1Meta);

            if ((dia.getAmount()+i.getAmount()) <= 64 ) {
                ItemStack reali = new ItemStack(Material.DISC_FRAGMENT_5, dia.getAmount()+i.getAmount());
                ItemMeta noMeta = i.getItemMeta();
                noMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "제타석");
                noMeta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
                reali.setItemMeta(noMeta);


                p.getInventory().removeItem(i);
                inv.setItem(20, reali);

            } else {
                ItemStack sixfour = new ItemStack(Material.DISC_FRAGMENT_5, 64);
                ItemMeta no2Meta = sixfour.getItemMeta();
                no2Meta.setDisplayName(ChatColor.LIGHT_PURPLE+"제타석");
                no2Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
                sixfour.setItemMeta(no2Meta);
                ItemStack remains = new ItemStack(Material.DISC_FRAGMENT_5, dia.getAmount()+i.getAmount()-64);
                ItemMeta no3Meta = remains.getItemMeta();
                no3Meta.setDisplayName(ChatColor.LIGHT_PURPLE+"제타석");
                no3Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"기본 능력치 마법 부여에 사용할 수 있다."));
                remains.setItemMeta(no3Meta);
                p.getInventory().removeItem(i);
                inv.setItem(20, sixfour);
                p.getInventory().addItem(remains);
            }

        }





}
