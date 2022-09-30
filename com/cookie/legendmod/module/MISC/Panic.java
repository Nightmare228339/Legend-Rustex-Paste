//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import org.lwjgl.opengl.*;
import com.cookie.legendmod.*;
import java.util.*;

public class Panic extends Module
{
    public static boolean isPanic;
    
    public Panic() {
        super("Panic", 211, Category.MISC);
    }
    
    @Override
    public void onEnable() {
        Panic.isPanic = true;
        Display.setTitle("Minecraft 1.12.2");
        for (final Module m : Client.modules) {
            if (m != this && m.toggled) {
                m.setToggled(false);
            }
        }
    }
    
    @Override
    public void onDisable() {
        Panic.isPanic = false;
        Display.setTitle(Client.Clname);
    }
    
    static {
        Panic.isPanic = false;
    }
}
