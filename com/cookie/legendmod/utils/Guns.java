//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Íàòàëüÿ\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.item.*;

public class Guns
{
    public static ItemStack getAK(final String count, final boolean scoped) {
        ItemStack item;
        if (!scoped) {
            item = new ItemStack(Items.DIAMOND_AXE, Integer.parseInt(count), 200);
        }
        else {
            item = new ItemStack(Items.DIAMOND_AXE, Integer.parseInt(count), 202);
        }
        item.setTranslatableName("LR-300 Assault Rifle \u0432\u2013« \u0412«" + item.getCount() + "\u0412»");
        try {
            item.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
        }
        catch (Throwable t) {}
        try {
            item.setItemFrame((EntityItemFrame)null);
        }
        catch (Throwable t2) {}
        return item;
    }
    
    public static ItemStack getLR(final String count) {
        final ItemStack item = new ItemStack(Items.DIAMOND_AXE, Integer.parseInt(count), 210);
        item.setTranslatableName("LR-300 Assault Rifle \u0432\u2013« \u0412«" + item.getCount() + "\u0412»");
        try {
            item.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
        }
        catch (Throwable t) {}
        try {
            item.setItemFrame((EntityItemFrame)null);
        }
        catch (Throwable t2) {}
        return item;
    }
    
    public static ItemStack getBigBox() {
        final ItemStack BigBox = new ItemStack(Items.DIAMOND_HOE, 1, 60);
        try {
            BigBox.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
            System.out.println("TRUE");
        }
        catch (Throwable t) {}
        try {
            BigBox.setItemFrame((EntityItemFrame)null);
        }
        catch (Throwable t2) {}
        return BigBox;
    }
    
    public static ItemStack getFurance() {
        final ItemStack Furance = new ItemStack(Items.DIAMOND_HOE, 1, 221);
        try {
            Furance.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
            System.out.println("TRUE");
        }
        catch (Throwable t) {}
        try {
            Furance.setItemFrame((EntityItemFrame)null);
        }
        catch (Throwable t2) {}
        return Furance;
    }
}
