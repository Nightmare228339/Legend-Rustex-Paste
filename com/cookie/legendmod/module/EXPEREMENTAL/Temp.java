//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.EXPEREMENTAL;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.utils.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Temp extends Module
{
    public TimerUtils timer;
    
    public Temp() {
        super("Temp", 0, Category.EXPEREMENTAL);
        this.timer = new TimerUtils();
    }
    
    @SubscribeEvent
    public void onRightClickBlock(final TickEvent.PlayerTickEvent event) {
        final int x = Temp.mc.player.getPosition().getX();
        final int y = Temp.mc.player.getPosition().getY();
        final int z = Temp.mc.player.getPosition().getZ();
        final BlockPos pp = new BlockPos(x, y - 1, z);
        Temp.mc.world.setBlockState(pp, Blocks.SANDSTONE.getDefaultState());
    }
}
