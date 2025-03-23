package net.hetrox.crimsonmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class ModConsumableComponents {
    public static final ConsumableComponent PIZZA = food().consumeEffect(
            new ApplyEffectsConsumeEffect(
                    List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0),
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 0)))).build();

    public static final ConsumableComponent DZIK = drink().sound(SoundEvents.ENTITY_GENERIC_DRINK).consumeEffect(
            new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0))).build();

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder()
                .consumeSeconds(1.6F)
                .useAction(UseAction.EAT)
                .sound(SoundEvents.ENTITY_GENERIC_EAT)
                .consumeParticles(true);
    }

    public static ConsumableComponent.Builder drink() {
        return ConsumableComponent.builder()
                .consumeSeconds(1.6F)
                .useAction(UseAction.DRINK)
                .sound(SoundEvents.ENTITY_GENERIC_DRINK)
                .consumeParticles(false);
    }
}
