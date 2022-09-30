//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ClickTp extends Module
{
    public ClickTp() {
        super("ClickTp", 0, Module.Category.MOVEMENT);
    }
    
    @SubscribeEvent
    public void onRightClickBlock(final PlayerInteractEvent.RightClickBlock e) {
        if (this.toggled) {
            final BlockPos bp = e.getPos();
            final double x = bp.getX();
            double y = bp.getY();
            final double z = bp.getZ();
            final float yaw = ClickTp.mc.player.rotationYaw;
            final float pitch = ClickTp.mc.player.rotationPitch;
            ClickTp.mc.player.setLocationAndAngles(x, ++y, z, pitch, yaw);
            ClickTp.mc.player.posX = x;
            ClickTp.mc.player.posY = y;
            ClickTp.mc.player.posZ = z;
            ClickTp.mc.player.rotationYaw = yaw;
            ClickTp.mc.player.rotationPitch = pitch;
        }
    }
    
    public void onDisable() {
    }
}
