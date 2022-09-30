//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import com.cookie.legendmod.module.MISC.*;

public class AutoPeek extends Module
{
    private Entity entity;
    double x;
    double y;
    double z;
    
    public AutoPeek() {
        super("AutoPeek", 0, Category.COMBAT);
    }
    
    @Override
    public void onEnable() {
        this.x = AutoPeek.mc.player.posX;
        this.y = AutoPeek.mc.player.posY;
        this.z = AutoPeek.mc.player.posZ;
        super.onEnable();
    }
    
    @Override
    public void onDisable() {
        if (!Panic.isPanic) {
            AutoPeek.mc.player.sendChatMessage("#goto " + this.x + " " + this.y + " " + this.z);
        }
        super.onDisable();
    }
}
