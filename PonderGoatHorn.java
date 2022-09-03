package me.systemoutprintln.dev.hornspawn.logic.horns;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PonderGoatHorn implements Horn{

    @Override
    public void action(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 2));
    }
}
