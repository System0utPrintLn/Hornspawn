package me.systemoutprintln.dev.hornspawn.logic.horns;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SeekGoatHorn implements Horn{

    @Override
    public void action(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 1));

    }
}