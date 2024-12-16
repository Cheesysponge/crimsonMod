package name.crimson.datagen;

import name.crimson.blocks.ModBlocks;
import name.crimson.entity.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for(int i = 0; i < ModBlocks.items.length; i++) {
            addDrop(ModBlocks.items[i]);
        }

    }
}