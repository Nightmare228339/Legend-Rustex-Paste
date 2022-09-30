//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import com.cookie.legendmod.interphase.*;

public class MBoost extends Thread
{
    private int time;
    
    @Override
    public void run() {
        final Minecraft mc = Minecraft.getMinecraft();
        try {
            Thread.sleep(this.time);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        final IMixinMinecraft minecraft = (IMixinMinecraft)mc;
        minecraft.rightClickMouse();
    }
    
    public void start(final int time) {
        this.time = time;
    }
}
