package net.hetrox.crimsonmod.component;

import com.mojang.serialization.Codec;
import net.hetrox.crimsonmod.CrimsonMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", BlockPos.CODEC);
    public static final ComponentType<Integer> CLICK_COUNT = register("counter", Codec.INT);
    public static final ComponentType<Boolean> SHIFT_MODE = register("shift_mode", Codec.BOOL);

    private static <T> ComponentType<T> register(String name, Codec<T> codec) {
        return Registry.register(
                Registries.DATA_COMPONENT_TYPE,
                Identifier.of(CrimsonMod.MOD_ID, name),
                ComponentType.<T>builder().codec(codec).build()
        );
    }

    public static void registerDataComponentTypes() {
        CrimsonMod.LOGGER.info("Registering Data Component Types for " + CrimsonMod.MOD_ID);
    }
}