//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.util.text.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class PlayerCheck extends Module
{
    private Entity entity;
    
    public PlayerCheck() {
        super("PlayerCheck", 0, Category.MISC);
    }
    
    @SubscribeEvent
    public void onPlayerAttack(final AttackEntityEvent e) {
        final RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
        if (objectMouseOver != null && objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
            this.entity = objectMouseOver.entityHit;
            if (this.entity instanceof EntityPlayer) {
                System.out.println(((EntityPlayer)this.entity).getDisplayName());
                ChatUtils.sendMessage("HP: " + ((EntityPlayer)this.entity).getHealth());
                ChatUtils.sendMessage("Name: " + this.entity.getName());
                ChatUtils.sendMessage("Distance: " + this.entity.getDistance((Entity)PlayerCheck.mc.player));
                if (FriendManager.friendsList.contains(this.entity)) {
                    ChatUtils.sendMessage("Status: " + TextFormatting.GREEN + "Friend");
                }
            }
        }
    }
}
