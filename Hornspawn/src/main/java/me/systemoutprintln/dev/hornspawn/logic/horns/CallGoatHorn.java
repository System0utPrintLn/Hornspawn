package me.systemoutprintln.dev.hornspawn.logic.horns;

import java.util.LinkedList;
import java.util.List;
import me.systemoutprintln.dev.hornspawn.Hornspawn;
import me.systemoutprintln.dev.hornspawn.customentity.GoatSoldier;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.level.Level;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CallGoatHorn implements Horn {
    public void action(Player player) {
        final List<GoatSoldier> goatSoldiers = new LinkedList<>();
        final Level world = ((CraftWorld)player.getWorld()).getHandle();

        for(int run = 0; run < 6; ++run) {
            GoatSoldier goat = new GoatSoldier(world, player.getLocation());
            world.addFreshEntity(goat);
            goatSoldiers.add(goat);
        }

        (new BukkitRunnable() {
            public void run() {
                goatSoldiers.forEach((goatSoldier) -> goatSoldier.remove(RemovalReason.KILLED));
            }
        }).runTaskLater(Hornspawn.getPlugin(Hornspawn.class), 300L);
    }


}