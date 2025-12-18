package name.crimson.datagen;

import name.crimson.block.ModBlocks;
import name.crimson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        for(int i = 0; i < ModBlocks.items.length; i++) {
            addDrop(ModBlocks.items[i]);
        }
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.NETHER_SAPPHIRE_ORE, dropsWithSilkTouch(ModBlocks.NETHER_SAPPHIRE_ORE, this.applyExplosionDecay(ModBlocks.NETHER_SAPPHIRE_ORE, ItemEntry.builder(ModItems.SAPPHIRE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 2.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));
        addDrop(ModBlocks.NETHER_RUBY_ORE, dropsWithSilkTouch(ModBlocks.NETHER_RUBY_ORE, this.applyExplosionDecay(ModBlocks.NETHER_RUBY_ORE, ItemEntry.builder(ModItems.RUBY).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 2.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));

        addDrop(ModBlocks.BLACKSTONE_FLOWER, dropsWithSilkTouch(ModBlocks.BLACKSTONE_FLOWER, this.applyExplosionDecay(ModBlocks.BLACKSTONE_FLOWER, ItemEntry.builder(Blocks.BLACKSTONE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 1F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));
        addDrop(ModBlocks.BIG_BLACKSTONE_FLOWER, dropsWithSilkTouch(ModBlocks.BIG_BLACKSTONE_FLOWER, this.applyExplosionDecay(ModBlocks.BIG_BLACKSTONE_FLOWER, ItemEntry.builder(Blocks.BLACKSTONE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2F, 3F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));

    }
 }
