//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Zoom extends Module
{
    private static boolean isZoom;
    
    public Zoom() {
        super("Zoom", 0, Module.Category.RENDER);
        Legendmod.instance.settingsManager.rSetting(new Setting("Zoom", (Module)this, 1.0, 1.0, 10.0, true));
    }
    
    @SubscribeEvent
    public void onFov(final FOVUpdateEvent e) {
        if (this.toggled && Zoom.isZoom) {
            final double spedd = Legendmod.instance.settingsManager.getSettingByName(this.name, "Zoom").getValDouble();
            e.setNewfov((float)(1.0 / spedd));
        }
    }
    
    public static boolean togglezoom() {
        return Zoom.isZoom = !Zoom.isZoom;
    }
    
    public void onDisable() {
        Zoom.isZoom = false;
    }
    
    static {
        Zoom.isZoom = false;
    }
}
