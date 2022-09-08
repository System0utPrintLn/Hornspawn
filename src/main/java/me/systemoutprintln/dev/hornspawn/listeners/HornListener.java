package me.systemoutprintln.dev.hornspawn.listeners;

import me.systemoutprintln.dev.hornspawn.Hornspawn;
import me.systemoutprintln.dev.hornspawn.logic.horns.Horn;
import net.minecraft.nbt.CompoundTag;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import javax.annotation.Nullable;

public class HornListener implements Listener {

    private final Hornspawn hornspawn;

    public HornListener(Hornspawn hornspawn) {
        this.hornspawn = hornspawn;
    }

    // Defining limitations

    @EventHandler
    public void onPlayerInteractEvent(final PlayerInteractEvent event) {
        final Action action = event.getAction();
        final Player player = event.getPlayer();
        final ItemStack item = event.getItem();

        if (item == null || !item.getType().equals(Material.GOAT_HORN) || item.getItemMeta() == null)
            return;

        if (player.hasCooldown(Material.GOAT_HORN))
            return;

        if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK)
            return;

        // Getting the specific NBT tag for when a horn is sounded

        final net.minecraft.world.item.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        final CompoundTag compoundTag = nmsItem.getTag() != null ? nmsItem.getTag() : new CompoundTag();
        final String instrument = compoundTag.getString("instrument");

        final @Nullable Horn horn = this.hornspawn.getHorns().getHorn(instrument);
        if (horn != null) {
            horn.action(player);
            player.setCooldown(Material.GOAT_HORN, 800);
        }

    }

}