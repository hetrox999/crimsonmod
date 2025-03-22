package net.hetrox.crimsonmod.item.custom;

import net.hetrox.crimsonmod.component.ModDataComponentTypes;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;

public class StaffItem extends Item {
    private static final int COOLDOWN_TICKS = 40;

    public StaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            ItemStack stack = user.getStackInHand(hand);

            if (user.getItemCooldownManager().isCoolingDown(stack)) {
                return ActionResult.FAIL;
            }
            user.getItemCooldownManager().set(stack, COOLDOWN_TICKS);

            Vec3d eyePos = user.getCameraPosVec(1.0F);
            Vec3d lookVec = user.getRotationVec(1.0F);
            double reachDistance = 15.0;
            Vec3d endPos = eyePos.add(lookVec.multiply(reachDistance));
            BlockHitResult hitResult = world.raycast(new RaycastContext(eyePos, endPos, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, user));

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos targetBlockPos = hitResult.getBlockPos();

                if (user.isSneaking()) {
                    // Toggle shift mode
                    boolean currentMode = stack.getOrDefault(ModDataComponentTypes.SHIFT_MODE, false);
                    stack.set(ModDataComponentTypes.SHIFT_MODE, !currentMode);

                    // Spawn bat
                    Entity mobEntity = EntityType.BAT.create(world, SpawnReason.EVENT);
                    if (mobEntity != null) {
                        mobEntity.setPosition(
                                targetBlockPos.getX() + 0.5,
                                targetBlockPos.getY() + 1.0,
                                targetBlockPos.getZ() + 0.5);
                        world.spawnEntity(mobEntity);
                    }
                } else {
                    // Create explosion
                    double x = targetBlockPos.getX() + 0.5;
                    double y = targetBlockPos.getY() + 1;
                    double z = targetBlockPos.getZ() + 0.5;

                    serverWorld.createExplosion(
                            user,
                            x, y, z,
                            4.0f,
                            false,
                            World.ExplosionSourceType.NONE);

                    serverWorld.spawnParticles(
                            ParticleTypes.EXPLOSION,
                            x, y, z,
                            10,
                            0.0, 0.1, 0.0,
                            0.1);
                }

                stack.damage(1, serverWorld, (ServerPlayerEntity) user,
                        item -> user.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.crimson-mod.staff.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.crimson-mod.staff.tooltip2"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}