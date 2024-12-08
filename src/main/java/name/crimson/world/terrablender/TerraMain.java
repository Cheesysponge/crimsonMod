package name.crimson.world.terrablender;

import name.crimson.Crimson;
import name.crimson.world.terrablender.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class TerraMain implements TerraBlenderApi {


    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new OverworldRegions(new Identifier(Crimson.MODID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Crimson.MODID, ModMaterialRules.makeRules());


    }
}
