package com.github.draylar.eiah.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class ESMixin
{
    @Inject(at = @At("HEAD"), method = "getPreferredEquipmentSlot", cancellable = true)
    private static void getPreferredEquipmentSlot(ItemStack itemStack_1, CallbackInfoReturnable<EquipmentSlot> cir)
    {
        Item item_1 = itemStack_1.getItem();
        if (!(item_1 instanceof ArmorItem))
        {
            cir.setReturnValue(EquipmentSlot.HEAD);
        }
    }
}
