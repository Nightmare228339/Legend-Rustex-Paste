//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import com.cookie.legendmod.module.MISC.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Sprint extends Module
{
    public Sprint() {
        super("Sprint", 34, Module.Category.MOVEMENT);
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        if (this.toggled && Sprint.mc.player.moveForward > 0.0f && !Sprint.mc.player.collidedHorizontally && !Panic.isPanic) {
            Sprint.mc.player.setSprinting(true);
            Sprint.mc.player.isSprinting();
        }
    }
}
