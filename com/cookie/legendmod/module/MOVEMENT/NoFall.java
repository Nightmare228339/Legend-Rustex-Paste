//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class NoFall extends Module
{
    public NoFall() {
        super("NoFall", 0, Module.Category.MOVEMENT);
    }
    
    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (NoFall.mc.world != null && NoFall.mc.player.fallDistance > 2.0f) {
            NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
        }
    }
    
    public void onDisable() {
        super.onDisable();
    }
}
