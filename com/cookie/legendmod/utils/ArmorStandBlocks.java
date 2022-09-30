//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.item.*;

public class ArmorStandBlocks
{
    public static ItemStack getSmallBox() {
        final ItemStack SmallBox = new ItemStack(Items.DIAMOND_HOE, 1, 55);
        try {
            SmallBox.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
        }
        catch (Throwable t) {}
        try {
            SmallBox.setItemFrame((EntityItemFrame)null);
        }
        catch (Throwable t2) {}
        return SmallBox;
    }
    
    public static ItemStack getShkaf() {
        ItemStack Shkaf = Shkaf = new ItemStack(Items.DIAMOND_HOE, 1, 56);
        try {
            Shkaf.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
        }
        catch (Throwable t) {}
        try {
            Shkaf.setItemFrame((EntityItemFrame)null);
        }
        catch (Throwable t2) {}
        return Shkaf;
    }
    
    public static ItemStack getBigBox() {
        final ItemStack BigBox = new ItemStack(Items.DIAMOND_HOE, 1, 60);
        try {
            BigBox.setTagCompound(JsonToNBT.getTagFromJson("{Unbreakable:1b}"));
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
