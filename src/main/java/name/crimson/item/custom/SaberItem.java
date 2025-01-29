package name.crimson.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import name.crimson.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SaberItem extends SwordItem  {



    public SaberItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        double d = (double)(-MathHelper.sin(attacker.getYaw() * (float) (Math.PI / 180.0)));
        double e = (double)MathHelper.cos(attacker.getYaw() * (float) (Math.PI / 180.0));
        if (attacker.getWorld() instanceof ServerWorld) {
            ((ServerWorld)attacker.getWorld()).spawnParticles(ModParticles.BLUE_PARTICLE, attacker.getX() + d, attacker.getBodyY(0.5), attacker.getZ() + e, 0, d, 0.0, e, 0.0);
        }
        return true;
    }


}
