package me.systemoutprintln.dev.hornspawn.logic.horns;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FeelGoatHorn implements Horn{

    @Override
    public void action(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 2));

    }
}
