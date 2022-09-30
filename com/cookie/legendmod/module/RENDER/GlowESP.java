//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import com.cookie.legendmod.module.COMBAT.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.util.*;

public class GlowESP extends Module
{
    private static List<Entity> glowed;
    
    public GlowESP() {
        super("GlowESP", 0, Module.Category.RENDER);
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent e) {
        for (final EntityPlayer playerEntity : GlowESP.mc.world.playerEntities) {
            if (playerEntity != GlowESP.mc.player && playerEntity != GlowESP.glowed && playerEntity.getDistance((Entity)GlowESP.mc.player) <= 256.0f) {
                if (AntiBot.check(playerEntity)) {
                    continue;
                }
                playerEntity.setGlowing(true);
                GlowESP.glowed.add((Entity)playerEntity);
            }
        }
    }
    
    public void onDisable() {
        for (final Entity entity : GlowESP.glowed) {
            entity.setGlowing(false);
        }
        GlowESP.glowed.clear();
        super.onDisable();
    }
    
    static {
        GlowESP.glowed = new ArrayList<Entity>();
    }
}
