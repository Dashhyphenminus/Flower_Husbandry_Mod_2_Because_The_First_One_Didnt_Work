package com.dashhy.flowerhusbandrymod.block;

import com.dashhy.flowerhusbandrymod.FlowerHusbandryMod;
import com.dashhy.flowerhusbandrymod.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FlowerHusbandryMod.MOD_ID);

    public static final RegistryObject<Block> RED_ROSE = RegisterBlock("red_rose", () -> new Rose(MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> WHITE_ROSE = RegisterBlock("white_rose", () -> new Rose(MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> PINK_ROSE = RegisterBlock("pink_rose", () -> new Rose(MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> YELLOW_ROSE = RegisterBlock("yellow_rose", () -> new Rose(MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> ORANGE_ROSE = RegisterBlock("orange_rose", () -> new Rose(MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> RAINBOW_ROSE = RegisterBlock("rainbow_rose", () -> new Rose(MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION)));

    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
