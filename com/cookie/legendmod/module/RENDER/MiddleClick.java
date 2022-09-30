//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.item.*;
import org.lwjgl.input.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class MiddleClick extends Module
{
    boolean on;
    boolean is;
    
    public MiddleClick() {
        super("MiddleClick", 0, Module.Category.RENDER);
        this.on = false;
        this.is = false;
    }
    
    @SubscribeEvent
    public void onMousClick(final InputEvent.MouseInputEvent e) {
        final RayTraceResult object = Minecraft.getMinecraft().objectMouseOver;
        if (object != null && object.typeOfHit == RayTraceResult.Type.ENTITY) {
            final Entity entity = object.entityHit;
            if (entity instanceof EntityPlayer && !(entity instanceof EntityArmorStand) && !Minecraft.getMinecraft().player.isDead && Minecraft.getMinecraft().player.canEntityBeSeen(entity)) {
                final EntityPlayer player = (EntityPlayer)entity;
                final String ID = FovUtils.getPlayerName(player);
                if (Mouse.isButtonDown(2) && Minecraft.getMinecraft().currentScreen == null) {
                    this.toggleop();
                    if (this.on && !this.is) {
                        FriendManager.addFriend(ID);
                        this.is = true;
                    }
                    else if (!this.on && !this.is) {
                        FriendManager.removeFriend(ID);
                        this.is = true;
                    }
                }
                else {
                    this.is = false;
                }
            }
        }
    }
    
    public void onDisable() {
    }
    
    public void toggleop() {
        this.on = !this.on;
    }
}
