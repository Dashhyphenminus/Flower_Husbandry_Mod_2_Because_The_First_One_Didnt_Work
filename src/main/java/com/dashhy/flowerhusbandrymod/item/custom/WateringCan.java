package com.dashhy.flowerhusbandrymod.item.custom;


import net.minecraft.core.BlockPos;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static com.dashhy.flowerhusbandrymod.block.ModBlocks.*;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;


public class WateringCan extends Item {
    public WateringCan(Properties properties) {
        super(properties);
    }
    private boolean first = true;
    private final double[] colorValues = {0, 1, 2, 3, 4, 5};
    private double newFlowerColorVal = 0;

    boolean idkWhyThisNeedsToExistButHereWeAre = false;

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {


        if (!idkWhyThisNeedsToExistButHereWeAre) {
            //System.out.println("hello world");

            Level level = context.getLevel();
            BlockPos blockPos = context.getClickedPos();
            BlockState blockState = level.getBlockState(blockPos);
            Player player = context.getPlayer();
            assert !(player == null);
            player.getCooldowns().addCooldown(this, 10);



            if (first) {
                newFlowerColorVal = 0;
                if (blockState.getBlock().equals(WHITE_ROSE.get())) {
                    newFlowerColorVal += 0;
                } else if (blockState.getBlock().equals(PINK_ROSE.get())) {
                    newFlowerColorVal += 1;
                } else if (blockState.getBlock().equals(RED_ROSE.get())) {
                    newFlowerColorVal += 2;
                } else if (blockState.getBlock().equals(ORANGE_ROSE.get())) {
                    newFlowerColorVal += 3;
                } else if (blockState.getBlock().equals(YELLOW_ROSE.get())) {
                    newFlowerColorVal += 4;
                } else if (blockState.getBlock().equals(RAINBOW_ROSE.get())) {
                    newFlowerColorVal += 5;
                }
                first = false;

            } else {
                if (blockState.getBlock().equals(WHITE_ROSE.get())) {
                    newFlowerColorVal += 0;
                } else if (blockState.getBlock().equals(PINK_ROSE.get())) {
                    newFlowerColorVal += 1;
                } else if (blockState.getBlock().equals(RED_ROSE.get())) {
                    newFlowerColorVal += 2;
                } else if (blockState.getBlock().equals(ORANGE_ROSE.get())) {
                    newFlowerColorVal += 3;
                } else if (blockState.getBlock().equals(YELLOW_ROSE.get())) {
                    newFlowerColorVal += 4;
                } else if (blockState.getBlock().equals(RAINBOW_ROSE.get())) {
                    newFlowerColorVal += 5;
                }

                newFlowerColorVal /= 2;

                double[] rands = {Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5};
                Arrays.sort(rands);
                newFlowerColorVal += rands[1];

                if (Math.random() < 0.2) {
                    ItemStack stack = new ItemStack(RAINBOW_ROSE.get());
                    player.getInventory().add(stack);
                } else if (newFlowerColorVal < colorValues[1]) {
                    ItemStack stack = new ItemStack(WHITE_ROSE.get());
                    player.getInventory().add(stack);
                } else if (newFlowerColorVal < colorValues[2]) {
                    ItemStack stack = new ItemStack(PINK_ROSE.get());
                    player.getInventory().add(stack);
                } else if (newFlowerColorVal < colorValues[3]) {
                    ItemStack stack = new ItemStack(RED_ROSE.get());
                    player.getInventory().add(stack);
                } else if (newFlowerColorVal < colorValues[4]) {
                    ItemStack stack = new ItemStack(ORANGE_ROSE.get());
                    player.getInventory().add(stack);
                } else if (newFlowerColorVal < colorValues[5]) {
                    ItemStack stack = new ItemStack(YELLOW_ROSE.get());
                    player.getInventory().add(stack);
                } else {
                    ItemStack stack = new ItemStack(RAINBOW_ROSE.get());
                    player.getInventory().add(stack);
                }
                first = true;
            }
            idkWhyThisNeedsToExistButHereWeAre = true;
        } else {
            idkWhyThisNeedsToExistButHereWeAre = false;
        }


        return super.useOn(context);
    }
}
