package name.crimson.item;

import name.crimson.Crimson;
import name.crimson.entity.ModEntities;
import name.crimson.item.custom.SaberItem;
import name.crimson.particle.ModParticles;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item CHOMPER_SPAWN_EGG = registerItem("chomper_spawn_egg",
            new SpawnEggItem(ModEntities.CHOMPER,0x540000, 0xd60d0d,
                    new Item.Settings().maxCount(64)));
    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER,0xa10b00, 0x85322c,
                    new Item.Settings().maxCount(64)));
    public static final Item CRIMSON_EYE = registerItem("crimson_eye",new Item(new Item.Settings().maxCount(1).maxDamage(1).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item SAPPHIRE = registerItem("sapphire",new Item(new Item.Settings().maxCount(16).fireproof().rarity(Rarity.COMMON)));
    public static final Item SAPPHIRE_SABER = registerItem("sapphire_saber", new SaberItem(ModToolMaterials.SAPPHIRE,
            new Item.Settings().attributeModifiers(SaberItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3, -2.4f)).rarity(Rarity.UNCOMMON).maxCount(1),
            ModParticles.BLUE_SWEEP_PARTICLE,ModParticles.BLUE_CRIT_PARTICLE));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword", new SwordItem(ModToolMaterials.SAPPHIRE,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3, -2.4f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 1, -2.8f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 6, -3.1f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 4, -2.7f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, -2, -1.0f)).rarity(Rarity.UNCOMMON).maxCount(1)));

    public static final Item RUBY = registerItem("ruby",new Item(new Item.Settings().maxCount(16).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item RUBY_SABER = registerItem("ruby_saber", new SaberItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(SaberItem.createAttributeModifiers(ModToolMaterials.RUBY, 3, -2.4f)).rarity(Rarity.UNCOMMON).maxCount(1),
            ModParticles.RED_SWEEP_PARTICLE,ModParticles.RED_CRIT_PARTICLE));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 3, -2.4f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 1, -2.8f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 6, -3.1f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY, 4, -2.7f)).rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RUBY, 1, -1.0f)).rarity(Rarity.UNCOMMON).maxCount(1)));
//
//
    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
//
    public static final Item NETHER_WART_BREAD = registerItem("nether_wart_bread",new Item(new Item.Settings().maxCount(16).fireproof().rarity(Rarity.COMMON).food(ModFoodComponents.WART_BREAD)));

    public static final Item[] armor = {SAPPHIRE_HELMET,SAPPHIRE_CHESTPLATE,SAPPHIRE_LEGGINGS,SAPPHIRE_BOOTS,
            RUBY_HELMET,RUBY_CHESTPLATE,RUBY_LEGGINGS,RUBY_BOOTS};

    public static final Item[] tools = {SAPPHIRE_SWORD,SAPPHIRE_PICKAXE,SAPPHIRE_AXE,SAPPHIRE_SHOVEL,SAPPHIRE_HOE,SAPPHIRE_SABER,
            RUBY_SWORD,RUBY_PICKAXE,RUBY_AXE,RUBY_SHOVEL,RUBY_HOE,RUBY_SABER};

    public static final Item[] items = {CHOMPER_SPAWN_EGG,CRIMSON_EYE, TIGER_SPAWN_EGG, NETHER_WART_BREAD, SAPPHIRE,RUBY};
    public static final Item[] items_for_textures = {CRIMSON_EYE, NETHER_WART_BREAD, SAPPHIRE, RUBY};


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Crimson.MODID, name), item);
    }

    public static void registerModItems() {
        Crimson.LOGGER.info("Registering Mod Items for " + Crimson.MODID);
    }
}
