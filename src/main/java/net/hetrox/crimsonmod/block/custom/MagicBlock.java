package net.hetrox.crimsonmod.block.custom;

import net.hetrox.crimsonmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MagicBlock extends Block {

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;

            for (int i = 0; i < 10; i++) {
                double x = pos.getX() + 0.5 + (world.random.nextDouble() - 0.5);
                double y = pos.getY() + 1.0;
                double z = pos.getZ() + 0.5 + (world.random.nextDouble() - 0.5);
                serverWorld.spawnParticles(
                        ParticleTypes.ENCHANT,
                        x, y, z,
                        5,
                        0.0, 0.1, 0.0,
                        0.1
                );
            }
        }

        return ActionResult.SUCCESS;
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof PlayerEntity playerEntity) {
            playerEntity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    100,
                    0,
                    true,
                    true,
                    true
            ));
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }

    public MagicBlock(Settings settings) {
        super(settings);
    }
}