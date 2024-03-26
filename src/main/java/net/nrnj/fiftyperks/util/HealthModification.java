package net.nrnj.fiftyperks.util;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nrnj.fiftyperks.item.ModItems;

@Mod.EventBusSubscriber
public class HealthModification {

    // TODO Make juggernog a 1 time use. maybe warn player they must use next tier to gain more hearts
    // TODO add gui with Jug icon on bottom left
    @SubscribeEvent
    public static void updatePlayerHealth(LivingEntityUseItemEvent.Finish event) {
        if(!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        ItemStack itemStack = event.getItem();

        if(itemStack.getItem() == ModItems.JUGGERNOG_PERK.get()) {
            AttributeInstance maxHealthAttr = player.getAttribute(Attributes.MAX_HEALTH);
            if(maxHealthAttr != null) {
                double newMaxHealth = maxHealthAttr.getBaseValue() + 10.0D;
                maxHealthAttr.setBaseValue(newMaxHealth);

                if(player.getHealth() < maxHealthAttr.getValue()) {
                    player.setHealth(player.getHealth() + 10.0F);
                }
            }
        }
    }
}
