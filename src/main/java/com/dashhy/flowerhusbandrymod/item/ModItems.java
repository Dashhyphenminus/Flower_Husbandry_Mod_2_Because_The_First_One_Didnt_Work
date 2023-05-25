package com.dashhy.flowerhusbandrymod.item;

import com.dashhy.flowerhusbandrymod.FlowerHusbandryMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FlowerHusbandryMod.MOD_ID);

    public static final RegistryObject<Item> WATERING_CAN = ITEMS.register("watering_can", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RED_ROSE = ITEMS.register("red_rose", () -> new Item(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}