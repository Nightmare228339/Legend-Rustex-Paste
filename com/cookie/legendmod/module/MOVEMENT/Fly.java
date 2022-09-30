//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Fly extends Module
{
    public Fly() {
        super("Fly", 0, Module.Category.MOVEMENT);
        Legendmod.instance.settingsManager.rSetting(new Setting("FlySpeed", (Module)this, 0.05000000074505806, 0.0, 1.0, false));
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        if (this.toggled) {
            final float spedd = (float)Legendmod.instance.settingsManager.getSettingByName("Fly", "FlySpeed").getValDouble();
            Fly.mc.player.capabilities.setFlySpeed(spedd);
            Fly.mc.player.capabilities.isFlying = true;
            Fly.mc.player.capabilities.allowFlying = true;
            Fly.mc.player.fallDistance = 0.0f;
            Fly.mc.player.noClip = true;
            Fly.mc.player.onGround = false;
        }
    }
    
    public void onDisable() {
        Fly.mc.player.capabilities.isFlying = false;
        Fly.mc.player.capabilities.allowFlying = false;
        Fly.mc.player.motionX = 0.0;
        Fly.mc.player.motionY = 0.0;
        Fly.mc.player.motionZ = 0.0;
        Fly.mc.player.fallDistance = 0.0f;
    }
}
