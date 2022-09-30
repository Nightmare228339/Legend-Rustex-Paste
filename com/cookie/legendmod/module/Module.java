//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module;

import net.minecraft.client.*;
import net.minecraftforge.common.*;
import com.cookie.legendmod.utils.*;
import com.cookie.legendmod.*;
import java.util.*;

public class Module
{
    public String name;
    public boolean toggled;
    public int keyCode;
    public Category category;
    public static Minecraft mc;
    
    public Module(final String name, final int key, final Category c) {
        this.name = name;
        this.keyCode = key;
        this.category = c;
    }
    
    public boolean isEnabled() {
        return this.toggled;
    }
    
    public int getKey() {
        return this.keyCode;
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
    
    public boolean onPacket(final Object packet, final Connection.Side side) {
        return true;
    }
    
    public void setKey(final int key) {
        this.keyCode = key;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public void setToggled(final boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public static Module getModuleByName(final String name) {
        for (final Module module : Client.modules) {
            if (module.getName().equals(name)) {
                return module;
            }
        }
        return null;
    }
    
    static {
        Module.mc = Minecraft.getMinecraft();
    }
    
    public enum Category
    {
        COMBAT, 
        MOVEMENT, 
        PLAYER, 
        RENDER, 
        MISC, 
        EXPEREMENTAL, 
        EXPLOIT;
    }
}
