//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import net.minecraftforge.client.event.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Platform extends Module
{
    public int roll;
    
    public Platform() {
        super("Platform", 0, Module.Category.RENDER);
        this.roll = 0;
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent e) {
        if (this.toggled) {
            if (this.roll < 360) {
                this.roll += 2;
            }
            else {
                this.roll = 0;
            }
            float PartialTicks = 1.0f;
            if (Platform.mc.player.moveForward != 0.0f) {
                PartialTicks = 1.0f;
            }
            RenderUtils.plato((Entity)Platform.mc.player, PartialTicks, Platform.mc, (float)this.roll);
        }
    }
}
