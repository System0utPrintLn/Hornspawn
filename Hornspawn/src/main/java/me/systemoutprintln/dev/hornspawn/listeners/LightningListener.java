package me.systemoutprintln.dev.hornspawn.listeners;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LightningListener implements Listener {

    @EventHandler
    public void onHitEvent (final EntityDamageByEntityEvent event){

        World world = event.getEntity().getWorld();
        if (!(event.getDamager() instanceof Player)){

        }


    }

}
