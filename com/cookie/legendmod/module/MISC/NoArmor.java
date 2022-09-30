//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class NoArmor extends Module
{
    public NoArmor() {
        super("NoArmor", 0, Category.MISC);
    }
    
    @SubscribeEvent
    public void onRenderWorldLast(final TickEvent.RenderTickEvent event) {
        if (NoArmor.mc.world == null) {
            return;
        }
        for (final EntityPlayer player : NoArmor.mc.world.playerEntities) {
            if (player != NoArmor.mc.player) {
                player.inventory.armorInventory.clear();
            }
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
}
