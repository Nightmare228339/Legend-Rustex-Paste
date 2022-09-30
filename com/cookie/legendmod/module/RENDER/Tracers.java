//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import com.cookie.legendmod.module.COMBAT.*;
import com.cookie.legendmod.utils.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Tracers extends Module
{
    public Tracers() {
        super("Tracers", 0, Module.Category.RENDER);
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent e) {
        for (final EntityPlayer playerEntity : Tracers.mc.world.playerEntities) {
            if (playerEntity != null && playerEntity != Tracers.mc.player && playerEntity.getDistance((Entity)Tracers.mc.player) <= 256.0f) {
                if (AntiBot.check(playerEntity)) {
                    continue;
                }
                if (!FriendManager.friendsList.contains(playerEntity.getName())) {
                    RenderUtils.trace(Tracers.mc, (Entity)playerEntity, Tracers.mc.getRenderPartialTicks(), 0);
                }
                else {
                    RenderUtils.trace(Tracers.mc, (Entity)playerEntity, Tracers.mc.getRenderPartialTicks(), 1);
                }
            }
        }
    }
}
