package com.dashhy.flowerhusbandrymod.item.custom;


import com.dashhy.flowerhusbandrymod.block.Rose;
import net.minecraft.core.BlockPos;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

import static com.dashhy.flowerhusbandrymod.block.ModBlocks.*;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;


public class WateringCan extends Item {
    public WateringCan(Properties properties) {
        super(properties);
    }

    private boolean first = true;
    private final double[] colorValues = {0, 0.5, 1.5, 2.5, 3.5, 4.5};
    private double newFlowerColorVal = 0;

    private boolean idkWhyThisNeedsToExistButHereWeAre = false;


    public BlockState search(Level level, BlockPos pos, int i) {

        if (i < 3) {
            BlockState block1 = level.getBlockState(pos.north(1);
            BlockState block2 = level.getBlockState(pos.east(1);
            BlockState block3 = level.getBlockState(pos.south(1));
            BlockState block4 = level.getBlockState(pos.west(1);
            if (block1.getBlock() instanceof Rose)
                return block1;
            if (block2.getBlock() instanceof Rose)
                return block2;
            if (block3.getBlock() instanceof Rose)
                return block3;
            if (block4.getBlock() instanceof Rose)
                return block4;
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            BlockPos thingie = new BlockPos(x, y + 1, z);
            search(level, thingie, i + 1);

            thingie = new BlockPos(x + 1, y, z);
            search(level, thingie, i + 1);

            thingie = new BlockPos(x-1, y , z);
            search(level, thingie, i + 1);

            thingie = new BlockPos(x, y-1, z);
            search(level, thingie, i + 1);
        }

        return null;
    }

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


            BlockState test = level.getBlockState(blockPos.north(-1).east(2));
            System.out.println(test.getBlock());
            if (test.getBlock() instanceof Rose) {
                System.out.println("it is indeed an instance of rose");
            }


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

                if (Math.random() < 0.02) {
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
