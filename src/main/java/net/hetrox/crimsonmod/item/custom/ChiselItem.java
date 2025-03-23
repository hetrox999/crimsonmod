package net.hetrox.crimsonmod.item.custom;

import net.hetrox.crimsonmod.component.ModDataComponentTypes;
import net.hetrox.crimsonmod.datagen.ModItemTagProvider;
import net.hetrox.crimsonmod.item.ModItems;
import net.hetrox.crimsonmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    public ChiselItem(Settings settings) {
        super(settings);
    }

    private static final Map<Block, Block> CHISEL_MAP = new HashMap<>();
    private static final Map<Block, Block> REVERSE_CHISEL_MAP = new HashMap<>();

    static {
        CHISEL_MAP.put(Blocks.STONE, Blocks.STONE_BRICKS);
        CHISEL_MAP.put(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        CHISEL_MAP.put(Blocks.SAND, Blocks.GLASS);
        CHISEL_MAP.put(Blocks.DIRT, Blocks.GRASS_BLOCK);

        for (Map.Entry<Block, Block> entry : CHISEL_MAP.entrySet()) {
            REVERSE_CHISEL_MAP.put(entry.getValue(), entry.getKey());
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock) || REVERSE_CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient) {
                Block newBlock = CHISEL_MAP.getOrDefault(clickedBlock, REVERSE_CHISEL_MAP.get(clickedBlock));
                world.setBlockState(context.getBlockPos(), newBlock.getDefaultState());


                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
                int currentCount = context.getStack().getOrDefault(ModDataComponentTypes.CLICK_COUNT, 0);
                context.getStack().set(ModDataComponentTypes.CLICK_COUNT, currentCount +1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()){
            if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
                tooltip.add(Text.translatable("tooltip.crimson-mod.chisel.tooltip2"));

                tooltip.add(Text.literal("Last block changed at: " + stack.get(ModDataComponentTypes.COORDINATES)));
                int currentCount = stack.getOrDefault(ModDataComponentTypes.CLICK_COUNT, 0);
                tooltip.add(Text.literal("Used "+currentCount+" times"));
            }
        }
        else if (!Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.crimson-mod.chisel.tooltip"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
