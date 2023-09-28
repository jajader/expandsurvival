package team.expandsurvival.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EndEyes implements Listener {

    HashMap<String, Integer> map2 = new HashMap();

    @EventHandler
    public void EndEye3(PlayerInteractEvent e) {

        if (e.getItem() == null) return;
        if (e.getClickedBlock() == null) return;
        if (e.getAction()== Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getType().equals(Material.ENDER_EYE)) {

                    if (map2.get(e.getPlayer().getUniqueId().toString()) == null) {
                        map2.put(e.getPlayer().getUniqueId().toString(), 1);
                        return;
                    } else if (map2.get(e.getPlayer().getUniqueId().toString()) >= 3 ) {
                        e.setCancelled(true);
                    } else {
                        map2.put(e.getPlayer().getUniqueId().toString(), map2.get(e.getPlayer().getUniqueId().toString())+1);
                        return;
                    }


                }



            }
        }

    }

