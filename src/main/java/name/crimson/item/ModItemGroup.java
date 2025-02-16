package name.crimson.item;

import name.crimson.Crimson;
import name.crimson.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup MAIN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Crimson.MODID, "main"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.crimson.main"))
                    .icon(() -> new ItemStack(ModBlocks.BLACKSTONE_FLOWER)).entries((displayContext, entries) -> {
                        for(Item item : ModItems.items){
                            entries.add(item);
                        }
                        for(Block block : ModBlocks.items){
                            entries.add(block.asItem());
                        }
                    }).build());
    public static final ItemGroup GEAR = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Crimson.MODID, "gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.crimson.gear"))
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE_CHESTPLATE)).entries((displayContext, entries) -> {
                        for(Item tool : ModItems.tools){
                            entries.add(tool);
                        }
                        for(Item armor : ModItems.armor){
                            entries.add(armor);
                        }
                    }).build());

    public static void registerItemGroups() {
        Crimson.LOGGER.info("Registering Item Groups for " + Crimson.MODID);
    }
}