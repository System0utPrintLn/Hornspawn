package me.systemoutprintln.dev.hornspawn.customentity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;

//Goat Soldier made by MouBieCat

public class GoatSoldier extends Goat {

    public GoatSoldier(Level level, Location loc) {
        super(EntityType.GOAT, level);
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50.0f);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0f);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2f);
        this.setHealth(50.0f);

    }

    public void updateName() {
        this.setCustomName(Component.Serializer.fromJson(
                "{\"text\":\"" + "Soldier Goat" + "(" + ((int) getHealth()) + "/" + ((int) getMaxHealth()) + ChatColor.RED + "♥" + ChatColor.WHITE + ")" + "\"}"
        ));
        this.setCustomNameVisible(true);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Monster.class, 16.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, true));

    }



}