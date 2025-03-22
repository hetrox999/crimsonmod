package net.hetrox.crimsonmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DiceItem extends Item {
    private static final int COOLDOWN_TICKS = 200;

    public DiceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        if (!world.isClient && world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;

            if (player.getItemCooldownManager().isCoolingDown(stack)) {
                return ActionResult.FAIL;
            }
            player.getItemCooldownManager().set(stack, COOLDOWN_TICKS);

            new Thread(() -> {
                try {
                    for (int i = 3; i > 0; i--) {
                        player.sendMessage(Text.of("Rolling in " + i + "..."), false);
                        Thread.sleep(1000);
                    }

                    Random random = new Random();
                    int randomNumber = random.nextInt(6) + 1;

                    switch (randomNumber) {
                        case 1:
                            List<EntityType<?>> mobPoolOne = Arrays.asList(
                                    EntityType.WITHER,
                                    EntityType.ENDER_DRAGON,
                                    EntityType.WARDEN,
                                    EntityType.RAVAGER,
                                    EntityType.ELDER_GUARDIAN,
                                    EntityType.GIANT
                            );
                            spawnMob(serverWorld, blockPos, player, mobPoolOne, random, "item.crimson-mod.dice.roll.1");
                            break;
                        case 2:
                            List<EntityType<?>> mobPoolTwo = Arrays.asList(
                                    EntityType.WITHER_SKELETON,
                                    EntityType.BLAZE,
                                    EntityType.GHAST,
                                    EntityType.VINDICATOR,
                                    EntityType.EVOKER,
                                    EntityType.BREEZE
                            );
                            spawnMob(serverWorld, blockPos, player, mobPoolTwo, random, "item.crimson-mod.dice.roll.2");
                            break;
                        case 3:
                            List<EntityType<?>> mobPoolThree = Arrays.asList(
                                    EntityType.SKELETON,
                                    EntityType.SLIME,
                                    EntityType.BAT,
                                    EntityType.ZOMBIE,
                                    EntityType.CREEPER
                            );
                            spawnMob(serverWorld, blockPos, player, mobPoolThree, random, "item.crimson-mod.dice.roll.3");
                            break;
                        case 4:
                            List<EntityType<?>> mobPoolFour = Arrays.asList(
                                    EntityType.VILLAGER,
                                    EntityType.IRON_GOLEM,
                                    EntityType.ALLAY,
                                    EntityType.ARMADILLO,
                                    EntityType.SNOW_GOLEM
                            );
                            spawnMob(serverWorld, blockPos, player, mobPoolFour, random, "item.crimson-mod.dice.roll.4");
                            break;
                        case 5:
                            List<EntityType<?>> mobPoolFive = Arrays.asList(
                                    EntityType.BEE,
                                    EntityType.PARROT,
                                    EntityType.CAT
                            );
                            spawnMob(serverWorld, blockPos, player, mobPoolFive, random, "item.crimson-mod.dice.roll.5");
                            break;
                        case 6:
                            List<EntityType<?>> mobPoolSix = Arrays.asList(
                                    EntityType.AXOLOTL,
                                    EntityType.PANDA,
                                    EntityType.SNIFFER,
                                    EntityType.SKELETON_HORSE
                            );
                            spawnMob(serverWorld, blockPos, player, mobPoolSix, random, "item.crimson-mod.dice.roll.6");
                            break;
                    }
                    stack.damage(1, serverWorld, (ServerPlayerEntity) player,
                            item -> player.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private void spawnMob(ServerWorld world, BlockPos pos, PlayerEntity player, List<EntityType<?>> mobPool, Random random, String messageKey) {
        EntityType<?> selectedMob = mobPool.get(random.nextInt(mobPool.size()));
        Entity mobEntity = selectedMob.create(world, SpawnReason.EVENT);
        if (mobEntity != null) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1;
            double z = pos.getZ() + 0.5;
            mobEntity.setPosition(x, y, z);
            world.spawnParticles(
                    ParticleTypes.EXPLOSION,
                    x, y, z,
                    10,
                    0.0, 0.1, 0.0,
                    0.1
            );
            world.spawnEntity(mobEntity);
            player.sendMessage(Text.translatable(messageKey), false);
        }
    }
}