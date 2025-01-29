package name.crimson.item;

import name.crimson.Crimson;
import name.crimson.entity.ModEntities;
import name.crimson.item.custom.SaberItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item CHOMPER_SPAWN_EGG = registerItem("chomper_spawn_egg",
            new SpawnEggItem(ModEntities.CHOMPER,0x540000, 0xd60d0d,
                    new FabricItemSettings().maxCount(64)));
    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER,0xa10b00, 0x85322c,
                    new FabricItemSettings().maxCount(64)));
    public static final Item CRIMSON_EYE = registerItem("crimson_eye",new Item(new FabricItemSettings().maxCount(1).maxDamage(1).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item SAPPHIRE = registerItem("sapphire",new Item(new FabricItemSettings().maxCount(16).fireproof().rarity(Rarity.COMMON)));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword", new SwordItem(ModToolMaterials.SAPPHIRE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE,1,-2.8f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE,6,-3.1f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE,-2,-1.0f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_SABER = registerItem("sapphire_saber", new SaberItem(ModToolMaterials.SAPPHIRE,3,-2.4f,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));


    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots", new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS,new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));

    public static final Item NETHER_WART_BREAD = registerItem("nether_wart_bread",new Item(new FabricItemSettings().maxCount(16).fireproof().rarity(Rarity.COMMON).food(ModFoodComponents.WART_BREAD)));

    public static final Item[] armor = {SAPPHIRE_HELMET,SAPPHIRE_CHESTPLATE,SAPPHIRE_LEGGINGS,SAPPHIRE_BOOTS};

    public static final Item[] tools = {SAPPHIRE_SWORD,SAPPHIRE_PICKAXE,SAPPHIRE_AXE,SAPPHIRE_SHOVEL,SAPPHIRE_HOE,SAPPHIRE_SABER};

    public static final Item[] items = {CHOMPER_SPAWN_EGG,CRIMSON_EYE, TIGER_SPAWN_EGG, NETHER_WART_BREAD, SAPPHIRE};
    public static final Item[] items_for_textures = {CRIMSON_EYE, NETHER_WART_BREAD, SAPPHIRE};


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Crimson.MODID, name), item);
    }

    public static void registerModItems() {
        Crimson.LOGGER.info("Registering Mod Items for " + Crimson.MODID);
    }
}
