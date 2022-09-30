//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class TriggerBot extends Module
{
    private Entity entity;
    
    public TriggerBot() {
        super("TriggerBot", 0, Category.COMBAT);
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        final RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
        if (objectMouseOver != null && objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
            this.entity = objectMouseOver.entityHit;
            if (this.entity instanceof EntityPlayer && !FriendManager.friendsList.contains(this.entity.getName()) && Minecraft.getMinecraft().player.getCooledAttackStrength(0.0f) == 1.0f) {
                Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                Minecraft.getMinecraft().player.resetCooldown();
            }
        }
    }
}
