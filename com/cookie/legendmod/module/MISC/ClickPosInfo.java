//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import net.minecraftforge.event.entity.player.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.util.math.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ClickPosInfo extends Module
{
    public ClickPosInfo() {
        super("ClickPosInfo", 0, Category.MISC);
    }
    
    @SubscribeEvent
    public void onRightClickBlock(final PlayerInteractEvent.RightClickBlock e) {
        if (this.toggled) {
            final BlockPos bp = e.getPos();
            final double x = bp.getX();
            final double y = bp.getY();
            final double z = bp.getZ();
            ChatUtils.sendMessage(x + " " + y + " " + z);
            ChatUtils.sendMessage(String.valueOf(ClickPosInfo.mc.world.getBlockState(bp).getBlock()));
        }
    }
    
    @Override
    public void onDisable() {
    }
}
