package name.crimson.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import name.crimson.item.ModToolMaterials;
import name.crimson.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SaberItem extends SwordItem {


    private final ParticleEffect sweep;
    private final ParticleEffect crit;
    private final ToolMaterial material;



    public SaberItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings, ParticleEffect SweepParticle, ParticleEffect CritParticle) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.sweep = SweepParticle;
        this.crit = CritParticle;
        this.material = toolMaterial;

    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        double d = (double) (-MathHelper.sin(attacker.getYaw() * (float) (Math.PI / 180.0)));
        double e = (double) MathHelper.cos(attacker.getYaw() * (float) (Math.PI / 180.0));
        boolean isCrit = attacker.fallDistance > 0.0F
                && !attacker.isOnGround()
                && !attacker.isClimbing()
                && !attacker.isTouchingWater()
                && !attacker.hasStatusEffect(StatusEffects.BLINDNESS)
                && !attacker.hasVehicle()
                && target instanceof LivingEntity;
        if (attacker.getWorld() instanceof ServerWorld && !isCrit) {
            ((ServerWorld) attacker.getWorld()).spawnParticles(this.sweep, attacker.getX() + d, attacker.getBodyY(0.5), attacker.getZ() + e, 0, d, 0.0, e, 0.0);
        } else {
            if(!attacker.getWorld().isClient()) {
                MinecraftClient.getInstance().particleManager.addEmitter(target, this.crit);
            }

        }
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, 0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 40, 0));
        if(this.material == ModToolMaterials.RUBY){
            target.setOnFireFor(2);
        }
        if(this.material == ModToolMaterials.SAPPHIRE){
            target.setFrozenTicks(target.getFrozenTicks()+50);
        }
        return true;
    }

}