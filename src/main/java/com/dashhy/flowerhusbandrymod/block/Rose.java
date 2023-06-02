package com.dashhy.flowerhusbandrymod.block;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;

import java.util.function.Supplier;

public class Rose extends FlowerBlock {


    public Rose(MobEffect effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }

    public Block getBlock() {
        return this.asBlock();
    }
}
