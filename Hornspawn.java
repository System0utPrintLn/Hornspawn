package me.systemoutprintln.dev.hornspawn;

import me.systemoutprintln.dev.hornspawn.listeners.HornListener;
import me.systemoutprintln.dev.hornspawn.logic.horns.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hornspawn extends JavaPlugin {

    private final HornManager hornManager = new HornManager();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new HornListener(this), this);

        this.hornManager.addHorn("minecraft:ponder_goat_horn", new PonderGoatHorn());
        this.hornManager.addHorn("minecraft:sing_goat_horn", new SingGoatHorn());
        this.hornManager.addHorn("minecraft:seek_goat_horn", new SeekGoatHorn());
        this.hornManager.addHorn("minecraft:feel_goat_horn", new FeelGoatHorn());
        this.hornManager.addHorn("minecraft:admire_goat_horn", new AdmireGoatHorn());
        this.hornManager.addHorn("minecraft:call_goat_horn", new CallGoatHorn());
        this.hornManager.addHorn("minecraft:yearn_goat_horn", new YearnGoatHorn());
        this.hornManager.addHorn("minecraft:dream_goat_horn", new DreamGoatHorn());

    }

    public HornManager getHorns() {
        return this.hornManager;
    }


}
