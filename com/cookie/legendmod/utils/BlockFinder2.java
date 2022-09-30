//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.block.state.*;
import java.util.*;

public class BlockFinder2
{
    public static void enable(final String mode, final boolean trace) {
        blockFinder(mode, trace);
    }
    
    private static void blockFinder(final String mode, final boolean trace) {
        final ArrayList<Blockinfo> render = new ArrayList<Blockinfo>();
        final ArrayList<Blockinfo> rendered = new ArrayList<Blockinfo>();
        final Minecraft mc = Minecraft.getMinecraft();
        final int radius = mc.gameSettings.renderDistanceChunks << 4;
        final int minX = mc.player.getPosition().getX() - radius;
        final int maxX = mc.player.getPosition().getX() + radius;
        final int minY = Math.max(60, mc.player.getPosition().getY() - 92);
        final int maxY = Math.min(130, mc.player.getPosition().getY() + 72);
        final int minZ = mc.player.getPosition().getZ() - radius;
        final int maxZ = mc.player.getPosition().getZ() + radius;
        final ArrayList blackList = new ArrayList<Block>() {
            {
                this.add(Blocks.AIR);
                this.add(Blocks.BEDROCK);
                this.add(Blocks.STONE);
                this.add((Block)Blocks.GRASS);
                this.add(Blocks.DIRT);
            }
        };
        for (int chunkX = minX >> 4; chunkX <= maxX >> 4; ++chunkX) {
            final int x = chunkX << 4;
            final int lowBoundX = (x < minX) ? (minX - x) : 0;
            final int highBoundX = (x + 15 > maxX) ? (maxX - x) : 15;
            for (int chunkZ = minZ >> 4; chunkZ <= maxZ >> 4; ++chunkZ) {
                final Chunk chunk = mc.world.getChunk(chunkX, chunkZ);
                if (chunk.isLoaded()) {
                    final ExtendedBlockStorage[] extendsList = chunk.getBlockStorageArray();
                    final int z = chunkZ << 4;
                    final int lowBoundZ = (z < minZ) ? (minZ - z) : 0;
                    final int highBoundZ = (z + 15 > maxZ) ? (maxZ - z) : 15;
                    for (int curExtend = minY >> 4; curExtend <= maxY >> 4; ++curExtend) {
                        final ExtendedBlockStorage ebs = extendsList[curExtend];
                        if (ebs != null) {
                            final int y = curExtend << 4;
                            final int lowBoundY = (y < minY) ? (minY - y) : 0;
                            final int highBoundY = (y + 15 > maxY) ? (maxY - y) : 15;
                            for (int i = lowBoundX; i <= highBoundX; ++i) {
                                for (int j = lowBoundY; j <= highBoundY; ++j) {
                                    for (int k = lowBoundZ; k <= highBoundZ; ++k) {
                                        final IBlockState currentState = ebs.get(i, j, k);
                                        if (!blackList.contains(currentState.getBlock())) {
                                            if (mode.equals("Ore")) {
                                                if (currentState.getBlock().equals(Blocks.GRAY_GLAZED_TERRACOTTA)) {
                                                    render.add(new Blockinfo(x + i, y + j, z + k, 0.0f, 0.5f, 1.0f));
                                                }
                                                else if (currentState.getBlock().equals(Blocks.CYAN_GLAZED_TERRACOTTA)) {
                                                    render.add(new Blockinfo(x + i, y + j, z + k, 1.0f, 0.0f, 0.0f));
                                                }
                                                else if (currentState.getBlock().equals(Blocks.YELLOW_GLAZED_TERRACOTTA)) {
                                                    render.add(new Blockinfo(x + i, y + j, z + k, 1.0f, 0.9f, 0.0f));
                                                }
                                            }
                                            else if (mode.equals("Pumpkin") && currentState.getBlock().equals(Blocks.PUMPKIN)) {
                                                render.add(new Blockinfo(x + i, y + j, z + k, 1.0f, 0.5f, 0.0f));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (final Blockinfo bi : render) {
            if (!rendered.equals(bi)) {
                rendered.add(bi);
                mc.entityRenderer.enableLightmap();
                RenderUtils.blockESP(new BlockPos(bi.getX(), bi.getY(), bi.getZ()), bi.getR(), bi.getG(), bi.getB());
                if (trace) {
                    RenderUtils.trace(mc, bi, mc.getRenderPartialTicks());
                }
                mc.entityRenderer.disableLightmap();
            }
        }
    }
}
