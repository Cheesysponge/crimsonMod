package name.crimson.block;
import dev.architectury.platform.Mod;
import name.crimson.Crimson;
import name.crimson.block.custom.BlackstoneSpike;
import name.crimson.block.custom.StrangeFlower;
import name.crimson.item.ModFoodComponents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.awt.*;

public class ModBlocks {
    public static final Block CRIMSON_CHOMPER_EYE = registerBlock("crimson_chomper_eye",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.CRIMSON_PLANKS).strength(1f).luminance((state) -> 16),
                    new BlockSetType("crimson_chomper_eye"
            ),10,false),new FabricItemSettings().fireproof().food(ModFoodComponents.FUNGI));
    public static final Block NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.NETHER_GOLD_ORE).strength(4f).requiresTool().luminance((state) -> 0),
                    UniformIntProvider.create(4,8)));
    public static final Block SAPPHIRE_BLOCK  = registerBlock("sapphire_block",new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK).strength(4f).requiresTool()));
    public static final Block BLACKSTONE_FLOWER = registerBlock("blackstone_flower", new StrangeFlower(StatusEffects.FIRE_RESISTANCE,1000,
            FabricBlockSettings.copy(Blocks.DANDELION).luminance((state) -> 6).dynamicBounds().strength(1f)),
            new FabricItemSettings().food(ModFoodComponents.BLACKSTONE_FLOWER));

    public static final Block BLACKSTONE_SPIKE = registerBlock("blackstone_spike", new BlackstoneSpike(FabricBlockSettings.copy(Blocks.POINTED_DRIPSTONE)));
    public static final Block[] items = new Block[] {CRIMSON_CHOMPER_EYE,NETHER_SAPPHIRE_ORE,SAPPHIRE_BLOCK,BLACKSTONE_FLOWER, BLACKSTONE_SPIKE};

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Crimson.MODID, name), block);
    }
    private static Block registerBlock(String name, Block block, FabricItemSettings itemSettings){
        registerBlockItem(name, block, itemSettings);
        return Registry.register(Registries.BLOCK, new Identifier(Crimson.MODID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(Crimson.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = null;
        if(name.contains("fungi")) {
            item = Registry.register(Registries.ITEM, new Identifier(Crimson.MODID, name),
                    new BlockItem(block, new FabricItemSettings().food(ModFoodComponents.FUNGI)));
        }

        item = Registry.register(Registries.ITEM, new Identifier(Crimson.MODID, name),
                new BlockItem(block, new FabricItemSettings()));

        return item;
    }
    private static Item registerBlockItem(String name, Block block, FabricItemSettings itemSettings) {
        Item item = null;
        item = Registry.register(Registries.ITEM, new Identifier(Crimson.MODID, name),
                new BlockItem(block, itemSettings));
        return item;
    }

    public static void registerModBlocks() {
        Crimson.LOGGER.info("Registering Blocks for " + Crimson.MODID);
    }
}
