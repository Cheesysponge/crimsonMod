package name.crimson.item;

import name.crimson.Crimson;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
                    .icon(() -> new ItemStack(ModItems.CHOMPER_SPAWN_EGG)).entries((displayContext, entries) -> {
                        for(int i = 0; i<ModItems.items.length;i++){
                            entries.add(ModItems.items[i]);
                        }
                    }).build());

    public static void registerItemGroups() {
        Crimson.LOGGER.info("Registering Item Groups for " + Crimson.MODID);
    }
}