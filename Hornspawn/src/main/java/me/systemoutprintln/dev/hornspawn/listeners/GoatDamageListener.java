package me.systemoutprintln.dev.hornspawn.listeners;

import me.systemoutprintln.dev.hornspawn.customentity.GoatSoldier;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GoatDamageListener implements Listener {

    @EventHandler
    public void goatDamaged (EntityDamageEvent event){
        if(event.getEntity() instanceof GoatSoldier){
           GoatSoldier goat = (GoatSoldier) event.getEntity();
            goat.setHealth((float) (goat.getHealth() - event.getDamage()));
            event.setDamage(0);
            goat.updateName();
        }

    }

}