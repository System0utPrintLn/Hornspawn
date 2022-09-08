package me.systemoutprintln.dev.hornspawn.listeners;

import me.systemoutprintln.dev.hornspawn.customentity.GoatSoldier;
import net.minecraft.world.entity.Entity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GoatDamageListener implements Listener {

    @EventHandler
    public void goatDamaged (EntityDamageEvent event){
        Entity entity = ((CraftEntity) event.getEntity()).getHandle();
        if(entity instanceof GoatSoldier){
           GoatSoldier goat = (GoatSoldier) entity;
               goat.setHealth((float) (((goat.getHealth() - event.getFinalDamage()))));
               event.setDamage(0);
               goat.updateName();


        }

    }

}