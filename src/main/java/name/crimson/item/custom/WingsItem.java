package name.crimson.item.custom;

import com.google.common.base.Suppliers;
import name.crimson.Crimson;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class WingsItem extends ElytraItem implements FabricElytraItem {
    protected final ArmorItem.Type type;
    protected final RegistryEntry<ArmorMaterial> material;
    private final Supplier<AttributeModifiersComponent> attributeModifiers;

    public WingsItem(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Settings settings) {
        // You can set durability here if you want: settings.maxDamage(432)
        super(settings.maxDamage(432));
        this.material = material;
        this.type = type;

        this.attributeModifiers = Suppliers.memoize(() -> {
            int armor = material.value().getProtection(type);
            float toughness = material.value().toughness();

            AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
            AttributeModifierSlot slot = AttributeModifierSlot.forEquipmentSlot(type.getEquipmentSlot());

            // Use unique ids per attribute (recommended)
            Identifier armorId = Identifier.ofVanilla("armor." + type.getName());
            Identifier toughnessId = Identifier.ofVanilla("armor_toughness." + type.getName());
            Identifier kbId = Identifier.ofVanilla("armor_knockback_resistance." + type.getName());

            builder.add(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(armorId, armor, EntityAttributeModifier.Operation.ADD_VALUE),
                    slot
            );
            builder.add(
                    EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                    new EntityAttributeModifier(toughnessId, toughness, EntityAttributeModifier.Operation.ADD_VALUE),
                    slot
            );

            float kbRes = material.value().knockbackResistance();
            if (kbRes > 0.0F) {
                builder.add(
                        EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                        new EntityAttributeModifier(kbId, kbRes, EntityAttributeModifier.Operation.ADD_VALUE),
                        slot
                );
            }

            return builder.build();
        });
    }

    /**
     * This is the Fabric hook that enables elytra flight for this item when worn in the chest slot.
     */
    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        // Disallow flight if "broken" (same general rule as vanilla elytra)
        if (chestStack.getDamage() >= chestStack.getMaxDamage() - 1) {
            return false;
        }

        // If Fabric is ticking flight, apply vanilla elytra ticking + damage behavior
        if (tickElytra) {
            this.doVanillaElytraTick(entity, chestStack);
        }

        return true;
    }


    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        return this.attributeModifiers.get();
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//        Crimson.LOGGER.warn("BOOST PACKET RECEIVED from " + slot);
        if (slot == 2){
            entity.fallDistance = 0;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
