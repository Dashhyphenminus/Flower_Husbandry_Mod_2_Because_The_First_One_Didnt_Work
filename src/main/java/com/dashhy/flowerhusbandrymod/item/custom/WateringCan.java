package com.dashhy.flowerhusbandrymod.item.custom;


import com.dashhy.flowerhusbandrymod.block.Rose;
import net.minecraft.core.BlockPos;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.RandomSource;

import java.util.ArrayList;

import static com.dashhy.flowerhusbandrymod.block.ModBlocks.*;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

//protected final RandomSource random = RandomSource.create();
public class WateringCan extends Item {
    public WateringCan(Properties properties) {
        super(properties);
    }

    private boolean first = true;
    private final double[] colorValues = {0, 0.5, 1.5, 2.5, 3.5, 4.5};
    private double newFlowerColorVal = 0;

    private boolean idkWhyThisNeedsToExistButHereWeAre = false;

    private void swapBlockPos(int i, int j, ArrayList<BlockPos> list) {
        BlockPos temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void swapDouble(int i, int j, ArrayList<Double> list) {
        double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public BlockState search(Level level, BlockPos pos) {

        ArrayList<BlockPos> posList = new ArrayList<BlockPos>();

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        for (int i = 0; i < 3; i++) {
            BlockPos newPos = new BlockPos(x - 1 + i, y, z - 3);
            posList.add(newPos);
        }
        for (int i = 0; i < 5; i++) {
            BlockPos newPos = new BlockPos(x - 2 + i, y, z - 2);
            posList.add(newPos);
        }
        for (int i = 0; i < 7; i++) {
            BlockPos newPos = new BlockPos(x - 3 + i, y, z - 1);
            posList.add(newPos);
        }
        for (int i = 0; i < 7; i++) {
            BlockPos newPos = new BlockPos(x - 3 + i, y, z);
            posList.add(newPos);
        }
        for (int i = 0; i < 7; i++) {
            BlockPos newPos = new BlockPos(x - 3 + i, y, z + 1);
            posList.add(newPos);
        }
        for (int i = 0; i < 5; i++) {
            BlockPos newPos = new BlockPos(x - 2 + i, y, z + 2);
            posList.add(newPos);
        }
        for (int i = 0; i < 3; i++) {
            BlockPos newPos = new BlockPos(x - 1 + i, y, z + 3);
            posList.add(newPos);
        }

        posList.remove(18);

        ArrayList<Double> distances = new ArrayList<Double>();

        for (int i = 0; i < posList.size(); i++) {
            double xDifference = Math.abs(posList.get(i).getX() - pos.getX());
            double zDifference = Math.abs(posList.get(i).getZ() - pos.getZ());
            double distance = Math.sqrt((Math.pow(xDifference, 2)) + (Math.pow(zDifference, 2)));
            distances.add(distance);
        }

        for (int i = 0; i < posList.size() - 1; i++) {
            for (int j = i + i; j < posList.size(); j++) {
                if (distances.get(j) < distances.get(i)) {
                    swapDouble(i, j, distances);
                    swapBlockPos(i, j, posList);
                }
            }
        }

        System.out.println(distances);


        int length = posList.size();
        for (int i = 0; i < length; i++) {
            BlockState block = level.getBlockState(posList.get(i));
            if (block.getBlock() instanceof Rose) {
                return block;
            }
        }

        return null;
    }

    private void spawnHearts (BlockPos pos, Level level) {
        for (int i = 0; i < 3; i++) {
            double d0 = Math.random();
            double d1 = Math.random();
            double d2 = Math.random();
            double d3 = Math.random();
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            level.addParticle(ParticleTypes.HEART, x + d0, y + d1, z + d2, d3, d3, d3);
        }
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        Player player = context.getPlayer();
        assert !(player == null);
        player.getCooldowns().addCooldown(this, 10);


        if (!idkWhyThisNeedsToExistButHereWeAre) {


            //System.out.println("hello world");


            BlockState test = level.getBlockState(blockPos.north(-1).east(2));
            System.out.println(test.getBlock());
            if (test.getBlock() instanceof Rose) {
                System.out.println("it is indeed an instance of rose");
            }


            search(level, blockPos);

            //if (first) {
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
            //first = false;

            //} else {

            //} else {
            BlockState autoFindBlock = search(level, blockPos);

            if (autoFindBlock == null) {
                System.out.println("No flowers found");
            } else {
                if (autoFindBlock.getBlock().equals(WHITE_ROSE.get())) {
                    newFlowerColorVal += 0;
                } else if (autoFindBlock.getBlock().equals(PINK_ROSE.get())) {
                    newFlowerColorVal += 1;
                } else if (autoFindBlock.getBlock().equals(RED_ROSE.get())) {
                    newFlowerColorVal += 2;
                } else if (autoFindBlock.getBlock().equals(ORANGE_ROSE.get())) {
                    newFlowerColorVal += 3;
                } else if (autoFindBlock.getBlock().equals(YELLOW_ROSE.get())) {
                    newFlowerColorVal += 4;
                } else if (autoFindBlock.getBlock().equals(RAINBOW_ROSE.get())) {
                    newFlowerColorVal += 5;
                } else {
                    System.out.println(blockState.getBlock());
                }

                newFlowerColorVal /= 2;

                double[] rands = {Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5};
                Arrays.sort(rands);
                newFlowerColorVal += rands[1];

                if (Math.random() < 0.02) {
                    ItemStack stack = new ItemStack(RAINBOW_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                } else if (newFlowerColorVal < colorValues[1]) {
                    ItemStack stack = new ItemStack(WHITE_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                } else if (newFlowerColorVal < colorValues[2]) {
                    ItemStack stack = new ItemStack(PINK_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                } else if (newFlowerColorVal < colorValues[3]) {
                    ItemStack stack = new ItemStack(RED_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                } else if (newFlowerColorVal < colorValues[4]) {
                    ItemStack stack = new ItemStack(ORANGE_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                } else if (newFlowerColorVal < colorValues[5]) {
                    ItemStack stack = new ItemStack(YELLOW_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                } else {
                    ItemStack stack = new ItemStack(RAINBOW_ROSE.get());
                    player.getInventory().add(stack);
                    spawnHearts (blockPos, level);
                }
            }



            //first = true;

            idkWhyThisNeedsToExistButHereWeAre = true;
        } else {
            idkWhyThisNeedsToExistButHereWeAre = false;
        }


        return super.useOn(context);
    }
}
