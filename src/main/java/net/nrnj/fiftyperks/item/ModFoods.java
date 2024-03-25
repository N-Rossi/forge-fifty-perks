package net.nrnj.fiftyperks.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties VOLTAGE_VIAL_PERK = new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();
    public static final FoodProperties JUGGERNOG_PERK = new FoodProperties.Builder().alwaysEat().nutrition(10).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();

}
