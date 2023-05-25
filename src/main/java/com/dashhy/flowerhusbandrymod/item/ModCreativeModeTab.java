package com.dashhy.flowerhusbandrymod.item;


import com.dashhy.flowerhusbandrymod.FlowerHusbandryMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = FlowerHusbandryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab PLANT_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        PLANT_TAB = event.registerCreativeModeTab(new ResourceLocation(FlowerHusbandryMod.MOD_ID, "plant_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RED_ROSE.get()))
                .title(Component.translatable("creativemodetab.plant_tab")));
    }
}
