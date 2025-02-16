package name.crimson.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent FUNGI = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 0.9f).build();
    public static final FoodComponent WART_BREAD = new FoodComponent.Builder().nutrition(7).saturationModifier(0.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 0.9f).build();
    public static final FoodComponent BLACKSTONE_FLOWER = new FoodComponent.Builder().nutrition(1).saturationModifier(0.05f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20, 0),1f).
            build();



}
