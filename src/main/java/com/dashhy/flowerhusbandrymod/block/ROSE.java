package com.dashhy.flowerhusbandrymod.block;

import net.minecraft.server.commands.SetBlockCommand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;

import java.util.function.Supplier;


public class ROSE extends FlowerBlock {
    public ROSE(Supplier<MobEffect> effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }




    public void pollinate() {

    }

    private void createNewFlower (ROSE flower, int xOffset, int yOffset) {
//        ServerLevel serverlevel = new ServerLevel();
//        serverlevel.blockUpdated(p_138609_, p_138610_.getState().getBlock());
    }
}
