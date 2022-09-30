//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.PLAYER;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.attributes.*;

public class BlockReach extends Module
{
    public BlockReach() {
        super("BlockReach", 0, Module.Category.PLAYER);
    }
    
    public void onEnable() {
        final EntityPlayer player = (EntityPlayer)BlockReach.mc.player;
        final IAttributeInstance setBlockReachDi = player.getEntityAttribute(EntityPlayer.REACH_DISTANCE);
        player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).applyModifier(new AttributeModifier(player.getUniqueID(), "custom_reach", 0.5, 1));
    }
    
    public void onDisable() {
        BlockReach.mc.player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).removeModifier(BlockReach.mc.player.getUniqueID());
    }
}
