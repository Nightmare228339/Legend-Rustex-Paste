//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import com.cookie.legendmod.utils.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.awt.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class AutoReload extends Module
{
    private Entity entity;
    public TimerUtils timer;
    public static boolean iscontrol;
    
    public AutoReload() {
        super("AutoReload", 0, Category.COMBAT);
        this.timer = new TimerUtils();
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        final ItemStack item = AutoReload.mc.player.getHeldItemMainhand();
        if (item != ItemStack.EMPTY && item.getItem() == Items.DIAMOND_AXE && item.getCount() < 2) {
            if (AutoReload.iscontrol) {
                return;
            }
            try {
                final Robot r = new Robot();
                r.keyPress(81);
                r.keyRelease(81);
            }
            catch (Throwable t) {}
        }
    }
    
    @Override
    public void onDisable() {
        AutoReload.iscontrol = false;
        super.onDisable();
    }
    
    static {
        AutoReload.iscontrol = false;
    }
}
