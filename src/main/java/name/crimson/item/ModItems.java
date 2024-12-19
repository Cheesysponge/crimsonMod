package name.crimson.item;

import name.crimson.Crimson;
import name.crimson.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
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

    public static final Item[] items = new Item[] {CHOMPER_SPAWN_EGG,CRIMSON_EYE, TIGER_SPAWN_EGG};
    public static final Item[] items_for_textures = new Item[] {CRIMSON_EYE};


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Crimson.MODID, name), item);
    }

    public static void registerModItems() {
        Crimson.LOGGER.info("Registering Mod Items for " + Crimson.MODID);
    }
}
