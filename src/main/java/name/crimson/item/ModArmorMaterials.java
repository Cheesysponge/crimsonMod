package name.crimson.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;


public class ModArmorMaterials{
    public static final RegistryEntry<ArmorMaterial> SAPPHIRE;
    public static final RegistryEntry<ArmorMaterial> RUBY;



    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = Type.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type type = var9[var11];
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }



    private ModArmorMaterials() {

    }

    static {
        SAPPHIRE = register("sapphire",  Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(Type.BOOTS, 3);
            map.put(Type.LEGGINGS, 6);
            map.put(Type.CHESTPLATE, 8);
            map.put(Type.HELMET, 3);
            map.put(Type.BODY, 11);
        }), 24,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f,0.2f,  () -> Ingredient.ofItems(ModItems.SAPPHIRE));
        RUBY = register("ruby", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(Type.BOOTS, 3);
            map.put(Type.LEGGINGS, 6);
            map.put(Type.CHESTPLATE, 8);
            map.put(Type.HELMET, 3);
            map.put(Type.BODY, 11);
        }), 36,  SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 4.5f,0.1f, () -> Ingredient.ofItems(ModItems.RUBY));
    }

}