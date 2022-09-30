//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.EXPEREMENTAL;

import com.cookie.legendmod.module.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.util.math.*;

public class AtackTp extends Module
{
    public AtackTp() {
        super("AtackTp", 0, Category.EXPEREMENTAL);
    }
    
    @SubscribeEvent
    public void onAtack(final AttackEntityEvent e) {
        if (this.toggled) {
            final Entity tr = e.getTarget();
            this.Goto(tr.posX, tr.posY, tr.posZ, this.rotations(tr)[1], this.rotations(tr)[0], tr);
        }
    }
    
    public void Goto(double x, final double y, double z, final float pitch, final float yaw, final Entity tr) {
        x = (AtackTp.mc.player.posX = x - 1.0);
        AtackTp.mc.player.posX = y;
        z = (AtackTp.mc.player.posX = z - 1.0);
        AtackTp.mc.player.setLocationAndAngles(--x, y, --z, pitch, yaw);
        AtackTp.mc.player.rotationPitch = this.rotations(tr)[1];
        AtackTp.mc.player.rotationYaw = this.rotations(tr)[0];
    }
    
    public float[] rotations(final Entity target) {
        final double x = target.posX - AtackTp.mc.player.posX;
        final double y = target.posY - AtackTp.mc.player.posY;
        final double z = target.posZ - AtackTp.mc.player.posZ;
        final double u = MathHelper.sqrt(x * x + z * z);
        final float u2 = (float)(MathHelper.atan2(z, x) * 57.29577951308232 - 90.0);
        final float u3 = (float)(-MathHelper.atan2(y, u) * 57.29577951308232);
        return new float[] { u2, u3 };
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
}
