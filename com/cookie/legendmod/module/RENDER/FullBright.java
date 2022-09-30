//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;

public class FullBright extends Module
{
    private float oldgamma;
    
    public FullBright() {
        super("FullBright", 0, Module.Category.RENDER);
    }
    
    public void onEnable() {
        this.oldgamma = FullBright.mc.gameSettings.gammaSetting;
        FullBright.mc.gameSettings.gammaSetting = 100.0f;
    }
    
    public void onDisable() {
        FullBright.mc.gameSettings.gammaSetting = this.oldgamma;
    }
}
