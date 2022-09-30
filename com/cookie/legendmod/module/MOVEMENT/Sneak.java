//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Sneak extends Module
{
    private static boolean snek;
    private static int pop;
    private boolean pope;
    
    public Sneak() {
        super("Sneak", 0, Module.Category.MOVEMENT);
        this.pope = false;
    }
    
    @SubscribeEvent
    public void onPlayerTick(final InputUpdateEvent event) {
        if (event.getEntityPlayer().isSneaking() && !this.pope) {
            this.pope = true;
            toggleop();
        }
        else if (!event.getEntityPlayer().isSneaking()) {
            this.pope = false;
        }
        event.getMovementInput().sneak = Sneak.snek;
        if (Sneak.snek) {
            event.getMovementInput().moveForward /= 1.8f;
            event.getMovementInput().moveStrafe /= 1.8f;
        }
        Sneak.pop = 0;
    }
    
    private static void toggleop() {
        if (Sneak.pop == 0) {
            Sneak.snek = !Sneak.snek;
            ++Sneak.pop;
        }
    }
    
    static {
        Sneak.snek = false;
        Sneak.pop = 0;
    }
}
