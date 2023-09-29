package team.expandsurvival.Listeners;

import com.google.common.util.concurrent.Service;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

import static org.bukkit.Bukkit.*;

public class Clickand implements Listener {



    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {   //인벤토리 클릭 시
        Player p = (Player) e.getWhoClicked();
        if (!ChatColor.stripColor(e.getView().getTitle()).contains("강화")) return;    //이 인벤토리를 클릭한게 아니라면 취소



        e.setCancelled(true);
        ItemStack c = e.getCurrentItem();
        if (c==null) return;


        //if (e.getSlot() != 16 &&  !(e.getSlot() < 63 && 26<e.getSlot())) {
        //    e.setCancelled(true);
        //}
        if (c.getItemMeta().getLore() == null) return;
        if (c.getItemMeta().getLore().toString().contains("강화")) {
            String lore;
            if (e.getInventory().getItem(19).getItemMeta().getLore() != null) {
                lore = e.getInventory().getItem(19).getItemMeta().getLore().toString();
            } else {
                lore = "";
            }

            ItemStack realc = e.getInventory().getItem(19);


            String kind;
            int k;

            //검의 성작 상태확인
            if (lore.contains("★☆☆☆☆☆☆☆☆☆")) {
                k = 1;
            } else if (lore.contains("★★☆☆☆☆☆☆☆☆")) {
                k = 2;
            } else if (lore.contains("★★★☆☆☆☆☆☆☆")) {
                k = 3;
            } else if (lore.contains("★★★★☆☆☆☆☆☆")) {
                k = 4;
            } else if (lore.contains("★★★★★☆☆☆☆☆")) {
                k = 5;
            } else if (lore.contains("★★★★★★☆☆☆☆")) {
                k = 6;
            } else if (lore.contains("★★★★★★★☆☆☆")) {
                k = 7;
            } else if (lore.contains("★★★★★★★★☆☆")) {
                k = 8;
            } else if (lore.contains("★★★★★★★★★☆")) {
                k = 9;
            } else {
                k = 0;
            }

            kind = "Sword";
            double gd = 4;
            switch (c.getType().toString()) {
                case "WOODEN_SWORD":
                    gd = 4;
                    break;
                case "STONE_SWORD":
                    gd = 5;
                    break;
                case "IRON_SWORD":
                    gd = 6;
                    break;
                case "GOLDEN_SWORD":
                    gd = 4;
                    break;
                case "DIAMOND_SWORD":
                    gd = 7;
                    break;
                case "NETHERITE_SWORD":
                    gd = 8;
                    break;

            }
            if (c.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                switch (c.getItemMeta().getEnchantLevel(Enchantment.DAMAGE_ALL)) {
                    case 1:
                        gd = gd + 1;
                        break;
                    case 2:
                        gd = gd + 1.5;
                        break;
                    case 3:
                        gd = gd + 2;
                        break;
                    case 4:
                        gd = gd + 2.5;
                        break;
                    case 5:
                        gd = gd + 3;
                        break;

                }
            }



            ItemStack i;
            ItemStack dia = e.getInventory().getItem(21);
            if (dia == null) {
                int havda = 0;
                for (int t=64; t>0;t--) {
                    i = new ItemStack(Material.IRON_NUGGET, t);
                    ItemMeta no1Meta = i.getItemMeta();
                    no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE+"이베르카늄");
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

                i = new ItemStack(Material.IRON_NUGGET, havda);
                ItemMeta no1Meta = i.getItemMeta();
                no1Meta.setDisplayName(ChatColor.LIGHT_PURPLE+"이베르카늄");
                no1Meta.setLore(Arrays.asList(ChatColor.DARK_AQUA+"아이템 강화에 사용할 수 있다."));
                i.setItemMeta(no1Meta);
                p.getInventory().removeItem(i);
                e.getInventory().setItem(21, i);
                return;
            }



            dia.setAmount(dia.getAmount()-1);





            double percentage = Math.random()*100;
            double tjdrhd = 100-8.5*k;
            double dbwl = 4*k;
            double vkrhl = 4.5*k;
            if (percentage <= 100-8.5*k) {
                if (k != 9) {
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 0.5f, 1);
                } else {
                    p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 0.5f, 1);
                    p.sendMessage(p.getDisplayName()+ "(이)가 "+ChatColor.GOLD+"전설의 검"+ChatColor.WHITE+"을 제련하였습니다.");

                }
                tjdrhd = tjdrhd - 8.5;
                dbwl = dbwl+4;
                vkrhl = vkrhl+4.5;
                ItemMeta swordMeta = realc.getItemMeta();
                ItemMeta tswordMeta = c.getItemMeta();
                AttributeModifier da = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                AttributeModifier daf = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                AttributeModifier gdf = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", gd, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);


                switch (k) {

                    case 0:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★☆☆☆☆☆☆☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gdf);
                        realc.setItemMeta(swordMeta);
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);


                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★☆☆☆☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);


                        break;
                    case 1:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★☆☆☆☆☆☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★☆☆☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 2:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★☆☆☆☆☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★☆☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 3:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★☆☆☆☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 4:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★☆☆☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 5:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★☆☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★★☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 6:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★★☆☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★★★☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 7:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★★★☆☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★★★★☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 8:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★★★★☆"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"✪", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                        c.setItemMeta(tswordMeta);
                        break;
                    case 9:
                        swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "✪"));
                        swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                        //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        realc.setItemMeta(swordMeta);

                        p.closeInventory();
                        break;


                }
            } else if (percentage <= 100-4.5*k) {
                p.playSound(p.getLocation(), Sound.ITEM_SHIELD_BREAK, 0.5f, 1);
                if (k != 0) {
                    if (k != 1) {
                        tjdrhd = tjdrhd + 8.5;
                        dbwl = dbwl-4;
                        vkrhl = vkrhl-4.5;
                        ItemMeta swordMeta = realc.getItemMeta();
                        ItemMeta tswordMeta = c.getItemMeta();
                        AttributeModifier da = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                        AttributeModifier daf = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", -1.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

                        switch (k) {
                            case 2:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★☆☆☆☆☆☆☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);


                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★☆☆☆☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);


                                break;
                            case 3:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★☆☆☆☆☆☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★☆☆☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;
                            case 4:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★☆☆☆☆☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★☆☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;
                            case 5:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★☆☆☆☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★☆☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;
                            case 6:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★☆☆☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★☆☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;
                            case 7:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★☆☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★★☆☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;
                            case 8:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★★☆☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★★★☆☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;
                            case 9:
                                swordMeta.setLore(Arrays.asList(ChatColor.GOLD+ "★★★★★★★★☆☆"));
                                swordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, daf);
                                //swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                                realc.setItemMeta(swordMeta);

                                tswordMeta.setLore(Arrays.asList(ChatColor.GOLD+"★★★★★★★★★☆", ChatColor.BLUE + "강화 성공 확률 : "+tjdrhd+"%", ChatColor.RED + "단순 강화 실패 확률 : "+dbwl+"%", ChatColor.LIGHT_PURPLE + "무기 파괴 확률 : "+vkrhl+"%"));
                                c.setItemMeta(tswordMeta);
                                break;


                        }
                    }
                }
            } else {
                p.playSound(p.getLocation(), Sound.BLOCK_END_GATEWAY_SPAWN, 0.5f, 1);
                ItemStack air = new ItemStack(Material.AIR);
                e.getInventory().setItem(19, air);
                p.closeInventory();
                return;
            }


        }
        //Player player = (Player) e.getWhoClicked(); //클릭한 사람에게
        //player.getInventory().addItem(clickedItem); //아이템 지급
        //player.closeInventory();    //인벤토리 닫기
    }

    @EventHandler
    public void close(InventoryCloseEvent e) {
        if (!ChatColor.stripColor(e.getView().getTitle()).contains("강화")) return;
        Player p = (Player) e.getPlayer();
        if (e.getInventory().getItem(19) == null) {
            ItemStack n = e.getInventory().getItem(21);
            if (n != null) {
                p.getLocation().getWorld().dropItem(p.getLocation(), n);
            }
            return;
        }
        ItemStack q = e.getInventory().getItem(19);
        p.getLocation().getWorld().dropItem(p.getLocation(), q);

        ItemStack n = e.getInventory().getItem(21);
        if (n != null) {
            p.getLocation().getWorld().dropItem(p.getLocation(), n);
        }


    }

        @EventHandler
        public void inventoryinterect(InventoryInteractEvent e) {
            if (ChatColor.stripColor(e.getView().getTitle()).equals("강화")) {  //만약 드래그된 인벤토리가 이 인벤토리라면
                e.setCancelled(true);   //위치 변경 취소
                e.getWhoClicked().sendMessage("asdfasdf");
            }
        }


        @EventHandler
        public void onInventoryDrag(InventoryDragEvent e) { //인벤토리 드래그 시
            if (ChatColor.stripColor(e.getView().getTitle()).equals("강화")) {  //만약 드래그된 인벤토리가 이 인벤토리라면
                e.setCancelled(true);   //위치 변경 취소
            }
        }



    @EventHandler
    public void Enchantnot(PrepareItemEnchantEvent e) {
        if (e.getItem().getItemMeta().getLore() == null) return;
        if (e.getItem().getItemMeta().getLore().toString().contains("★")) e.setCancelled(true);
        if (e.getItem().getItemMeta().getLore().toString().contains("✪")) e.setCancelled(true);
        if (e.getItem().getItemMeta().getLore().toString().contains("☆")) e.setCancelled(true);
        return;
    }


    @EventHandler
    public void noportal(PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
            Player p = e.getPlayer();
            if (!hasAdvancement(p, "minecraft:adventure/kill_mob_near_sculk_catalyst")) {
                e.setCancelled(true);
            }
        }

        return;
    }


    public static boolean hasAdvancement(Player player, String name) {
        // name should be something like minecraft:husbandry/break_diamond_hoe
        Advancement a = getAdvancement(name);
        if(a == null){
            // advancement does not exists.
            return false;
        }
        AdvancementProgress progress = player.getAdvancementProgress(a);
        // getting the progress of this advancement.
        return progress.isDone();
        //returns true or false.
    }
    public static Advancement getAdvancement(String name) {
        Iterator<Advancement> it = Bukkit.getServer().advancementIterator();
        // gets all 'registered' advancements on the server.
        while (it.hasNext()) {
            // loops through these.
            Advancement a = it.next();
            if (a.getKey().toString().equalsIgnoreCase(name)) {
                //checks if one of these has the same name as the one you asked for. If so, this is the one it will return.
                return a;
            }
        }
        return null;
    }
}


