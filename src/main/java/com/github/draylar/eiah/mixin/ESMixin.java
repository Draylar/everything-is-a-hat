package com.github.draylar.eiah.mixin;

import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class ESMixin
{
    @Inject(at = @At("HEAD"), method = "getPreferredEquipmentSlot", cancellable = true)
    private static void getPreferredEquipmentSlot(ItemStack itemStack, CallbackInfoReturnable<EquipmentSlot> cir)
    {
        EquipmentSlot equipmentSlot;
        Item item = itemStack.getItem();
        if (item != Blocks.CARVED_PUMPKIN.asItem() || ! (((BlockItem)item).getBlock() instanceof AbstractSkullBlock)) {
            if (item instanceof ArmorItem) {
                equipmentSlot = ((ArmorItem)item).getSlotType();
            } else if (item == Items.ELYTRA) {
                equipmentSlot = EquipmentSlot.CHEST;
            } else {
                equipmentSlot = item == Items.SHIELD ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
            }
        }

        else
        {
            equipmentSlot = EquipmentSlot.HEAD;
        }


        if (equipmentSlot == EquipmentSlot.MAINHAND)
        {
            cir.setReturnValue(EquipmentSlot.HEAD);
        }
    }
}
