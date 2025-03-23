package net.hetrox.crimsonmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PIZZA = new FoodComponent.Builder().nutrition(7).saturationModifier(1.2f).alwaysEdible().build();;
    public static final FoodComponent DRINK = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).alwaysEdible().build();
}
